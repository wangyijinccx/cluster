package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserOperation {
    private Long id;

    private Long userid;

    private Long actionType;

    private Date createTime;

    private String descrption;

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

    public Long getActionType() {
        return actionType;
    }

    public void setActionType(Long actionType) {
        this.actionType = actionType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption == null ? null : descrption.trim();
    }
}