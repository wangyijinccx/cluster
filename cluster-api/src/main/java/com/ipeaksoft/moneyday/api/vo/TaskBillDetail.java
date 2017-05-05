package com.ipeaksoft.moneyday.api.vo;

public class TaskBillDetail {
	private String name;//完成任务的名
	private String date;//完成日期
	private String time;//完成时间
	private String income;//任务收入
	private String taskType;//任务类型
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}

}
