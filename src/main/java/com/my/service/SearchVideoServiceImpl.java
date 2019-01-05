package com.my.service;

import com.github.pagehelper.PageHelper;
import com.my.dao.PicVideoMapper;
import com.my.dao.VideoMapper;
import com.my.pojo.PicVideo;
import com.my.pojo.SearchItem;
import com.my.pojo.Video;
import com.my.pojo.VideoExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 22:21 2018/12/19
 */
@Service
@MapperScan("com.my.dao")
public class SearchVideoServiceImpl implements SearchVideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoPicService videoPicService;
    @Override
    public List searchByKeyword(String keyword,Integer pageNum) {
        VideoExample videoExample=new VideoExample();
        videoExample.or().andTitleLike("%"+keyword+"%");
        PageHelper.startPage(pageNum,20);
        List<Video> videos=videoMapper.selectByExample(videoExample);
        List<SearchItem> re=new ArrayList();
        for (Video item : videos) {
            PicVideo picVideo=videoPicService.getByVideoId(item.getId());
            SearchItem searchItem=new SearchItem();
            if(picVideo!=null){
                searchItem.setPicSrc(picVideo.getPicpath());
            }else {
                searchItem.setPicSrc("default.jpg");
            }
            searchItem.setVideo(item);
            re.add(searchItem);
        }
        return re;
    }
}
