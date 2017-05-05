package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class ClusterAccountUdsc {
	 private Integer id;

	    private String udid;

	    private String internalId;

	    private String scriptsId;

	    private String status;

	    private Date createTime;

	    private Date modifyTime;

	    private Integer taskid;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getUdid() {
	        return udid;
	    }

	    public void setUdid(String udid) {
	        this.udid = udid;
	    }

	    public String getInternalId() {
	        return internalId;
	    }

	    public void setInternalId(String internalId) {
	        this.internalId = internalId;
	    }

	    public String getScriptsId() {
	        return scriptsId;
	    }

	    public void setScriptsId(String scriptsId) {
	        this.scriptsId = scriptsId;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public Date getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Date createTime) {
	        this.createTime = createTime;
	    }

	    public Date getModifyTime() {
	        return modifyTime;
	    }

	    public void setModifyTime(Date modifyTime) {
	        this.modifyTime = modifyTime;
	    }

	    public Integer getTaskid() {
	        return taskid;
	    }

	    public void setTaskid(Integer taskid) {
	        this.taskid = taskid;
	    }
}