package com.jzlw.itc.service;


import org.apache.ibatis.annotations.Param;

public interface IHeadpictureService {
    //加入
    void insertahp(Integer userid,String padress);
    //修改
    void updateahp(Integer userid,String padress);
}
