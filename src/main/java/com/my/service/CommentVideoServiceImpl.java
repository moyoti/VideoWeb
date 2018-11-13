package com.my.service;

import com.my.dao.CommentVideoMapper;
import com.my.pojo.CommentVideo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 21:52 2018/11/12
 */
@Service
@MapperScan("com.my.dao")
public class CommentVideoServiceImpl implements CommentVideoService {
    @Autowired
    private CommentVideoMapper commentVideoMapper;
    @Override
    public int addCommentVideo(CommentVideo commentVideo) {
        commentVideoMapper.insert(commentVideo);
        return 1;
    }
}
