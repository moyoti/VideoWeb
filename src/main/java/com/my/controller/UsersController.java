package com.my.controller;

import com.my.pojo.User;
import com.my.service.UsersService;
import com.my.util.EncodeMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: dongqihang
 * @Date: Created in 10:06 2018/10/8
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public int usersSignUp(HttpServletRequest request) throws Exception {
        User user = new User();
        String username = request.getParameter("username");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String password = EncodeMD5.encode(request.getParameter("password"));
        String phone = request.getParameter("phone");
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUsername(username);
        user.setActive(0);
        usersService.addUser(user);
        return 1;
    }

    /***
     * 用户登录
     * @param request
     * @return 1-登陆成功；0-登录失败
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int usersLogin(HttpServletRequest request) throws Exception {
        String username=request.getParameter("username");
        String password= EncodeMD5.encode(request.getParameter("password"));
        String verifyCode=request.getParameter("vcode");
        HttpSession session=request.getSession();
        String vc= (String) session.getAttribute("vctext");
//        System.out.println(vc);
        User user=usersService.findByUsername(username);
        if(user!=null && password.equals(user.getPassword())&&verifyCode.equals(vc)){
            session.setAttribute("loginstats",1);
            session.setAttribute("username",username);
            return 1;
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
    public int usernameCheck(HttpServletRequest request){
        String username=request.getParameter("username");
        return usersService.usernameCheck(username);
    }
}