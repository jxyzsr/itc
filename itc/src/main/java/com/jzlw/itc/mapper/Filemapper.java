package com.jzlw.itc.mapper;

import com.jzlw.itc.domain.FileEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//以下的id全是视频的id
public interface Filemapper {
    //保存视频
    void saveFile(FileEntity entity);
    //根据视频的id查询
    FileEntity findByid(long id);
    //更新视频的封面
    void updatecover(@Param("title") String title,@Param("cover") String cover,@Param("titleAlter") String titleAlter);
    //返回一些视频供主页面展示
    List<FileEntity> selectvideo();
    //点赞，点赞数加一
    void vadddNumgood(long id);
    //取消点赞，点赞数减一
    void vdeleteNumgood(long id);
    //收藏，收藏数加一
    void vadddNumcollection(long id);
    //取消点赞，点赞数减一
    void vdeleteNumcollection(long id);
    //删除视频
    void deletevideo(@Param("id") long id,@Param("userid") Integer userid);
}
