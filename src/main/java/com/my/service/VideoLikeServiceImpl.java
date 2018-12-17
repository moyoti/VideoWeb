package com.my.service;

import com.my.dao.VideoLikeMapper;
import com.my.dao.VideoMapper;
import com.my.pojo.Video;
import com.my.pojo.VideoExample;
import com.my.pojo.VideoLike;
import com.my.pojo.VideoLikeExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 14:09 2018/12/6
 */
@Service
@MapperScan("com.my.dap")
public class VideoLikeServiceImpl implements VideoLikeService {
    @Autowired
    private VideoLikeMapper videoLikeMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public int insertLike(int uid, int vid) {
        try{
            VideoLike videoLike=new VideoLike();
            videoLike.setUid(uid);
            videoLike.setVid(vid);
            return videoLikeMapper.insert(videoLike);
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int cancelLike(int uid, int vid) {
        try{
            VideoLikeExample videoLikeExample=new VideoLikeExample();
            videoLikeExample.or().andUidEqualTo(uid).andVidEqualTo(vid);
            return videoLikeMapper.deleteByExample(videoLikeExample);
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<Video> findVideoByUid(int uid) {
        VideoLikeExample videoLikeExample=new VideoLikeExample();
        videoLikeExample.or().andUidEqualTo(uid);
        List<VideoLike> lvs=videoLikeMapper.selectByExample(videoLikeExample);
        List<Integer> vids=new ArrayList<>();
        for(VideoLike item:lvs){
            vids.add(item.getVid());
        }
        VideoExample videoExample=new VideoExample();
        videoExample.or().andIdIn(vids);
        List<Video> videos=videoMapper.selectByExample(videoExample);
        return videos;
    }

    @Override
    public int likeStat(int uid, int vid) {
        VideoLikeExample videoLikeExample=new VideoLikeExample();
        videoLikeExample.or().andUidEqualTo(uid).andVidEqualTo(vid);
        List<VideoLike> videoLikes=videoLikeMapper.selectByExample(videoLikeExample);
        if(videoLikes.size()==1){
            return 1;
        }
        return 0;
    }
}
