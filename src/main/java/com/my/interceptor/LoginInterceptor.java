package com.my.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 8:53 2018/11/29
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static List<String> CHECK_URL= Arrays.asList("/upload","/uploadPic","/uploaduserpic","/addComment","/apdComment","/upload.html","userspace.html");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        String loginStat= (String) session.getAttribute("loginstats");
        String url=request.getServletPath();
        if(loginStat==null&&CHECK_URL.contains(url)){
            response.sendRedirect("/error/loginfr.html");
            return false;
        }
        return super.preHandle(request,response,handler);
    }
}
