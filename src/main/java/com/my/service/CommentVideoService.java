package com.my.service;

import com.my.pojo.CommentVideo;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 21:50 2018/11/12
 */
public interface CommentVideoService {
    int addCommentVideo(CommentVideo commentVideo);
    List<CommentVideo> getCVOfVidByPage(int vid,int currPage,int pageSize);
}
