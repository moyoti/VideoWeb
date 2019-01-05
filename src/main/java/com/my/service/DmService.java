package com.my.service;

import com.my.pojo.DmContent;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 14:33 2018/12/29
 */
public interface DmService {
    int sendDm(DmContent dmContent);
    List getDmByVid(int vid);
}
