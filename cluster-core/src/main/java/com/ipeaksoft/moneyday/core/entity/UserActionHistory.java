package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserActionHistory {
    private Integer id;

    private Long userid;

    private Integer actionType;

    private Date createTime;

    private String description;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
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
}