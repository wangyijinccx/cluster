package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserTaskFast {
    private Long id;

    private String mobile;

    private Long taskId;

    private String appid;

    private Date createTime;

    private Integer award;

    private String description;

    private Long clickId;

    private Long activeId;

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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClickId() {
        return clickId;
    }

    public void setClickId(Long clickId) {
        this.clickId = clickId;
    }

    public Long getActiveId() {
        return activeId;
    }

    public void setActiveId(Long activeId) {
        this.activeId = activeId;
    }
}