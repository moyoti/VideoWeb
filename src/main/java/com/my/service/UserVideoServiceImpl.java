package com.my.service;

import com.my.dao.UserMapper;
import com.my.dao.UserVideoMapper;
import com.my.pojo.User;
import com.my.pojo.UserVideo;
import com.my.pojo.UserVideoExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 14:33 2018/11/12
 */
@Service
@MapperScan("comm.my.dao")
public class UserVideoServiceImpl implements UserVideoService {
    @Autowired
    private UserVideoMapper userVideoMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUserVideoService(UserVideo userVideo) {
        try {
            userVideoMapper.insert(userVideo);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public User findUserByVid(int vid) {
        UserVideoExample userVideoExample = new UserVideoExample();
        userVideoExample.or().andVideoidEqualTo(vid);
        List<UserVideo> userVideos = userVideoMapper.selectByExample(userVideoExample);
        int uid;
        User user = null;
        try {
            uid = userVideos.get(0).getUserid();
            user = userMapper.selectByPrimaryKey(uid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (user != null) {
            return user;
        }
        return null;
    }
}
