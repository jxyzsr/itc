package com.jzlw.itc.controller;

import com.jzlw.itc.domain.Notice;
import com.jzlw.itc.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Noticecontroller {
    @Autowired
    private INoticeService service;

    @PostMapping("/notice")
    @ResponseBody
    List<Notice> notice(){
        return service.selectanotice();
    }
    @GetMapping("/noticeset")
    public String noticeset(){
        return "forward:/WEB-INF/views/notice.html";
    }

    @PostMapping(value = "/noticedelete",params = {"title","content"})
    public String delete(String title,String content){
         service.delete(title,content);
         return "forward:/WEB-INF/views/notice.html";
    }
    @PostMapping("/noticeinsert")
    public String insert(Notice notice){
            service.insert(notice);
        return "forward:/WEB-INF/views/notice.html";
    }
}
