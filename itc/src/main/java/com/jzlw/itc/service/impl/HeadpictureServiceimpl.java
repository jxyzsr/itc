package com.jzlw.itc.service.impl;

import com.jzlw.itc.mapper.Headpicturemapper;
import com.jzlw.itc.service.IHeadpictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadpictureServiceimpl implements IHeadpictureService {

    @Autowired
    private Headpicturemapper mapper;
    @Override
    public void insertahp(Integer userid, String padress) {
        mapper.insertahp(userid,padress);
    }

    @Override
    public void updateahp(Integer userid, String padress) {
        mapper.updateahp(userid,padress);
    }
}
