package com.jzlw.itc.domain;

public class Headpicture {
    private Integer userid;
    private String padress;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPadress() {
        return padress;
    }

    public void setPadress(String padress) {
        this.padress = padress;
    }

    @Override
    public String toString() {
        return "Headpicture{" +
                "userid=" + userid +
                ", padress='" + padress + '\'' +
                '}';
    }
}
