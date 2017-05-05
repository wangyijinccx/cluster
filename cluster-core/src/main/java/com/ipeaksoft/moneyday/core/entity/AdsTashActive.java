package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class AdsTashActive {
    private Long id;

    private Long userid;

    private String idfa;

    private String adsId;

    private String appid;

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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa == null ? null : idfa.trim();
    }

    public String getAdsId() {
        return adsId;
    }

    public void setAdsId(String adsId) {
        this.adsId = adsId == null ? null : adsId.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
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
        this.description = description == null ? null : description.trim();
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
        this.status = status == null ? null : status.trim();
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }
}