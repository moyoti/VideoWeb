package com.my.service;

import com.my.dao.CommentMapper;
import com.my.dao.CommentVideoMapper;
import com.my.pojo.Comment;
import com.my.pojo.CommentExample;
import com.my.pojo.CommentVideo;
import com.my.pojo.CommentVideoExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dongqihang
 * @Date: Created in 11:11 2018/10/9
 */
@Service
@MapperScan("com.my.dao")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentVideoMapper commentVideoMapper;

    @Override
    public int addComment(Comment comment) {
        commentMapper.insert(comment);
        return 1;
    }

    @Override
    public List<Comment> getCommentsOfVideo(int vid) {
        List<Comment> comments = null;
        CommentExample commentExample = new CommentExample();
        CommentVideoExample commentVideoExample = new CommentVideoExample();
        commentVideoExample.or().andVideoIdEqualTo(vid);
        List<CommentVideo> commentVideoList = commentVideoMapper.selectByExample(commentVideoExample);
        List<Integer> cids = new ArrayList<>();
        for (CommentVideo commentVideo : commentVideoList) {
            cids.add(commentVideo.getCommentId());
        }
        commentExample.or().andIdIn(cids);
        comments = commentMapper.selectByExample(commentExample);
        return comments;
    }

    @Override
    public List<Comment> getCommentsOfVideoByPage(int vid, int currPage, int pageSize) throws Exception {
        List<Integer> cids=new ArrayList<>();
        CommentExample commentExample = new CommentExample();
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("vid", vid);
        pageMap.put("curIndex", (currPage - 1) * pageSize);
        pageMap.put("pageSize", pageSize);
        List<CommentVideo> commentVideoList = commentVideoMapper.queryByPage(pageMap);
        for(CommentVideo item:commentVideoList){
            cids.add(item.getId());
        }
        commentExample.or().andIdIn(cids);
        return commentMapper.selectByExample(commentExample);
    }
}
