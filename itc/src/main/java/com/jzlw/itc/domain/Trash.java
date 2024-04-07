package com.jzlw.itc.domain;

public class Trash {
    private String name;
    private String type;
    private Integer frequency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Trash{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
