package com.jzlw.itc.controller;

import com.jzlw.itc.domain.Trashcan;
import com.jzlw.itc.service.impl.TrashcanServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Trashcancontroller {
    @Autowired
    private TrashcanServiceimpl service;

    @PostMapping("/trashcan")
    @ResponseBody
    public List<Trashcan> trashcan(){
        return service.selecttrashcan();
    }
}
