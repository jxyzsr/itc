package com.jzlw.itc.controller;

import com.jzlw.itc.domain.Trash;
import com.jzlw.itc.service.impl.TrashServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Trashcollectioncontroller {
    @Autowired
    private TrashServiceimpl service;
    @GetMapping("/trashclassficion")
    public String trashclassficion(){
        return "forward:/WEB-INF/views/trashclassficion.html";
    }
    //管理员查看用户不清楚的垃圾分类信息
    @GetMapping("/infooftrash")
    public String infooftrash(){
        return "forward:/WEB-INF/views/my/infooftrash.html";
    }
    @PostMapping("/infooftrash")
    @ResponseBody
    public List<Trash> infooftrash2(){
        return service.selecttrash();
    }
}
