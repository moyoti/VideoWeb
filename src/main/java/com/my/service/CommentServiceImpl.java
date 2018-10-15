package com.my.service;

import com.my.dao.CommentMapper;
import com.my.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: dongqihang
 * @Date: Created in 11:11 2018/10/9
 */
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int addComment(Comment comment) {
        commentMapper.insert(comment);
        return 1;
    }
}
