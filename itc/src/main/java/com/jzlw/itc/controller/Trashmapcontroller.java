package com.jzlw.itc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Trashmapcontroller {
    @GetMapping("/trashmap")
    public String trashmap(){
        return "forward:/WEB-INF/views/trashmap.html";
    }
}
