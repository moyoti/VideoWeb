package com.my.controller;

import com.my.util.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: dongqihang
 * @Date: Created in 11:20 2018/10/25
 */
@Controller
@RequestMapping(value = "/verify")
public class VerifyCodeController {
    @RequestMapping(value = "/getImage")
    public void getVerifyCode(HttpServletResponse response, HttpServletRequest request)
    {
        //创建对象
        VerifyCode vc = new VerifyCode();
        //获取图片对象
        BufferedImage bi = vc.getImage();
        //获得图片的文本内容
        String text = vc.getText();
        System.out.println(text);
        request.getSession().setAttribute("vctext", text);
        try {
            VerifyCode.output(bi,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
