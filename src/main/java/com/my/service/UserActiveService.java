package com.my.service;

import com.my.pojo.UserActive;

/**
 * @Author: dongqihang
 * @Date: Created in 23:15 2018/11/12
 */
public interface UserActiveService {
    int addUserActive(UserActive userActive);
    UserActive getUserActiveByUid(int uid);
}
