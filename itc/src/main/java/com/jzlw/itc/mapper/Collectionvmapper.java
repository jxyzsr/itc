package com.jzlw.itc.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Collectionvmapper {
    void insertacollectionv(@Param("userid") Integer userid,@Param("videoid") Integer videoid);
    void deleteacollectionv(@Param("userid") Integer userid,@Param("videoid") Integer videoid);
    void decollvforv(Integer videoid);
}
