package com.my.service;

import com.my.dao.FollowUserMapper;
import com.my.dao.UserMapper;
import com.my.pojo.FollowUser;
import com.my.pojo.FollowUserExample;
import com.my.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 21:41 2019/1/3
 */
@Service
@MapperScan("com.my.dao")
public class FollowUserServiceImpl implements FollowUserService {
    @Autowired
    private FollowUserMapper followUserMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    /**
     * 获得你关注的人
     */
    public List<User> getBeFollowedUser(int puid) {
        FollowUserExample followUserExample=new FollowUserExample();
        followUserExample.or().andPuidEqualTo(puid);
        List<FollowUser> followUsers=followUserMapper.selectByExample(followUserExample);
        List<User> users=new ArrayList<>();
        for(FollowUser fuser:followUsers){
            User user=userMapper.selectByPrimaryKey(fuser.getFuid());
            user.setPassword(null);
            users.add(user);
        }
        return users;
    }

    /**
     * 获得关注你的人
     * @param puid
     * @return
     */
    @Override
    public List<User> getFollowUser(int puid) {
        FollowUserExample followUserExample=new FollowUserExample();
        followUserExample.or().andFuidEqualTo(puid);
        List<FollowUser> followUsers=followUserMapper.selectByExample(followUserExample);
        List<User> users=new ArrayList<>();
        for(FollowUser puser:followUsers){
            User user=userMapper.selectByPrimaryKey(puser.getFuid());
            user.setPassword(null);
            users.add(user);
        }
        return users;
    }

    @Override
    public int followUser(int puid, int fuid) {
        FollowUser followUser=new FollowUser();
        followUser.setFuid(fuid);
        followUser.setPuid(puid);
        return followUserMapper.insert(followUser);
    }

    @Override
    public int cancelFollowUser(int puid, int fuid) {
        FollowUserExample followUserExample=new FollowUserExample();
        followUserExample.or().andFuidEqualTo(fuid).andPuidEqualTo(puid);
        return followUserMapper.deleteByExample(followUserExample);
    }
}
