package com.my.controller;

import com.my.pojo.Video;
import com.my.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dongqihang
 * @Date: Created in 9:56 2018/10/15
 */
@RestController
@RequestMapping(value = "/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public int uploadVideo(HttpServletRequest request, MultipartFile file){
        String targetURL="";
        Video video = new Video();
        return videoService.addVideo(video,file, targetURL);
    }
}
