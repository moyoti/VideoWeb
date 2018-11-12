package com.my.service;

import com.my.dao.CommentMapper;
import com.my.pojo.Comment;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 11:11 2018/10/9
 */
@Service
@MapperScan("com.my.dao")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int addComment(Comment comment) {
        commentMapper.insert(comment);
        return 1;
    }
}
