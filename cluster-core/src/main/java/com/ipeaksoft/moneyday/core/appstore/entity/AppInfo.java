package com.ipeaksoft.moneyday.core.appstore.entity;

public class AppInfo {
    private Long appid;

    private String name;

    private String url;

    private String icons;

    private Float price;

    private Long size;

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}