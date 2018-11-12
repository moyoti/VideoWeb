package com.my.service;

import com.my.dao.UserTopicMapper;
import com.my.pojo.UserTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 11:54 2018/11/12
 */
@Service
@MapperScan("com.my.dao")
public class UsersTopicServiceImpl implements UsersTopicService {
    @Autowired
    private UserTopicMapper userTopicMapper;
    @Override
    public int addUsersTopicRe(int userid, int topicid) {
        try{
            UserTopic userTopic=new UserTopic();
            userTopic.setTopicid(topicid);
            userTopic.setUserid(userid);
            userTopicMapper.insert(userTopic);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
