package com.my.controller;

import com.my.pojo.PicVideo;
import com.my.pojo.User;
import com.my.pojo.UserVideo;
import com.my.pojo.Video;
import com.my.service.*;
import com.my.util.FileTransferClient;
import com.my.util.UUIDTool;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @Author: dongqihang
 * @Date: Created in 9:56 2018/10/15
 */
@RestController
@RequestMapping(value = "/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private UserVideoService userVideoService;
    @Autowired
    private VideoPicService videoPicService;

    @RequestMapping(value = "/{vid}", method = RequestMethod.GET)
    public Video showVideo(@PathVariable(value = "vid") int vid, HttpServletResponse response) {
        Video video = videoService.getVideoById(vid);
        if (video == null) {
            video=new Video();
            video.setId(0);
            return video;
        }
        return video;
    }

    //    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public int uploadVideo(HttpServletRequest request, MultipartFile file){
//        String targetURL="D:\\Program Files\\qqp\\994308383\\FileRecv\\MobileFile\\VideoPart\\out\\artifacts\\VideoPart_war_exploded\\video";
//        String title = request.getParameter("title");
//        Video video = new Video();
//        video.setTitle(title);
//        video.setVideoPath(targetURL);
//        return videoService.addVideo(video,file, targetURL);
//    }
    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    public String PicUpload(MultipartFile file, @Param("vid") int vid) {
        String fileName = UUIDTool.getUUID() + file.getOriginalFilename();
        String path = "D:\\upload\\pic";
        PicVideo picVideo = new PicVideo();
        picVideo.setVideoid(vid);
        picVideo.setPicpath(fileName);
        try {
            videoPicService.addVideoPic(picVideo, file, path, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public @ResponseBody
    String vUpload(MultipartFile file, HttpServletRequest request, @Param(value = "title") String title) {
        String path;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        path = "D:\\upload\\video";
        String fileName = UUIDTool.getUUID() + file.getOriginalFilename();
        Video video = new Video();
        video.setVideoPath(fileName);
        video.setTitle(title);
        try {
            videoService.addVideo(video, file, path, fileName);
            User user = usersService.findByUsername(username);
            UserVideo userVideo = new UserVideo();
            userVideo.setUserid(user.getId());
            userVideo.setVideoid(video.getId());
            userVideoService.addUserVideoService(userVideo);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            File ioFile =null;
//            if(!file.isEmpty()){
//                CommonsMultipartFile commonsMultipartFile=(CommonsMultipartFile) file;
//                DiskFileItem diskFileItem=(DiskFileItem) commonsMultipartFile.getFileItem();
//                ioFile=diskFileItem.getStoreLocation();
//            }
//            FileTransferClient client = new FileTransferClient();
//            client.sendFile(ioFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int itemid=Integer.valueOf(request.getParameter("iid"));
        return "success";
    }
}
