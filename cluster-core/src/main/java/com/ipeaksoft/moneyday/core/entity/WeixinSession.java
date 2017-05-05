package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

import com.ipeaksoft.moneyday.core.enums.SessionType;

public class WeixinSession {
    private String id;

    private SessionType type;

    private String value;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SessionType getType() {
        return type;
    }

    public void setType(SessionType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}