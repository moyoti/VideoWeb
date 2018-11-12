package com.my.service;

import com.my.pojo.User;

public interface UsersService {
    int addUser(User users);
//    User findAllUsers(int id);
    User findByUsername(String username);
    int usernameCheck(String username);
    int verifyEmail(String email);
}
