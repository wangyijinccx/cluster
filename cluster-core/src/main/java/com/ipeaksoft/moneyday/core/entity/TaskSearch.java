package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskSearch extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String taskname;
    private Integer award;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createTime;
    private String taskType;//任务类型
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public Integer getAward() {
		return award;
	}
	public void setAward(Integer award) {
		this.award = award;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
 
}