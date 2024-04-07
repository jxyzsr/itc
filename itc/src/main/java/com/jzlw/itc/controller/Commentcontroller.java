package com.jzlw.itc.controller;

import com.jzlw.itc.domain.Comment;
import com.jzlw.itc.service.impl.CommentServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@SessionAttributes({"id","fileId","uuid","postsid"})
public class Commentcontroller {
    @Autowired
    private CommentServiceimpl service;
    //展示自己的评论
    @GetMapping(value = "/mycomment")
    public String mycomment(){
        return "forward:/WEB-INF/views/my/mycomment.html";
    }
    //从session中得到刚才的id并且返回一个视频的评论json
    @PostMapping(value = "/getvideocomment")
    @ResponseBody
    public List<Comment> getvideocomment(@ModelAttribute("fileId") String fileId){
        return service.selectcommentbyid(Integer.parseInt(fileId),"video");
    }
    //从session中得到刚才的id并且返回一个视频的评论json
    @PostMapping(value = "/getpostscomment")
    @ResponseBody
    public List<Comment> getpostscomment(@ModelAttribute("postsid") String postsid){
        return service.selectcommentbyid(Integer.parseInt(postsid),"posts");
    }
    //测试
    @PostMapping(value = "/getvideocomment2")
    @ResponseBody
    public List<Comment> getvideocomment2(String fileId){
        fileId = "1";
        return service.selectcommentbyid(Integer.parseInt(fileId),"video");
    }
    //添加评论
    @GetMapping(value = "/addcomment",params = {"userid","type","itid","content"})
    public String addcomment(String userid,String type,String itid,String content){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUserid(Integer.parseInt(userid));
        comment.setItid(Integer.parseInt(itid));
        comment.setType(type);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setTime(timestamp.toString());
        service.insertacomment(comment);
        if (type.equals("video")){
            return "forward:/WEB-INF/views/playvideo.html";
        }
        else {
            return "forward:/WEB-INF/views/displayposts.html";
        }
    }
    //删除评论
    @PostMapping(value = "/deleteacomment",params = {"content","type","itid"})
    public String deleteacomment(String content,String type,Integer itid,@ModelAttribute("id")Integer userid){
        service.deleteacommment(content,type,itid,userid);
        return "forward:/WEB-INF/views/my/mycomment.html";
    }
}
