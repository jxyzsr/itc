package com.jzlw.itc.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Goodvmapper {
    void insertagoodv(@Param("userid") Integer userid,@Param("videoid") Integer videoid);
    void deleteagoodv(@Param("userid") Integer userid,@Param("videoid") Integer videoid);
    void degoodvforv(Integer videoid);
}
