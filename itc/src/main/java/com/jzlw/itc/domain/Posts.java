package com.jzlw.itc.domain;

public class Posts {
    private Integer id;
    private String time;
    private String title;
    private String content;
    private Integer numgood;
    private String adressp;
    private Integer numcollection;
    private Integer userid;
    private User user;

    public Posts( String time, String title, String content, Integer userid) {
        this.time = time;
        this.title = title;
        this.content = content;
        this.userid = userid;
    }
    public Posts(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumgood() {
        return numgood;
    }

    public void setNumgood(Integer numgood) {
        this.numgood = numgood;
    }

    public String getAdressp() {
        return adressp;
    }

    public void setAdressp(String adressp) {
        this.adressp = adressp;
    }

    public Integer getNumcollection() {
        return numcollection;
    }

    public void setNumcollection(Integer numcollection) {
        this.numcollection = numcollection;
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
        return "Posts{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", numgood=" + numgood +
                ", adressp='" + adressp + '\'' +
                ", numcollection=" + numcollection +
                ", userid=" + userid +
                ", user=" + user +
                '}';
    }
}
