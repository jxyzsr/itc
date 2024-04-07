package com.jzlw.itc.domain;

public class Notice {
    private String time;
    private String title;
    private String content;

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

    public void setContent(String comntent) {
        this.content = comntent;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
