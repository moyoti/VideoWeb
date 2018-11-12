package com.my.controller;

import com.my.pojo.User;
import com.my.pojo.UserVideo;
import com.my.pojo.Video;
import com.my.service.UserVideoService;
import com.my.service.UserVideoServiceImpl;
import com.my.service.UsersService;
import com.my.service.VideoService;
import com.my.util.FileTransferClient;
import com.my.util.UUIDTool;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    //    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public int uploadVideo(HttpServletRequest request, MultipartFile file){
//        String targetURL="D:\\Program Files\\qqp\\994308383\\FileRecv\\MobileFile\\VideoPart\\out\\artifacts\\VideoPart_war_exploded\\video";
//        String title = request.getParameter("title");
//        Video video = new Video();
//        video.setTitle(title);
//        video.setVideoPath(targetURL);
//        return videoService.addVideo(video,file, targetURL);
//    }
    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public @ResponseBody
    String testUpload(MultipartFile file, HttpServletRequest request, @Param(value = "title") String title) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        path = "D:\\upload\\pic";
        String fileName=UUIDTool.getUUID() + file.getOriginalFilename();
        Video video = new Video();
        video.setVideoPath("\\upload\\pic\\" + fileName);
        video.setTitle(title);
        try {
            videoService.addVideo(video, file, path, fileName);
            User user=usersService.findByUsername(username);
            UserVideo userVideo=new UserVideo();
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
