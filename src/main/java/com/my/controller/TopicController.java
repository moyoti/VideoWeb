package com.my.controller;

import com.my.pojo.Topic;
import com.my.pojo.User;
import com.my.service.TopicService;
import com.my.service.UsersService;
import com.my.service.UsersTopicService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: dongqihang
 * @Date: Created in 11:05 2018/10/9
 */
@RequestMapping(value = "/topic")
@RestController
public class TopicController {
    private static Logger logger= LoggerFactory.getLogger(TopicController.class);
    @Autowired
    private TopicService topicService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersTopicService usersTopicService;

    @RequestMapping(value = "/{tid}",method = RequestMethod.GET)
    public Topic showTopic(@PathVariable("tid") int tid){
        return topicService.getTopicById(tid);
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int subTopic(HttpServletRequest request, @Param(value = "title") String title,
                        @Param(value = "content") String content){
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        User user=usersService.findByUsername(username);
        try{
            Topic topic=new Topic();
            topic.setContent(content);
            topic.setTitle(title);
            topicService.addTopic(topic);
            usersTopicService.addUsersTopicRe(user.getId(),topic.getId());
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
