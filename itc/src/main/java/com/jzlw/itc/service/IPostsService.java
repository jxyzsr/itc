package com.jzlw.itc.service;

import com.jzlw.itc.domain.Posts;

import java.util.List;

public interface IPostsService {
    //写帖子
    void insertaposts(Posts posts);
    //删除帖子
    void deleteaposts(Integer id,Integer userid);
    List<Posts> selectposts();
    Posts findByid(Integer id);
    //点赞，点赞数加一
    void padddNumgood(Integer id);
    //取消点赞，点赞数减一
    void pdeleteNumgood(Integer id);
    //收藏，收藏数加一
    void padddNumcollection(Integer id);
    //取消点赞，点赞数减一
    void pdeleteNumcollection(Integer id);
}
