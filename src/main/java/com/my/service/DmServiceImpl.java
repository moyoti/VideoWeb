package com.my.service;

import com.my.dao.DmContentMapper;
import com.my.pojo.DmContent;
import com.my.pojo.DmContentExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 14:34 2018/12/29
 */
@Service
@MapperScan("com.my.dao")
public class DmServiceImpl implements DmService {
    @Autowired
    private DmContentMapper dmContentMapper;
    @Override
    public int sendDm(DmContent dmContent) {
        return dmContentMapper.insert(dmContent);
    }

    @Override
    public List getDmByVid(int vid) {
        DmContentExample dmContentExample=new DmContentExample();
        dmContentExample.or().andVidEqualTo(vid);
        return dmContentMapper.selectByExample(dmContentExample);
    }
}
