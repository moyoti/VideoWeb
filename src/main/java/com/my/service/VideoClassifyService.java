package com.my.service;

import com.my.pojo.VideoClassify;

/**
 * @Author: dongqihang
 * @Date: Created in 19:49 2018/12/8
 */
public interface VideoClassifyService {
    int insert(VideoClassify videoClassify);
    int update(VideoClassify videoClassify);
    int delete(VideoClassify videoClassify);
}
