package com.ipeaksoft.moneyday.core.entity;

public class UserTask {
	private String create_time;
	private String taskname;
	private String tasktype;
	private String tasktypename;
	private String award;

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public String getTasktypename() {
		return tasktypename;
	}

	public void setTasktypename(String tasktypename) {
		this.tasktypename = tasktypename;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}
}
