package com.jzlw.itc.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Goodpmapper {
    void insertagoodp(@Param("userid") Integer userid,@Param("postsid") Integer postsid);
    void deleteagoodp(@Param("userid") Integer userid,@Param("postsid") Integer postsid);
    //当删除一个帖子时删除和他相关的所有点赞
    void degoodpforp(Integer postsid);
}
