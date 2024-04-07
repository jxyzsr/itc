package com.jzlw.itc.domain;

public class Comment {
    private String time;
    private String content;
    private String type;
    private Integer itid;
    private Integer userid;
    private User user;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getItid() {
        return itid;
    }

    public void setItid(Integer itid) {
        this.itid = itid;
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
        return "Comment{" +
                "time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", itid=" + itid +
                ", userid=" + userid +
                ", user=" + user +
                '}';
    }
}
