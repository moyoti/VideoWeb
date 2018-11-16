package com.my.service;

import com.my.dao.CommentVideoMapper;
import com.my.pojo.CommentVideo;
import com.my.pojo.CommentVideoExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dongqihang
 * @Date: Created in 21:52 2018/11/12
 */
@Service
@MapperScan("com.my.dao")
public class CommentVideoServiceImpl implements CommentVideoService {
    @Autowired
    private CommentVideoMapper commentVideoMapper;

    @Override
    public int addCommentVideo(CommentVideo commentVideo) {
        commentVideoMapper.insert(commentVideo);
        return 1;
    }

    @Override
    public List<CommentVideo> getCVOfVidByPage(int vid, int currPage, int pageSize) {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("vid", vid);
        pageMap.put("curIndex", (currPage-1)*pageSize);
        pageMap.put("pageSize", pageSize);
        return commentVideoMapper.queryByPage(pageMap);
    }
}
