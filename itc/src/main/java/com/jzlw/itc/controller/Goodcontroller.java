package com.jzlw.itc.controller;

import com.jzlw.itc.service.impl.FileServiceimpl;
import com.jzlw.itc.service.impl.GoodpServiceimpl;
import com.jzlw.itc.service.impl.GoodvServiceimpl;
import com.jzlw.itc.service.impl.PostsServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Goodcontroller {
    @Autowired
    private GoodpServiceimpl pservice;
    @Autowired
    private GoodvServiceimpl vservice;
    @Autowired
    private PostsServiceimpl numpservice;
    @Autowired
    private FileServiceimpl numvservice;
    @GetMapping("/mygood")
    public String mygood(){
        return "forward:/WEB-INF/views/my/mygood.html";
    }
    @GetMapping(value = "/addgoodv",params = {"userid","videoid"})
    public String addgoodv(String userid,String videoid){
        vservice.insertagoodv(Integer.parseInt(userid),Integer.parseInt(videoid));
        numvservice.vadddNumgood(Long.parseLong(videoid));
        return "redirect:/loadid?fileId=" + videoid;
    }
    @GetMapping(value = "/deletegoodv",params = {"userid","videoid"})
    public String deletegoodv(String userid,String videoid){
        vservice.deleteagoodv(Integer.parseInt(userid),Integer.parseInt(videoid));
        numvservice.vdeleteNumgood(Long.parseLong(videoid));
        return "redirect:/loadid?fileId=" + videoid;
    }
    @GetMapping(value = "/addgoodp",params = {"userid","postsid"})
    public String addgoodp(String userid,String postsid){
        pservice.insertagoodp(Integer.parseInt(userid),Integer.parseInt(postsid));
        numpservice.padddNumgood(Integer.parseInt(postsid));
        return "redirect:/loadpostsid?postsid=" + postsid;
    }
    @GetMapping(value = "/deletegoodp",params = {"userid","postsid"})
    public String deletegoodp(String userid,String postsid){
        pservice.deleteagoodp(Integer.parseInt(userid),Integer.parseInt(postsid));
        numpservice.pdeleteNumgood(Integer.parseInt(postsid));
        return "redirect:/loadpostsid?postsid=" + postsid;
    }
}
