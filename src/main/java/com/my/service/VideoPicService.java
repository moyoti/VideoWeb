package com.my.service;

import com.my.pojo.PicVideo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: dongqihang
 * @Date: Created in 13:08 2018/11/14
 */
public interface VideoPicService {
    int addVideoPic(PicVideo picVideo, MultipartFile multipartFile,String targetURL,String fileName) throws Exception;
    int updatePicOfVideo(PicVideo picVideo);
    PicVideo getByVideoId(int id);
}
