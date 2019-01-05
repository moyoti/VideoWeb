package com.my.controller;

import com.my.dao.VideoClassifyMapper;
import com.my.pojo.*;
import com.my.service.*;
import com.my.util.FileTransferClient;
import com.my.util.UUIDTool;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 9:56 2018/10/15
 */
@RestController
@RequestMapping(value = "/video")
public class VideoController {
    private static Logger logger = LoggerFactory.getLogger(VideoController.class);
    @Autowired
    private VideoService videoService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private UserVideoService userVideoService;
    @Autowired
    private VideoPicService videoPicService;
    @Autowired
    private VideoClassifyService videoClassifyService;
    @Autowired
    private UserBehaviorService userBehaviorService;
    @Autowired
    private BehaviorContextService behaviorContextService;
    @Autowired
    private VideoWatchService videoWatchService;
    @Autowired
    private FollowUserService followUserService;

    //    @RequestMapping(value = "/vcode",method = RequestMethod.GET)
//    public Video addVideoBySrc(@RequestParam(value = "vcode")String vcode){
//        return videoService.addVideoRecord(vcode);
//    }
    @RequestMapping(value = "/{vid}", method = RequestMethod.GET)
    public Video showVideo(@PathVariable(value = "vid") int vid, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Video video = videoService.getVideoById(vid);
        if (video == null) {
            video = new Video();
            video.setId(0);
            return video;
        }
//        String uid=(String)session.getAttribute("uid");
//        if(uid!=null){
//            BehaviorContext behaviorContext=new BehaviorContext();
//            behaviorContext.setIpAddress(request.getRemoteAddr());
//            UserBehavior userBehavior=new UserBehavior();
//            userBehavior.setBcontextid(behaviorContext.getId());
//            userBehavior.setUid(Integer.parseInt(uid));
//        }

        return video;
    }

    @RequestMapping(value = "/getwatches", method = RequestMethod.POST)
    public int getWatches(@Param(value = "vid") int vid) {
        return videoWatchService.userWatch(vid);
    }

    @RequestMapping(value = "getvideoimg", method = RequestMethod.POST)
    public PicVideo getVideoImg(@Param(value = "vid") int vid) {
        return videoPicService.getByVideoId(vid);
    }

    @RequestMapping(value = "/videouser", method = RequestMethod.POST)
    public User videoUser(@Param(value = "vid") int vid, HttpServletRequest request) {
        User user = userVideoService.findUserByVid(vid);
        if (user != null) {
            return user;
        } else {
            user = new User();
            user.setId(0);
            return user;
        }
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
    public int picUpload(@RequestParam(value = "myfile") MultipartFile file, @Param("vid") int vid) {
        String fileName = UUIDTool.getUUID() + file.getOriginalFilename();
        List<String> fileTypes = Arrays.asList("jpg", "png");
        String fileType = fileName.split("\\.")[1];
        if (!fileTypes.contains(fileType)) {
            return 0;
        }
        String path = "D:\\upload\\pic";
        PicVideo picVideo = new PicVideo();
        picVideo.setVideoid(vid);
        picVideo.setPicpath(fileName);
        try {
            videoPicService.addVideoPic(picVideo, file, path, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public @ResponseBody
    int vUpload(@RequestParam(value = "myfile") MultipartFile file, HttpServletRequest request, @Param(value = "title") String title, @Param(value = "content") String content,
//            ,@Param(value = "classify") int classify
                @RequestParam(value = "picfile") MultipartFile picfile
    ) {
        String path;
        List<String> fileTypes = Arrays.asList("mp4");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        path = "D:\\upload\\video";
        String fileName = UUIDTool.getUUID() + file.getOriginalFilename();
        String filetype = fileName.split("\\.")[1];
        if (!fileTypes.contains(filetype)) {
            return 0;
        }
        String picfileName = UUIDTool.getUUID() + picfile.getOriginalFilename();
        List<String> picfileTypes = Arrays.asList("jpg", "png");
        String picfileType = picfileName.split("\\.")[1];
        if (!picfileTypes.contains(picfileType)) {
            return 0;
        }
        String picpath = "D:\\upload\\pic";
        Video video = new Video();
        video.setVideoPath(fileName);
        video.setTitle(title);
        video.setVideoContent(content);
        try {
            videoService.addVideo(video, file, path, fileName);
            User user = usersService.findByUsername(username);
            UserVideo userVideo = new UserVideo();
            userVideo.setUserid(user.getId());
            userVideo.setVideoid(video.getId());
            userVideoService.addUserVideoService(userVideo);
            VideoClassify videoClassify = new VideoClassify();
            videoClassify.setVid(video.getId());
            videoClassify.setCid(1);
            videoClassifyService.insert(videoClassify);

            PicVideo picVideo = new PicVideo();
            picVideo.setVideoid(video.getId());
            picVideo.setPicpath(picfileName);
            try {
                videoPicService.addVideoPic(picVideo, picfile, picpath, picfileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }
    @RequestMapping(value = "/getUserVideo",method = RequestMethod.POST)
    public List getFollowUserVideo(HttpSession session){
        Integer uid= (Integer) session.getAttribute("uid");
        if(uid==null){
            return null;
        }
        List<User> follows=followUserService.getBeFollowedUser(uid);
        List<Integer> uids=new ArrayList<>();
        for(User i:follows){
            uids.add(i.getId());
        }
        List<UserVideo> videoids=userVideoService.findVideosByUid(uids);
        List re=new ArrayList();
        for (UserVideo i:videoids){
            SearchItem searchItem=new SearchItem();
            searchItem.setVideo(videoService.getVideoById(i.getVideoid()));
            searchItem.setPicSrc(videoPicService.getByVideoId(i.getVideoid()).getPicpath());
            re.add(searchItem);
        }
        return re;
    }
}
