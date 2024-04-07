package com.jzlw.itc.service;

import com.jzlw.itc.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommentService {
    //写评论
    void insertacomment(Comment comment);
    //删评论
    void deleteacommment(String content,String type,Integer itid,Integer userid);
    //根据视频id或者帖子id找寻评论
    List<Comment> selectcommentbyid(Integer itid, String type);
    //删除已经被删除的帖子或者视频的评论
    void deleteacommmentfordeleted(@Param("type") String type, @Param("itid") Integer itid);
}
