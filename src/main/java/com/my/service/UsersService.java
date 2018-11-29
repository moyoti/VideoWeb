package com.my.service;

import com.my.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UsersService {
    int addUser(User users);
//    User findAllUsers(int id);
    User findByUsername(String username);
    int usernameCheck(String username);
    int userUpdatedByUid(User user);
    User fundUserById(int uid);
    int userUpdatePic(User user, MultipartFile file,String targetURL,String fileName) throws Exception;
}
