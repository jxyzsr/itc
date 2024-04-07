package com.jzlw.itc.controller;

import com.jzlw.itc.domain.FileEntity;
import com.jzlw.itc.domain.Posts;
import com.jzlw.itc.service.impl.CollectionpServiceimpl;
import com.jzlw.itc.service.impl.CommentServiceimpl;
import com.jzlw.itc.service.impl.GoodpServiceimpl;
import com.jzlw.itc.service.impl.PostsServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
//id为用户的id
@SessionAttributes({"id","username","password","postsid"})
public class Postscontroller {
    @Autowired
    PostsServiceimpl service;
    @Autowired
    GoodpServiceimpl gpservice;
    @Autowired
    CollectionpServiceimpl cpservice;
    @Autowired
    CommentServiceimpl commentservice;
    //写入帖子
    @GetMapping("/writeposts")
    public String writeposts(){
        return "forward:/WEB-INF/views/my/writeposts.html";
    }
    @PostMapping(path = "/writeposts",params = {"title","content"})
    public String writeposts(String title,String content,@ModelAttribute("id")Integer userid){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Posts posts = new Posts(timestamp.toString(),title,content,userid);
        service.insertaposts(posts);
        return "forward:/WEB-INF/views/my/myposts.html";
    }
    //删除帖子,从网页段前来的id是帖子的id
    @PostMapping(path = "/deleteposts",params = {"id"})
    public String deleteposts(Integer id,@ModelAttribute("id")Integer userid){
        service.deleteaposts(id,userid);
        //删除和帖子相关的所有的收藏和点赞
        gpservice.degoodpforp(id);
        cpservice.decollpforp(id);
        //删除帖子所有的评论
        commentservice.deleteacommmentfordeleted("posts",id);
        return "forward:/WEB-INF/views/my/myposts.html";
    }
    //用于主页展示一些帖子
    @PostMapping("/displayposts")
    @ResponseBody
    public List<Posts> displayvideo(){
        return service.selectposts();
    }
    //接收参数，并且把帖子id保留到session中,并且渲染播放页面
    @GetMapping(value = "/loadpostsid",params = {"postsid"})
    public String loadid(String postsid, Model model){
        model.addAttribute("postsid",postsid);
        return "forward:/WEB-INF/views/displayposts.html";
    }
    //从session中得到刚才的id并且返回一个视频json
    @PostMapping(value = "/getposts")
    @ResponseBody
    public Posts getposts(@ModelAttribute("postsid") String postsid){
        Posts posts = service.findByid(Integer.parseInt(postsid));
        return posts;
    }
    //测试传递的json
    @PostMapping(value = "/getposts2")
    @ResponseBody
    public Posts getposts2(){
        String postsid ="1";
        Posts posts = service.findByid(Integer.parseInt(postsid));
        return posts;
    }
}
