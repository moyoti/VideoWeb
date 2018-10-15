package com.my.service;

import com.my.dao.TopicMapper;
import com.my.pojo.Topic;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: dongqihang
 * @Date: Created in 11:09 2018/10/9
 */
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;
    @Override
    public int addTopic(Topic topic) {
        topicMapper.insert(topic);
        return 1;
    }
}
