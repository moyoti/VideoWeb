package com.my.service;

import com.my.pojo.Comment;
import com.my.pojo.CommentRelation;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 16:15 2018/11/12
 */
public interface CommentReService {
    int addCommentRe(CommentRelation commentRelation);
    List<Comment> getCRByPage(int cid, int curPage, int pageSize) throws Exception;
}
