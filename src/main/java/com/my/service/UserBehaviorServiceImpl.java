package com.my.service;

import com.my.dao.UserBehaviorMapper;
import com.my.pojo.UserBehavior;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 16:37 2018/12/11
 */
@Service
@MapperScan("com.my.dao")
public class UserBehaviorServiceImpl implements UserBehaviorService {
    private UserBehaviorMapper userBehaviorMapper;
    @Override
    public int add(UserBehavior userBehavior) {
        return userBehaviorMapper.insert(userBehavior);
    }
}
