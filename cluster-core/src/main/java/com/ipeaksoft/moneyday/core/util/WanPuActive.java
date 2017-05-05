package com.ipeaksoft.moneyday.core.util;

import com.ipeaksoft.moneyday.core.dto.BaseObject;


public class WanPuActive extends BaseObject{
	private static final long serialVersionUID = 1L;
	private String taskSource;
	private String app_id;
	private String udid;
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	
	public String getTaskSource() {
		return taskSource;
	}
	public void setTaskSource(String taskSource) {
		this.taskSource = taskSource;
	}
	
	public String getUdid() {
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
	}
}
