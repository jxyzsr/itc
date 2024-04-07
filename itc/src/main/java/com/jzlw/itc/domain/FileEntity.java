package com.jzlw.itc.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FileEntity {
    //图片的封面
    private String cover;
    private long fileId;
    //原文件名
    private String titleOrig;
    //修改后文件名
    private String titleAlter;
    //自己给定的标题
    private String title;
    //点赞数
    private Integer numgood;
    //收藏数
    private Integer numcollection;
    //文件大小
    private String size;
    //文件类型
    private String type;
    //文件保存路径
    private String path;
    //文件上传时间
    private Timestamp uploadTime;
    private Integer userid;
    private User user;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getTitleOrig() {
        return titleOrig;
    }

    public void setTitleOrig(String titleOrig) {
        this.titleOrig = titleOrig;
    }

    public String getTitleAlter() {
        return titleAlter;
    }

    public void setTitleAlter(String titleAlter) {
        this.titleAlter = titleAlter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumgood() {
        return numgood;
    }

    public void setNumgood(Integer numgood) {
        this.numgood = numgood;
    }

    public Integer getNumcollection() {
        return numcollection;
    }

    public void setNumcollection(Integer numcollection) {
        this.numcollection = numcollection;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUploadTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String uploadtime = df.format(uploadTime);
        return uploadtime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "cover='" + cover + '\'' +
                ", fileId=" + fileId +
                ", titleOrig='" + titleOrig + '\'' +
                ", titleAlter='" + titleAlter + '\'' +
                ", title='" + title + '\'' +
                ", numgood=" + numgood +
                ", numcollection=" + numcollection +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", path='" + path + '\'' +
                ", uploadTime=" + uploadTime +
                ", userid=" + userid +
                ", user=" + user +
                '}';
    }
}


