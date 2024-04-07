package com.jzlw.itc.mapper;

import com.jzlw.itc.domain.FileEntity;
import com.jzlw.itc.domain.Posts;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Postsmapper {
    //写帖子
    void insertaposts(Posts posts);
    //删除帖子
    void deleteaposts(@Param("id")Integer id,@Param("userid")Integer userid);
    //查询一些帖子用于主页展示
    List<Posts> selectposts();
    //通过帖子的id查询
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
