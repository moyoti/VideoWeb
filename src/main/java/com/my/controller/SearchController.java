package com.my.controller;

import com.my.service.SearchVideoService;
import com.my.util.BilibiliVideoCrawler;
import com.my.util.SionVideoCrawler;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 20:08 2018/12/19
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private SearchVideoService searchVideoService;
    @RequestMapping(value = "/s",method = RequestMethod.GET)
    public List searchKeyword(@RequestParam(value = "keyword") String keyword,@RequestParam(value = "page")int page, HttpServletRequest request){
        List sionBlog=SionVideoCrawler.fetchVideoUrl("https://s.weibo.com/video?q="+keyword+"&hasvideo=1&tw=video&page="+page);
        return sionBlog;
    }
    @RequestMapping(value = "/sn",method = RequestMethod.POST)
    public List searchByKeyword(@Param(value = "keyword") String keyword,HttpServletRequest request){
        Integer pageNum= Integer.parseInt(request.getParameter("page"));
        return searchVideoService.searchByKeyword(keyword,pageNum);
    }
    @RequestMapping(value = "/sb",method = RequestMethod.POST)
    public List searchInBilibili(@RequestParam(value = "keyword") String keyword,@RequestParam(value = "page")int page){
        List bilibilivideos= BilibiliVideoCrawler.fetchVideoUrl("https://search.bilibili.com/all?keyword="+keyword+"&page="+page);
        return bilibilivideos;
    }
}
