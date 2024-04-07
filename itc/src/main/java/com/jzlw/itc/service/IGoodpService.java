package com.jzlw.itc.service;

public interface IGoodpService {
    void insertagoodp(Integer userid,Integer postsid);
    void deleteagoodp(Integer userid,Integer postsid);
    //当删除一个帖子时删除和他相关的所有点赞
    void degoodpforp(Integer postsid);
}
