package com.my.service;

import com.my.pojo.User;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 21:40 2019/1/3
 */
public interface FollowUserService {
    List<User> getBeFollowedUser(int puid);
    List<User> getFollowUser(int puid);
    int followUser(int puid,int fuid);
    int cancelFollowUser(int puid,int fuid);
}
