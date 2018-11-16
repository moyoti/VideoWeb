package com.my.service;

import com.my.dao.TopicMapper;
import com.my.pojo.Topic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 11:09 2018/10/9
 */
@Service
@MapperScan("com.my.dao")
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;
    @Override
    public int addTopic(Topic topic) {
        topicMapper.insert(topic);
        return 1;
    }

    @Override
    public Topic getTopicById(int id) {
        return topicMapper.selectByPrimaryKey(id);
    }
}
