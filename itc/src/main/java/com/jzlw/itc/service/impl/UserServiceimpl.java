package com.jzlw.itc.service.impl;


import com.jzlw.itc.domain.User;
import com.jzlw.itc.mapper.Usermapper;
import com.jzlw.itc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements IUserService {
    @Autowired
    private Usermapper mapper;
    @Override
    public List<User> slectall() {
        return mapper.slectall();
    }
    public User selectuserattribute(Integer id) {
        return mapper.selectuserattribute(id);
    }

    @Override
    public User selectoflogin(String username, String password) {
        return mapper.selectoflogin(username,password);
    }

    @Override
    public void insertauser(User user) {
        mapper.insertauser(user);
    }

    @Override
    public void updateuser(User user) {
        mapper.updateuser(user);
    }
}
