package com.my.service;

import com.my.dao.VideoMapper;
import com.my.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: dongqihang
 * @Date: Created in 11:13 2018/10/9
 */
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public int addVideo(Video video) {
        videoMapper.insert(video);
        return 1;
    }
}
