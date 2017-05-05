package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class StatDayTask {
    private Long id;
    private Date day;
    private Byte type;
    private Long taskId;
    private String taskName;
    private Integer publishNum;
    private Integer compNum;
    private Integer price;
	private Integer offaUser;
    private Integer onbUser;
    private Integer offbUser;
    private Integer oncUser;
    private Integer offcUser;
    private Integer ondUser;
    private Integer offdUser;
    private Integer comp;
    private Integer award;
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
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getPublishNum() {
		return publishNum;
	}
	public void setPublishNum(Integer publishNum) {
		this.publishNum = publishNum;
	}
	public Integer getCompNum() {
		return compNum;
	}
	public void setCompNum(Integer compNum) {
		this.compNum = compNum;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getOffaUser() {
		return offaUser;
	}
	public void setOffaUser(Integer offaUser) {
		this.offaUser = offaUser;
	}
	public Integer getOnbUser() {
		return onbUser;
	}
	public void setOnbUser(Integer onbUser) {
		this.onbUser = onbUser;
	}
	public Integer getOffbUser() {
		return offbUser;
	}
	public void setOffbUser(Integer offbUser) {
		this.offbUser = offbUser;
	}
	public Integer getOncUser() {
		return oncUser;
	}
	public void setOncUser(Integer oncUser) {
		this.oncUser = oncUser;
	}
	public Integer getOffcUser() {
		return offcUser;
	}
	public void setOffcUser(Integer offcUser) {
		this.offcUser = offcUser;
	}
	public Integer getOndUser() {
		return ondUser;
	}
	public void setOndUser(Integer ondUser) {
		this.ondUser = ondUser;
	}
	public Integer getOffdUser() {
		return offdUser;
	}
	public void setOffdUser(Integer offdUser) {
		this.offdUser = offdUser;
	}
	public Integer getComp() {
		return comp;
	}
	public void setComp(Integer comp) {
		this.comp = comp;
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