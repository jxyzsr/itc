package com.jzlw.itc.service;

public interface ICollectionpService {
    void insertacollectionp(Integer userid,Integer postsid);
    void deleteacollectionp(Integer userid,Integer postsid);
    //当删除一个视频时删除和他相关的所有收藏
    void decollpforp(Integer postsid);
}
