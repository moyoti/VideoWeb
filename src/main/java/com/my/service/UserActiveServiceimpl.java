package com.my.service;

import com.my.dao.UserActiveMapper;
import com.my.pojo.UserActive;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: dongqihang
 * @Date: Created in 23:59 2018/11/12
 */
@Service
@MapperScan("com.my.dao")
public class UserActiveServiceimpl implements UserActiveService{
    @Autowired
    private UserActiveMapper userActiveMapper;
    @Override
    public int addUserActive(UserActive userActive) {
        userActiveMapper.insert(userActive);
        return 1;
    }

    @Override
    public UserActive getUserActiveByUid(int uid) {
        return userActiveMapper.selectByUid(uid);
    }

    @Override
    public int deleteByUid(int uid) {
        return userActiveMapper.deleteByUid(uid);
    }

    @Override
    public int updateUserActive(UserActive userActive) {
        userActiveMapper.updateByPrimaryKey(userActive);
        return 1;
    }

}
