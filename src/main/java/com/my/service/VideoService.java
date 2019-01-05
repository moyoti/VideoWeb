package com.my.service;

import com.my.pojo.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 11:13 2018/10/9
 */
public interface VideoService {
    int addVideo(Video video, MultipartFile file, String targetURL,String fileName) throws Exception;
    Video getVideoById(int id);
    Video addVideoRecord(String srcURL);
}
