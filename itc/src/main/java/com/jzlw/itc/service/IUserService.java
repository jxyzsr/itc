package com.jzlw.itc.service;

import com.jzlw.itc.domain.User;

import java.util.List;

public interface IUserService {
    //查询所有用户
    List<User> slectall();
    //查询和用户相关的内容
    User selectuserattribute(Integer id);
    //登录
    User selectoflogin(String username,String password);
    //注册
    void insertauser(User user);
    //修改个人信息
    void updateuser(User user);
}
