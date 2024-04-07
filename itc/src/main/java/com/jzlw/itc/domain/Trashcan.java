package com.jzlw.itc.domain;

public class Trashcan {
    private Integer userid;
    private float x;
    private float y;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Trashcan{" +
                "userid=" + userid +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
