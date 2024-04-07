package com.jzlw.itc.service;

public interface IGoodvService {
    void insertagoodv(Integer userid,Integer videoid);
    void deleteagoodv(Integer userid,Integer videoid);
    //当删除一个视频时删除和他相关的所有点赞
    void degoodvforv(Integer videoid);
}
