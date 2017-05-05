package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserTaskAward {
    private Long id;

    private String mobile;

    private Date createTime;

    private Integer award;

    private String taskName;

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
        this.mobile = mobile == null ? null : mobile.trim();
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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }
}