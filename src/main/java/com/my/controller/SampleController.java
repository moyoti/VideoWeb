package com.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.my.service.UsersService;

import java.util.Map;

@Controller
//@RequestMapping(value = "/users")
public class SampleController {
    private static Logger logger= LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private UsersService usersService;
//    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    public Object index(@PathVariable int id){
//        return usersService.findAllUsers(id);
//    }
    @RequestMapping(value = "/ttt",method = RequestMethod.GET)
    public Object hello(){
        logger.info("--------test---------");
        return "hello";
    }
    @RequestMapping(value = "/index")
    public String indexshow(Map<String,Object> map){
        map.put("msg","show message");
        return "index.html";
    }
}
