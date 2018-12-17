package com.my.service;

import com.my.dao.BehaviorContextMapper;
import com.my.pojo.BehaviorContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 16:23 2018/12/11
 */
@Service
@MapperScan("com.my.dao")
public class BehaviorContextServiceImpl implements BehaviorContextService {
    @Autowired
    private BehaviorContextMapper behaviorContextMapper;
    @Override
    public int add(BehaviorContext behaviorContext) {
        return behaviorContextMapper.insert(behaviorContext);
    }
}
