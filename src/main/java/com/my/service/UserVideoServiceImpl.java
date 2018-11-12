package com.my.service;

import com.my.dao.UserVideoMapper;
import com.my.pojo.UserVideo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 14:33 2018/11/12
 */
@Service
@MapperScan("comm.my.dao")
public class UserVideoServiceImpl implements UserVideoService {
    @Autowired
    private UserVideoMapper userVideoMapper;
    @Override
    public int addUserVideoService(UserVideo userVideo) {
        try{
            userVideoMapper.insert(userVideo);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
