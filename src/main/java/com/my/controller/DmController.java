package com.my.controller;

import com.my.pojo.DmContent;
import com.my.service.DmService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 14:36 2018/12/29
 */
@RestController
@RequestMapping(value = "/dm")
public class DmController {
    @Autowired
    private DmService dmService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public int dmSend(HttpSession session, @Param(value = "content") String content, @Param(value = "curTime") String curTime, @Param(value = "vid") int vid) {
        Integer uid= (int) session.getAttribute("uid");
        if(content.trim()!=""&&content!=null&&uid!=null){
            DmContent dmContent=new DmContent();
            dmContent.setContent(content);
            dmContent.setSendtime(new Date());
            dmContent.setVduration(Double.parseDouble(curTime));
            dmContent.setVid(vid);
            dmContent.setUid(uid);
            return dmService.sendDm(dmContent);
        }
        return 0;
    }
    @RequestMapping(value = "/getbyvid",method = RequestMethod.POST)
    public List getDmByvid(@Param(value = "vid") int vid){
        return dmService.getDmByVid(vid);
    }
}
