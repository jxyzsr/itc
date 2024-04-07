package com.jzlw.itc.service;

import com.jzlw.itc.domain.FileEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IFileService {
    void saveFile(FileEntity entity);
    FileEntity findByid(long id);
    void updatecover(String title,String cover,String titleAlter);
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
    void deletevideo(long id,Integer userid);
}
