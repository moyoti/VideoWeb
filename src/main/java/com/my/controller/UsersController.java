package com.my.controller;

import com.my.dao.UserVideoMapper;
import com.my.pojo.FollowUser;
import com.my.pojo.User;
import com.my.service.FollowUserService;
import com.my.service.UserVideoService;
import com.my.service.UsersService;
import com.my.util.EncodeMD5;
import com.my.util.UUIDTool;
import com.my.util.VerifyInfo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 10:06 2018/10/8
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    private static Logger logger= LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UsersService usersService;
    @Autowired
    private UserVideoService userVideoService;
    @Autowired
    private FollowUserService followUserService;

    @RequestMapping(value = "/follow",method = RequestMethod.POST)
    public int followUser(HttpSession session, HttpServletRequest request){
        Integer uid= (Integer) session.getAttribute("uid");
        String fuid=request.getParameter("fuid");
        if(uid==Integer.valueOf(fuid)){
            return 0;
        }
        return followUserService.followUser(uid,Integer.valueOf(fuid));
    }
    @RequestMapping(value="/cancelFollow",method = RequestMethod.POST)
    public int cancelFollow(HttpSession session, HttpServletRequest request){
        Integer uid= (Integer) session.getAttribute("uid");
        String fuid=request.getParameter("fuid");
        return followUserService.cancelFollowUser(uid,Integer.valueOf(fuid));
    }

    /**
     * 获得关注你的人
     * @param session
     * @return
     */
    @RequestMapping(value="/getFollowers",method = RequestMethod.POST)
    public List getAllFollowers(HttpSession session){
        Integer uid= (Integer) session.getAttribute("uid");
        return followUserService.getFollowUser(uid);
    }

    /**
     * 获得你关注的人
     * @param session
     * @return
     */
    @RequestMapping(value="/getFollowedUser",method = RequestMethod.POST)
    public List getFollowedUsers(HttpSession session){
        Integer uid= (Integer) session.getAttribute("uid");
        return followUserService.getBeFollowedUser(uid);
    }
    @RequestMapping(value = "/loginstats", method = RequestMethod.POST)
    public List userLoginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Object> loginStat = new ArrayList<>();
        String stats = String.valueOf(session.getAttribute("loginstats"));
        String username = (String) session.getAttribute("username");
        Integer uid=(Integer) session.getAttribute("uid");
        User user=usersService.findByUsername(username);
        if (stats.equals("1")||stats.equals("0")) {
            loginStat.add(stats);
            loginStat.add(username);
            loginStat.add(user.getNickname());
            loginStat.add(user.getUserPic());
            loginStat.add(uid);
            return loginStat;
        } else {
            return loginStat;
        }
    }
    @RequestMapping(value = "/updateinfo",method = RequestMethod.POST)
    public int updateinfo(HttpServletRequest request,HttpSession session){
        String username=(String) session.getAttribute("username");
        String newNickname=request.getParameter("nickname");
        try {
            User user=usersService.findByUsername(username);
            user.setNickname(newNickname);
            usersService.userUpdatedByUid(user);
            logger.info(user.getUsername()+": info updated");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(username+":user info update error");
            return 0;
        }
    }
    @RequestMapping(value = "/uploaduserpic",method = RequestMethod.POST)
    public int userPicUpload(@RequestParam(value = "myfile")MultipartFile file, HttpSession session){
        String fileName = UUIDTool.getUUID() + file.getOriginalFilename();
        String path = "D:\\upload\\pic";
        String username=(String)session.getAttribute("username");
        try {
            User user=usersService.findByUsername(username);
            usersService.userUpdatePic(user, file, path, fileName);
            logger.info(username+":upload userpic success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public int usersSignUp(HttpServletRequest request) throws Exception {
        User user = new User();
        HttpSession session = request.getSession();
        String vcode = (String) session.getAttribute("vctext");
        String username = request.getParameter("username");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String password = EncodeMD5.encode(request.getParameter("password"));
        String phone = request.getParameter("phone");
        String vc = request.getParameter("vcode");
        if(!vcode.toUpperCase().equals(vc.toUpperCase())){
            return 0;
        }
        if(!VerifyInfo.verifyUNOrPassForamt(username)){
            return 0;
        }
        if(!VerifyInfo.verifyUNOrPassForamt(password)){
            return 0;
        }
        if(!VerifyInfo.verifyEmailFormat(email)){
            return 0;
        }
        if(!VerifyInfo.verifyPhoneFormat(phone)){
            return 0;
        }
        if(!VerifyInfo.verifyUNOrPassForamt(nickname)){
            return 0;
        }
        int userCheck=1;
        try{
            userCheck=usersService.usernameCheck(username);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        if(userCheck==1){
            return 0;
        }
        if (vc.toUpperCase().equals(vcode.toUpperCase())) {
            user.setNickname(nickname);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhone(phone);
            user.setUsername(username);
            user.setActive(0);
            user.setUserPic("default.jpg");
            try{
                usersService.addUser(user);
                logger.info(user.getUsername()+":signup success");
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
            session.setAttribute("loginstats", Integer.toString(user.getActive()));
            session.setAttribute("username", username);
            session.setAttribute("userpic", user.getUserPic());
            session.setAttribute("nickname", user.getNickname());
            session.setAttribute("uid",user.getId());
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public int usersLogout(HttpSession session) {
        try{
            session.removeAttribute("loginstats");
            session.removeAttribute("username");
            session.removeAttribute("nickname");
            session.removeAttribute("userpic");
            session.removeAttribute("uid");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    /***
     * 用户登录
     * @param request
     * @return 1-登陆成功；0-登录失败
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int usersLogin(HttpServletRequest request) throws Exception {
        try {
            String username = request.getParameter("username");
            String password = EncodeMD5.encode(request.getParameter("password"));
            String verifyCode = request.getParameter("vcode");
            HttpSession session = request.getSession();
            String vc = (String) session.getAttribute("vctext");
//        System.out.println(vc);
            User user = usersService.findByUsername(username);
            if (user != null && password.equals(user.getPassword()) && verifyCode.toUpperCase().equals(vc.toUpperCase())) {
                session.setAttribute("loginstats", Integer.toString(user.getActive()));
                session.setAttribute("username", username);
                session.setAttribute("userpic", user.getUserPic());
                session.setAttribute("nickname", user.getNickname());
                session.setAttribute("uid",user.getId());
                logger.info(username+": login");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
//        System.out.println(user.getPassword());
        return 0;
    }

    /***
     * 检查重复用户名
     * @param request
     * @return 1-有重复；0-无重复
     */
    @RequestMapping(value = "/checkusername", method = RequestMethod.POST)
    public int usernameCheck(HttpServletRequest request) {
        String username = request.getParameter("username");
        return usersService.usernameCheck(username);
    }
    @RequestMapping(value = "/getUserByVid", method = RequestMethod.POST)
    public User getByVid(@Param(value = "vid") int vid){
        return userVideoService.findUserByVid(vid);
    }
}
