package com.jzlw.itc.mapper;

import com.jzlw.itc.domain.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Noticemapper {
    List<Notice> selectanotice();

    void insert(Notice notice);

    void delete(@Param("title") String title, @Param("content") String content);

}
