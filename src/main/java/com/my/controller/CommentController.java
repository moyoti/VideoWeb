package com.my.controller;

import com.my.pojo.*;
import com.my.service.CommentReService;
import com.my.service.CommentService;
import com.my.service.CommentVideoService;
import com.my.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 15:00 2018/11/12
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    private static Logger logger= LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CommentReService commentReService;
    @Autowired
    private CommentVideoService commentVideoService;

    @RequestMapping(value = "/getVideoComments",method = RequestMethod.POST)
    //每页大小为6，写死
    public List<CommentGroup> getVideoComments(@Param("vid") int vid,@Param("page")int page){
        List<Comment> comments;//评论
        List<CommentGroup> cgComments=new ArrayList<>();//评论组
        try {
            comments=commentService.getCommentsOfVideoByPage(vid,page,6);
            for(Comment item:comments){
                List<Comment> cComments;//评论的评论
                List<CommentItem> ciComments=new ArrayList<>();//单个追评
                cComments=commentReService.getCRByPage(item.getId(),1,3);
                for (Comment citem:cComments){
                    User user=usersService.fundUserById(citem.getFromUid());
                    CommentItem commentItem=new CommentItem();
                    commentItem.setComment(citem);
                    commentItem.setUsername(user.getUsername());
                    ciComments.add(commentItem);
                }
                cComments.clear();
                User user=usersService.fundUserById(item.getFromUid());
                CommentGroup commentGroup=new CommentGroup();
                commentGroup.setcComment(ciComments);
                commentGroup.setpComment(item);
                commentGroup.setUsername(user.getUsername());
                commentGroup.setPicPath(user.getUserPic());
                cgComments.add(commentGroup);
            }
        } catch (BadSqlGrammarException e){
            System.out.println("no comments");
            cgComments=new ArrayList<>();
            return cgComments;
        } catch (Exception e) {
            e.printStackTrace();
            cgComments=new ArrayList<>();
            return cgComments;
        }
        return cgComments;
    }
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
        logger.info(user.getUsername()+" comment : "+content);
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
        logger.info(user.getUsername()+" comment : "+content);
        return 1;
    }
    @RequestMapping(value = "/getSubComment",method = RequestMethod.POST)
    public List getSubComments(@Param("cid") int cid,@Param("page") int page){
        List<Comment> cComments=null;
        List<CommentItem> ciComments=new ArrayList<>();
        try {
            cComments=commentReService.getCRByPage(cid,page,3);
            for(Comment item:cComments){
                CommentItem ci=new CommentItem();
                ci.setComment(item);
                User user=usersService.fundUserById(item.getFromUid());
                ci.setUsername(user.getUsername());
                ciComments.add(ci);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ciComments;
    }
}
