package com.jzlw.itc.service;

import com.jzlw.itc.domain.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INoticeService {
    List<Notice> selectanotice();

    void insert(Notice notice);

    void delete(@Param("title") String title, @Param("content") String content);
}
