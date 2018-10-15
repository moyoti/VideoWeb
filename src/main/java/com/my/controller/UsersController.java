package com.my.controller;

import com.my.pojo.User;
import com.my.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dongqihang
 * @Date: Created in 10:06 2018/10/8
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String usersSignUp(HttpServletRequest request){
        User user = new User();
        String username = request.getParameter("username");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUsername(username);
        usersService.addUser(user);
        return "success";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public int usersLogin(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=usersService.findByUsername(username);
        if(user!=null && password.equals(user.getPassword())){
            return 1;
        }
//        System.out.println(user.getPassword());
        return 0;
    }

    @RequestMapping(value = "/checkusername", method = RequestMethod.GET)
    public int usernameCheck(HttpServletRequest request){
        String username=request.getParameter("username");
        return usersService.usernameCheck(username);
    }


}
