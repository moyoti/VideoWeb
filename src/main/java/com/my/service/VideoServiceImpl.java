package com.my.service;

import com.my.dao.VideoMapper;
import com.my.pojo.Video;
import com.my.util.FileTransferClient;
import com.my.util.UUIDTool;
import org.apache.commons.io.FileUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: dongqihang
 * @Date: Created in 11:13 2018/10/9
 */
@Service
@MapperScan("com.my.dao")
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public int addVideo(Video video, MultipartFile file, String targetURL, String fileName) throws Exception {
//        String fileName= file.getOriginalFilename();
        System.out.println(targetURL);
        System.out.println(fileName);
//        String newPath="\\upload\\"+fileName;
        File tarFile = new File(targetURL, fileName);
//        try {
//            File ioFile=null;
//            FileUtils.copyInputStreamToFile(file.getInputStream(),ioFile);
//            FileTransferClient client=new FileTransferClient();
//            client.sendFile(ioFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //拒绝访问是因为下面创建了文件夹，也就是说文件夹不能作为文件访问
//        if(!tarFile.exists()){
//            tarFile.mkdirs();
//        }
//        Photo photo=new Photo();
//        photo.setItemid(itemid);
//        photo.setPath(newPath);
//        photo.setType("error");
//        photoDao.addPhoto(photo);
        file.transferTo(tarFile);
        FileTransferClient client=new FileTransferClient();
        client.sendFile(tarFile);
        videoMapper.insert(video);
        return 0;
    }

    @Override
    public Video getVideoById(int id) {
        return videoMapper.selectByPrimaryKey(id);
    }
}
