package com.jzlw.itc.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Headpicturemapper {
    //加入
    void insertahp(@Param("userid")Integer userid,@Param("padress") String padress);
    //修改
    void updateahp(@Param("userid")Integer userid,@Param("padress") String padress);
}
