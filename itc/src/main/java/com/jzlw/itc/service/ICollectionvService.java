package com.jzlw.itc.service;

public interface ICollectionvService {
    void insertacollectionv(Integer userid,Integer videoid);
    void deleteacollectionv(Integer userid,Integer videoid);
    //当删除一个视频时删除和他相关的所有收藏
    void decollvforv(Integer videoid);
}
