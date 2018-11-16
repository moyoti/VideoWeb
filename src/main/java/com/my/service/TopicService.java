package com.my.service;

import com.my.pojo.Topic;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 11:07 2018/10/9
 */
public interface TopicService {
    int addTopic(Topic topic);
    Topic getTopicById(int id);
}
