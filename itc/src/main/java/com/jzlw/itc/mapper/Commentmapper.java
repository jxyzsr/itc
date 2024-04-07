package com.jzlw.itc.mapper;

import com.jzlw.itc.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Commentmapper {
    //写评论
    void insertacomment(Comment comment);
    //删评论
    void deleteacommment(@Param("content") String content,@Param("type") String type,@Param("itid") Integer itid,@Param("userid") Integer userid);
    //根据视频id或者帖子id找寻评论
    List<Comment> selectcommentbyid(@Param("itid") Integer itid,@Param("type") String type);
    //删除已经被删除的帖子或者视频的评论
    void deleteacommmentfordeleted(@Param("type") String type,@Param("itid") Integer itid);
}
