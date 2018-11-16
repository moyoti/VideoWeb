package com.my.service;

import com.my.pojo.Comment;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 11:11 2018/10/9
 */
public interface CommentService {
    int addComment(Comment comment);
    List<Comment> getCommentsOfVideo(int vid);
    List<Comment> getCommentsOfVideoByPage(int vid,int currPage,int pageSize) throws Exception;
}
