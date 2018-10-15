package com.my.service;

import com.my.dao.UserMapper;
import com.my.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@MapperScan("com.my.dao")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User users) {

        return userMapper.insertSelective(users);
    }

//    @Override
//    public User findAllUsers(int id) {
//        return userMapper.selectByPrimaryKey(id);
//    }

    @Override
    public User findByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public int usernameCheck(String username) {
        return userMapper.checkUsername(username);
    }

}
