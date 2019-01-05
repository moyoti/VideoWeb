package com.my.service;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 22:19 2018/12/19
 */
public interface SearchVideoService {
    List searchByKeyword(String keyword, Integer pageNum);
}
