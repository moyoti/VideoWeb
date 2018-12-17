package com.my.service;

import com.my.dao.ClassifyMapper;
import com.my.pojo.Classify;
import com.my.pojo.ClassifyExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 2:27 2018/12/9
 */
@Service
@MapperScan("com.my.dao")
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;
    @Override
    public Classify findById(int id) {
        return classifyMapper.selectByPrimaryKey(id);
    }
}
