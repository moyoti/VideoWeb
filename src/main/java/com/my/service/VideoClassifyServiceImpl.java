package com.my.service;

import com.my.dao.VideoClassifyMapper;
import com.my.pojo.VideoClassify;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 19:55 2018/12/8
 */
@Service
@MapperScan("comm.my.dao")
public class VideoClassifyServiceImpl implements VideoClassifyService {
    @Autowired
    private VideoClassifyMapper videoClassifyMapper;
    @Override
    public int insert(VideoClassify videoClassify) {
        return videoClassifyMapper.insert(videoClassify);
    }

    @Override
    public int update(VideoClassify videoClassify) {
        return videoClassifyMapper.updateByPrimaryKey(videoClassify);
    }

    @Override
    public int delete(VideoClassify videoClassify) {
        return videoClassifyMapper.deleteByPrimaryKey(videoClassify.getId());
    }
}
