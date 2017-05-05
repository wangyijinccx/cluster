package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserAward {
    private Long id;

    private String mobile;
    
    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private Integer award;

    private String type;

    private String description;

//    private Date createTime;
    
    private Date modifyTime;
    
    private Integer taskDays;
    
    private Integer needDays;
    
    private String status;

    public Integer getTaskDays() {
		return taskDays;
	}

	public void setTaskDays(Integer taskDays) {
		this.taskDays = taskDays;
	}

	public Integer getNeedDays() {
		return needDays;
	}

	public void setNeedDays(Integer needDays) {
		this.needDays = needDays;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}