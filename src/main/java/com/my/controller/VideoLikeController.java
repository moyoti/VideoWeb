package com.my.controller;

import com.my.pojo.Video;
import com.my.service.VideoLikeService;
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
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 14:17 2018/12/6
 */
@RestController
@RequestMapping(value = "/like")
public class VideoLikeController {
    private static Logger logger= LoggerFactory.getLogger(VideoLikeController.class);
    @Autowired
    private VideoLikeService videoLikeService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public int addLike(HttpSession session,@Param(value = "vid") int vid){
        Integer uid= (Integer) session.getAttribute("uid");
        if (uid==null){
            return 0;
        }else {
            return videoLikeService.insertLike(uid, vid);
        }
    }
    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    public int cancelLike(HttpSession session,@Param(value = "vid") int vid){
        Integer uid= (Integer) session.getAttribute("uid");
        if (uid==null){
            return 0;
        }else {
            return videoLikeService.cancelLike(uid, vid);
        }
    }
    @RequestMapping(value = "/likestat",method = RequestMethod.POST)
    public int likeStat(HttpSession session,@Param(value = "vid") int vid){
        Integer uid= (Integer) session.getAttribute("uid");
        if (uid==null){
            return 0;
        }else {
            return videoLikeService.likeStat(uid,vid);
        }

    }
    @RequestMapping(value = "/likevideos",method = RequestMethod.POST)
    public List likeVideos(HttpSession session){
        Integer uid= (Integer) session.getAttribute("uid");
        if (uid==null){
            return null;
        }
        List<Video> videos=videoLikeService.findVideoByUid(uid);
        if(videos==null){
            return null;
        }
        if (!videos.isEmpty()){
            return videos;
        }
        return null;
    }
}
