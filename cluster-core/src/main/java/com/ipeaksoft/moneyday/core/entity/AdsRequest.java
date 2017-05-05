package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class AdsRequest {
    private Long id;

    private String idfa;

    private Long taskId;

    private String ads;

    private Date createTime;

    private Integer adsAward;

    private String description;

    private String status;

    private Integer award;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAdsAward() {
        return adsAward;
    }

    public void setAdsAward(Integer adsAward) {
        this.adsAward = adsAward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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