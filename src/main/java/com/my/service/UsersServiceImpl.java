package com.my.service;

import com.my.dao.UserMapper;
import com.my.pojo.User;
import com.my.util.EmailSender;
import com.my.util.UUIDTool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

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

    //返回1找到，返回0未找到
    @Override
    public int usernameCheck(String username) {
        return userMapper.checkUsername(username);
    }

    @Override
    public int verifyEmail(String email) {
        //todo 将activecode插入数据库
        try {
            String activeCode = UUIDTool.getUUID();
            String url = "http://localhost:8079/user?activecode=" + activeCode;
            String content = "进入如下网址激活:" + url;
            String title = "激活您的账号";
            EmailSender es = new EmailSender();
            es.setProperties("smtp.163.com", "25");
            es.setMessage("dqh_ql@163.com", title, content);
            es.setReceiver(new String[]{email});
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int userUpdatedByUid(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

}
