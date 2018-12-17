package com.my.service;

import com.my.pojo.Video;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 14:08 2018/12/6
 */
public interface VideoLikeService {
    int insertLike(int uid,int vid);
    int cancelLike(int uid, int vid);
    List<Video> findVideoByUid(int uid);
    int likeStat(int uid,int vid);
}
