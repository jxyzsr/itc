package com.jzlw.itc.service.impl;

import com.jzlw.itc.mapper.Goodvmapper;
import com.jzlw.itc.service.IGoodvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodvServiceimpl implements IGoodvService {
    @Autowired
    private Goodvmapper mapper;
    @Override
    public void insertagoodv(Integer userid, Integer videoid) {
        mapper.insertagoodv(userid,videoid);
    }

    @Override
    public void deleteagoodv(Integer userid, Integer videoid) {
        mapper.deleteagoodv(userid,videoid);
    }

    @Override
    public void degoodvforv(Integer videoid) {
        mapper.degoodvforv(videoid);
    }
}
