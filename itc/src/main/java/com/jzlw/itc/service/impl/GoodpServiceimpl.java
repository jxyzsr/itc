package com.jzlw.itc.service.impl;

import com.jzlw.itc.mapper.Goodpmapper;
import com.jzlw.itc.service.IGoodpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodpServiceimpl implements IGoodpService {
    @Autowired
    private Goodpmapper mapper;
    @Override
    public void insertagoodp(Integer userid, Integer postsid) {
        mapper.insertagoodp(userid,postsid);
    }

    @Override
    public void deleteagoodp(Integer userid, Integer postsid) {
        mapper.deleteagoodp(userid,postsid);
    }

    @Override
    public void degoodpforp(Integer postsid) {
        mapper.degoodpforp(postsid);
    }
}
