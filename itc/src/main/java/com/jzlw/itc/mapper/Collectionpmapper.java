package com.jzlw.itc.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Collectionpmapper {
    void insertacollectionp(@Param("userid") Integer userid,@Param("postsid") Integer postsid);
    void deleteacollectionp(@Param("userid") Integer userid,@Param("postsid") Integer postsid);
    void decollpforp(Integer postsid);
}
