package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class StatDay {
	private Long id;

	private Date day;

	private Integer taskType;

	private Integer completeTime;

	private Integer participantsNum;

	private Integer onlineUser;

	private Integer onlineEarnings;
	
	private Integer offlineUser;
	
	private Integer offlineEarnings;
	
	private Integer allEarnings;
	
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Integer getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Integer completeTime) {
		this.completeTime = completeTime;
	}

	public Integer getParticipantsNum() {
		return participantsNum;
	}

	public void setParticipantsNum(Integer participantsNum) {
		this.participantsNum = participantsNum;
	}

	public Integer getOnlineUser() {
		return onlineUser;
	}

	public void setOnlineUser(Integer onlineUser) {
		this.onlineUser = onlineUser;
	}

	public Integer getOnlineEarnings() {
		return onlineEarnings;
	}

	public void setOnlineEarnings(Integer onlineEarnings) {
		this.onlineEarnings = onlineEarnings;
	}

	public Integer getOfflineUser() {
		return offlineUser;
	}

	public void setOfflineUser(Integer offlineUser) {
		this.offlineUser = offlineUser;
	}

	public Integer getOfflineEarnings() {
		return offlineEarnings;
	}

	public void setOfflineEarnings(Integer offlineEarnings) {
		this.offlineEarnings = offlineEarnings;
	}

	public Integer getAllEarnings() {
		return allEarnings;
	}

	public void setAllEarnings(Integer allEarnings) {
		this.allEarnings = allEarnings;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

	

}