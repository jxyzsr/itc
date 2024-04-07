package com.jzlw.itc.controller;

import com.jzlw.itc.service.impl.CollectionpServiceimpl;
import com.jzlw.itc.service.impl.CollectionvServiceimpl;
import com.jzlw.itc.service.impl.FileServiceimpl;
import com.jzlw.itc.service.impl.PostsServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Collectioncontroller {
    @Autowired
    private CollectionpServiceimpl pservice;
    @Autowired
    private CollectionvServiceimpl vservice;
    @Autowired
    private PostsServiceimpl numpservice;
    @Autowired
    private FileServiceimpl numvservice;
    @GetMapping("/mycollection")
    public String mycollection(){
        return "forward:/WEB-INF/views/my/mycollection.html";
    }
    @GetMapping(value = "/addcollectionv",params = {"userid","videoid"})
    public String addcollectionv(String userid,String videoid){
        vservice.insertacollectionv(Integer.parseInt(userid),Integer.parseInt(videoid));
        numvservice.vadddNumcollection(Long.parseLong(videoid));
        return "redirect:/loadid?fileId=" + videoid;
    }
    @GetMapping(value = "/deletecollectionv",params = {"userid","videoid"})
    public String deletecollectionv(String userid,String videoid){
        vservice.deleteacollectionv(Integer.parseInt(userid),Integer.parseInt(videoid));
        numvservice.vdeleteNumcollection(Long.parseLong(videoid));
        return "redirect:/loadid?fileId=" + videoid;
    }
    @GetMapping(value = "/addcollectionp",params = {"userid","postsid"})
    public String addcollectionp(String userid,String postsid){
        pservice.insertacollectionp(Integer.parseInt(userid),Integer.parseInt(postsid));
        numpservice.padddNumcollection(Integer.parseInt(postsid));
        return "redirect:/loadpostsid?postsid=" + postsid;
    }
    @GetMapping(value = "/deletecollectionp",params = {"userid","postsid"})
    public String deletecollectionp(String userid,String postsid){
        pservice.deleteacollectionp(Integer.parseInt(userid),Integer.parseInt(postsid));
        numpservice.pdeleteNumcollection(Integer.parseInt(postsid));
        return "redirect:/loadpostsid?postsid=" + postsid;
    }
}
