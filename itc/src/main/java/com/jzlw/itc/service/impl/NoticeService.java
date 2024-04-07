package com.jzlw.itc.service.impl;

import com.jzlw.itc.domain.Notice;
import com.jzlw.itc.mapper.Noticemapper;
import com.jzlw.itc.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService implements INoticeService {
    @Autowired
    private Noticemapper mapper;


    @Override
    public List<Notice> selectanotice() {
        return mapper.selectanotice();
    }

    @Override
    public void insert(Notice notice) {
        mapper.insert(notice);
    }

    @Override
    public void delete(String title, String content) {
       mapper.delete(title,content);
    }


}
