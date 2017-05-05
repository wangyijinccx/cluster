package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserTaskAdsActive {
    private Long id;

    private String mobile;

    private String idfa;

    private String unionName;

    private String appid;

    private String appname;

    private Date createTime;

    private String description;

    private Integer adsAward;

    private String status;

    private Integer award;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdsAward() {
        return adsAward;
    }

    public void setAdsAward(Integer adsAward) {
        this.adsAward = adsAward;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }
}