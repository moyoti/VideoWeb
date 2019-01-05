package com.my.service;

import com.my.controller.VideoController;
import com.my.dao.VideoWatchMapper;
import com.my.pojo.VideoWatch;
import com.my.pojo.VideoWatchExample;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 10:12 2018/12/25
 */
@Service
@MapperScan("com.my.dao")
public class VideoWatchServiceImpl implements VideoWatchService {
    private static Logger logger= LoggerFactory.getLogger(VideoController.class);
    @Autowired
    private VideoWatchMapper videoWatchMapper;
    @Override
    public int userWatch(int vid) {
        VideoWatchExample videoWatchExample=new VideoWatchExample();
        videoWatchExample.or().andVidEqualTo(vid);
        VideoWatch videoWatch;
        try {
            videoWatch = videoWatchMapper.selectByExample(videoWatchExample).get(0);
            int watchTimes=videoWatch.getWatchTimes();
            watchTimes++;
            videoWatch.setWatchTimes(watchTimes);
            videoWatchMapper.updateByPrimaryKey(videoWatch);
        }catch (IndexOutOfBoundsException e){
            logger.info("无相关视频观看历史");
            videoWatch=new VideoWatch();
            videoWatch.setVid(vid);
            videoWatch.setWatchTimes(1);
            videoWatchMapper.insert(videoWatch);
        }
        return videoWatch.getWatchTimes();
    }
}
