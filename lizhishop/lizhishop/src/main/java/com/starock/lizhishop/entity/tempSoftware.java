package com.starock.lizhishop.entity;

public class tempSoftware {
    //Software类，定义一个软件的属性
    private int software_id;
    private int price_id;
    private String software_name;
    private float price_value;

    public float getPrice_value() {
        return price_value;
    }

    public void setPrice_value(float price_value) {
        this.price_value = price_value;
    }

    public int getSoftware_id() {
        return software_id;
    }

    public void setSoftware_id(int software_id) {
        this.software_id = software_id;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public String getSoftware_name() {
        return software_name;
    }

    public void setSoftware_name(String software_name) {
        this.software_name = software_name;
    }
}
