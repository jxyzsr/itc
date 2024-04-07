package com.jzlw.itc.controller;

import com.jzlw.itc.domain.User;
import com.jzlw.itc.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"id","username","password"})
public class Usercontroller {
    @Autowired
    private UserServiceimpl service;
    //推荐页面
    @GetMapping("/hello")
    public String hello(){
        return "forward:/WEB-INF/views/hello.html";
    }
    //主页
    @GetMapping("/index")
    public String index(){
        return "forward:/WEB-INF/views/index.html";
    }
    //主页
    @GetMapping("/index2")
    public String index2(){
        return "forward:/WEB-INF/views/index2.html";
    }
    //管理员主页
    @GetMapping("/indexofadmin")
    public String indexofadmin(){
        return "forward:/WEB-INF/views/indexofadmin.html";
    }
    //管理员主页
    @GetMapping("/indexofadmin2")
    public String indexofadmin2(){
        return "forward:/WEB-INF/views/indexofadmin2.html";
    }
    //登录页
    @GetMapping("/login")
    public String login(){
        return "loginand1";
    }
    //登陆验证
    @PostMapping(value = "login",params = {"username","password"})
    public String dologin(String username, String password, Model model){
        User user = service.selectoflogin(username,password);
        if (user==null){
            return "forward:/WEB-INF/views/defeat.html";
        }
        else {
            model.addAttribute("id",user.getId());
            model.addAttribute("username",user.getUsername());
            model.addAttribute("password",user.getPassword());
            if(user.getType() == 1){
                return "forward:/WEB-INF/views/indexofadmin.html";
            }
            else {
                return "forward:/WEB-INF/views/index.html";
            }
        }
    }
    //注册
//    @GetMapping("/logup")
//    public String logup(){
//        return "forward:/WEB-INF/views/logup.html";
//    }
    @PostMapping(path ="/dologup",params = {"username","password","sex","age","email"})
    public String dologup(String username,String password,String sex,String age,String email){
        User user = new User(username,password,sex,age,email);
        service.insertauser(user);
        return "loginand1";
    }
    //个人信息页
    @GetMapping("/myinfo")
    public String myinfo(){
        return "forward:/WEB-INF/views/my/myinfo.html";
    }
    //修改个人信息
    @PostMapping(value = "/doupdate",params = {"username","password","email"})
    public String doupdateinfo(@ModelAttribute("username") String oldusername,@ModelAttribute("password") String oldpassword,String username,String password,String email){
        User user = service.selectoflogin(oldusername,oldpassword);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        service.updateuser(user);
        return "loginand1";
    }
    //传递所有的个人信息
    //传递个人信息
    @PostMapping("/transmitinfo")
    @ResponseBody
    public User transmitinfo(@ModelAttribute("id") Integer id){
        User user = service.selectuserattribute(id);
        return user;
    }
    //测试
    @PostMapping("/transmitinfo2")
    @ResponseBody
    public User transmitinfo2(){
        User user = service.selectuserattribute(2);
        return user;
    }
    //展示自己的video
    @GetMapping("/myvideo")
    public String myvideo(){
        return "forward:/WEB-INF/views/my/myvideo.html";
    }
    //展示自己的posts
    @GetMapping("/myposts")
    public String myposts(){
        return "forward:/WEB-INF/views/my/myposts.html";
    }
}
