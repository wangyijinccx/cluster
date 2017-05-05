package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class StatDayTaskAds {
    private Long id;

    private Date day;

    private Integer adsId;

    private String taskId;

    private String taskName;

    private Integer comp;

    private Integer award;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getAdsId() {
        return adsId;
    }

    public void setAdsId(Integer adsId) {
        this.adsId = adsId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getComp() {
        return comp;
    }

    public void setComp(Integer comp) {
        this.comp = comp;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}