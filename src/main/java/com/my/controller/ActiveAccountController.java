package com.my.controller;

import com.my.pojo.User;
import com.my.pojo.UserActive;
import com.my.service.UserActiveService;
import com.my.service.UsersService;
import com.my.util.EmailSender;
import com.my.util.UUIDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: dongqihang
 * @Date: Created in 23:14 2018/11/12
 */
@RestController
@RequestMapping(value = "/activeAcc")
public class ActiveAccountController {
    @Autowired
    private UserActiveService userActiveService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/activeRequest", method = RequestMethod.POST)
    public int activeUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
//        String username="username1";
        String activeCode = UUIDTool.getUUID();
        User user = usersService.findByUsername(username);
        String url = "http://localhost:8079/activeAcc/acuser?acode=" + activeCode + "&uid=" + user.getId();
        String eContent = "点击下面链接激活您的账号：" + url;
        UserActive userActive = userActiveService.getUserActiveByUid(user.getId());
        if (!(userActive==null)) {
            userActive.setActivecode(activeCode);
            userActive.setUserid(user.getId());
            userActiveService.updateUserActive(userActive);
        }else {
            userActive = new UserActive();
            userActive.setActivecode(activeCode);
            userActive.setUserid(user.getId());
            userActiveService.addUserActive(userActive);
        }
        //todo 邮件乱码
        try {
            EmailSender emailSender = new EmailSender();
            //设置服务器地址和端口
            emailSender.setProperties("smtp.163.com", "25");
            //分别设置发件人，邮件标题和文本内容
            emailSender.setMessage("dqh_ql@163.com", "Active your Account", eContent);
            //设置收件人
            emailSender.setReceiver(new String[]{user.getEmail()});
            //发送邮件
            emailSender.sendEmail("smtp.163.com", "dqh_ql@163.com", "my1234567891");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @RequestMapping(value = "/acuser", method = RequestMethod.GET)
    public int activeUserAccount(HttpServletRequest request,
                                 @RequestParam(value = "uid") int uid,
                                 @RequestParam(value = "acode") String acode) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
//        String username="username1";
        User user = usersService.findByUsername(username);
        int userid = user.getId();
        UserActive userActive = userActiveService.getUserActiveByUid(userid);
        if (userid == uid && userActive.getActivecode().equals(acode)) {
            user.setActive(1);
            usersService.userUpdatedByUid(user);
            userActiveService.deleteByUid(user.getId());
            return 1;
        }
        return 0;
    }
}
