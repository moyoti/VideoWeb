package com.my.controller;

import com.my.pojo.Comment;
import com.my.pojo.CommentRelation;
import com.my.pojo.CommentVideo;
import com.my.pojo.User;
import com.my.service.CommentReService;
import com.my.service.CommentService;
import com.my.service.CommentVideoService;
import com.my.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: dongqihang
 * @Date: Created in 15:00 2018/11/12
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CommentReService commentReService;
    @Autowired
    private CommentVideoService commentVideoService;
    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public int subComment(HttpServletRequest request, @Param(value = "content")String content,@Param(value = "vid") int vid){
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
//        String username="username1";
        User user=usersService.findByUsername(username);
        Comment comment=new Comment();
        comment.setContent(content);
        comment.setFromUid(user.getId());
        commentService.addComment(comment);
        CommentVideo commentVideo=new CommentVideo();
        commentVideo.setCommentId(comment.getId());
        commentVideo.setVideoId(vid);
        commentVideoService.addCommentVideo(commentVideo);
        return 1;
    }
    @RequestMapping(value = "/apdComment", method = RequestMethod.POST)
    public int apdComment(HttpServletRequest request,@Param(value = "content") String content,@Param(value = "pcid") int pcid){
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("username");
//        String username="username1";
        User user=usersService.findByUsername(username);
        Comment comment=new Comment();
        comment.setContent(content);
        comment.setFromUid(user.getId());
        commentService.addComment(comment);
        CommentRelation commentRelation=new CommentRelation();
        commentRelation.setParentId(pcid);
        commentRelation.setChildId(comment.getId());
        commentReService.addCommentRe(commentRelation);
        return 1;
    }
}
