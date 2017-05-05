package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserTaskAds {
    private Long id;

    private String mobile;

    private String unionName;

    private String appid;

    private String appname;

    private Date createTime;

    private String description;
    
    private String taskId;
    
    private String taskName;

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

	private Integer award;

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

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
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