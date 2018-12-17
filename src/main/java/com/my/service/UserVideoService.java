package com.my.service;

import com.my.pojo.User;
import com.my.pojo.UserVideo;

/**
 * @Author: dongqihang
 * @Date: Created in 14:32 2018/11/12
 */
public interface UserVideoService {
    int addUserVideoService(UserVideo userVideo);
    User findUserByVid(int vid);
}
