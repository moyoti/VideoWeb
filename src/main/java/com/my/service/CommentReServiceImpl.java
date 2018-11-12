package com.my.service;

import com.my.dao.CommentRelationMapper;
import com.my.pojo.CommentRelation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 16:16 2018/11/12
 */
@Service
@MapperScan("com.my.dao")
public class CommentReServiceImpl implements CommentReService {
    @Autowired
    private CommentRelationMapper commentRelationMapper;
    @Override
    public int addCommentRe(CommentRelation commentRelation) {
        commentRelationMapper.insert(commentRelation);
        return 1;
    }
}
