package com.jzlw.itc.domain;

import java.util.List;

public class Collectionp {
    private Integer userid;
    private Integer postsid;
    private Posts posts;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPostsid() {
        return postsid;
    }

    public void setPostsid(Integer postsid) {
        this.postsid = postsid;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Collectionp{" +
                "userid=" + userid +
                ", postsid=" + postsid +
                ", posts=" + posts +
                '}';
    }
}
