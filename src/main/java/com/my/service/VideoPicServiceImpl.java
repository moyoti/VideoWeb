package com.my.service;

import com.my.dao.PicVideoMapper;
import com.my.pojo.PicVideo;
import com.my.pojo.PicVideoExample;
import com.my.util.FileTransferClient;
import com.my.util.PicTransferClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 13:16 2018/11/14
 */
@Service
@MapperScan("com.my.dap")
public class VideoPicServiceImpl implements VideoPicService {
    @Autowired
    private PicVideoMapper picVideoMapper;
    @Override
    public int addVideoPic(PicVideo picVideo, MultipartFile multipartFile, String targetURL, String fileName) throws Exception {
        File tarFile = new File(targetURL, fileName);
        multipartFile.transferTo(tarFile);
        PicTransferClient client=new PicTransferClient();
        client.sendFile(tarFile);
        picVideoMapper.insert(picVideo);
        return 0;
    }
    @Override
    public int updatePicOfVideo(PicVideo picVideo) {
        return picVideoMapper.updateByPrimaryKey(picVideo);
    }

    @Override
    public PicVideo getByVideoId(int id) {
        PicVideoExample picVideoExample=new PicVideoExample();
        picVideoExample.or().andVideoidEqualTo(id);
        List<PicVideo> re=picVideoMapper.selectByExample(picVideoExample);
        if(re.isEmpty()){
            return null;
        }
        return re.get(0);
    }
}
