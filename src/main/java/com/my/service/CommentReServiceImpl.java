package com.my.service;

import com.my.dao.CommentMapper;
import com.my.dao.CommentRelationMapper;
import com.my.pojo.Comment;
import com.my.pojo.CommentRelation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dongqihang
 * @Date: Created in 16:16 2018/11/12
 */
@Service
@MapperScan("com.my.dao")
public class CommentReServiceImpl implements CommentReService {
    @Autowired
    private CommentRelationMapper commentRelationMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int addCommentRe(CommentRelation commentRelation) {
        commentRelationMapper.insert(commentRelation);
        return 1;
    }

    @Override
    public List<Comment> getCRByPage(int cid, int curPage, int pageSize) throws Exception {
        List<CommentRelation> commentRelationList;
        List<Comment> comments=new ArrayList<>();
        Map<String,Object> cMap=new HashMap<>();
        cMap.put("pid",cid);
        cMap.put("curIndex", (curPage - 1) * pageSize);
        cMap.put("pageSize", pageSize);
        commentRelationList = commentRelationMapper.queryByPage(cMap);
        for(CommentRelation item:commentRelationList){
            comments.add(commentMapper.selectByPrimaryKey(item.getChildId()));
        }
        return comments;
    }

}
