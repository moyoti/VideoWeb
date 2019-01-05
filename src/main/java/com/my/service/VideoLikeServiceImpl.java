package com.my.service;

import com.my.dao.PicVideoMapper;
import com.my.dao.VideoLikeMapper;
import com.my.dao.VideoMapper;
import com.my.pojo.*;
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
    @Autowired
    private PicVideoMapper picVideoMapper;
    @Override
    public int insertLike(int uid, int vid) {
        VideoLikeExample videoLikeExample=new VideoLikeExample();
        videoLikeExample.or().andUidEqualTo(uid).andVidEqualTo(vid);
        List<VideoLike> videoLikes=videoLikeMapper.selectByExample(videoLikeExample);
        if(videoLikes.size()==1){
            return 0;
        }else {
            try{
                VideoLike videoLike=new VideoLike();
                videoLike.setUid(uid);
                videoLike.setVid(vid);
                return videoLikeMapper.insert(videoLike);
            }catch (Exception e){
                return 0;
            }
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
    public List findVideoByUid(int uid) {
        VideoLikeExample videoLikeExample=new VideoLikeExample();
        videoLikeExample.or().andUidEqualTo(uid);
        List<VideoLike> lvs=videoLikeMapper.selectByExample(videoLikeExample);
        List<Integer> vids=new ArrayList<>();
        if(lvs.isEmpty()){
            return null;
        }
        for(VideoLike item:lvs){
            vids.add(item.getVid());
        }
        PicVideoExample picVideoExample=new PicVideoExample();
        picVideoExample.or().andVideoidIn(vids);
        List<PicVideo> picVideos=picVideoMapper.selectByExample(picVideoExample);
        VideoExample videoExample=new VideoExample();
        videoExample.or().andIdIn(vids);
        List<Video> videos=videoMapper.selectByExample(videoExample);
        List<SearchItem> searchItems=new ArrayList<>();
        for(int i=0;i<picVideos.size();i++){
            for(int n=0;n<videos.size();n++){
                SearchItem searchItem=new SearchItem();
                searchItem.setVideo(videos.get(n));
                searchItem.setPicSrc(picVideos.get(i).getPicpath());
                searchItems.add(searchItem);
            }
        }
        return searchItems;
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
