package com.jzlw.itc.domain;

import java.util.List;

public class Goodv {
    private Integer userid;
    private Integer videoid;
    private FileEntity video;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public FileEntity getVideo() {
        return video;
    }

    public void setVideo(FileEntity video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Goodv{" +
                "userid=" + userid +
                ", videoid=" + videoid +
                ", video=" + video +
                '}';
    }
}
