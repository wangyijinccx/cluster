package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

import com.ipeaksoft.moneyday.core.enums.UserRecordType;

public class UserRecord {
    private Long id;

    private String mobile;

    private Date createTime;

    private String description;

    private Integer award;

    private UserRecordType type;

    private Integer totalAward;

    private Long pid;

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

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public UserRecordType getType() {
        return type;
    }

    public void setType(UserRecordType type) {
        this.type = type;
    }

    public Integer getTotalAward() {
        return totalAward;
    }

    public void setTotalAward(Integer totalAward) {
        this.totalAward = totalAward;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}