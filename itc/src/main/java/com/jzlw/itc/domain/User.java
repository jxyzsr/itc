package com.jzlw.itc.domain;

import java.util.List;

public class User {
    private Integer type;
    private Integer id;
    private Headpicture headpicture;
    private String username;
    private String password;
    private String sex;
    private String age;
    private String email;
    private List<Trashcan> trashcans;
    private List<FileEntity> videos;
    private List<Posts> postses;
    private List<Comment> comments;
    private List<Goodp> goodps;
    private List<Goodv> goodvs;
    private List<Collectionp> collectionps;
    private List<Collectionv> collectionvs;

    public User(String username, String password, String sex, String age, String email) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }
    public User() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Headpicture getHeadpicture() {
        return headpicture;
    }

    public void setHeadpicture(Headpicture headpicture) {
        this.headpicture = headpicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Trashcan> getTrashcans() {
        return trashcans;
    }

    public void setTrashcans(List<Trashcan> trashcans) {
        this.trashcans = trashcans;
    }

    public List<FileEntity> getVideos() {
        return videos;
    }

    public void setVideos(List<FileEntity> videos) {
        this.videos = videos;
    }

    public List<Posts> getPostses() {
        return postses;
    }

    public void setPostses(List<Posts> postses) {
        this.postses = postses;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Goodp> getGoodps() {
        return goodps;
    }

    public void setGoodps(List<Goodp> goodps) {
        this.goodps = goodps;
    }

    public List<Goodv> getGoodvs() {
        return goodvs;
    }

    public void setGoodvs(List<Goodv> goodvs) {
        this.goodvs = goodvs;
    }

    public List<Collectionp> getCollectionps() {
        return collectionps;
    }

    public void setCollectionps(List<Collectionp> collectionps) {
        this.collectionps = collectionps;
    }

    public List<Collectionv> getCollectionvs() {
        return collectionvs;
    }

    public void setCollectionvs(List<Collectionv> collectionvs) {
        this.collectionvs = collectionvs;
    }

    @Override
    public String toString() {
        return "User{" +
                "type=" + type +
                ", id=" + id +
                ", headpicture=" + headpicture +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", trashcans=" + trashcans +
                ", videos=" + videos +
                ", postses=" + postses +
                ", comments=" + comments +
                ", goodps=" + goodps +
                ", goodvs=" + goodvs +
                ", collectionps=" + collectionps +
                ", collectionvs=" + collectionvs +
                '}';
    }
}
