package com.ipeaksoft.moneyday.api.vo;

public class NoticeVo {
	private String name;//公告名称
	private String publishDate;//发布日期
	private String publishTime;//发布时间
	private String status;//状态
	private String announceId;//主键
	private String summary;//简介
	public String getSummary() {
		if(summary==null){
			return "";
		}
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAnnounceId() {
		return announceId;
	}
	public void setAnnounceId(String announceId) {
		this.announceId = announceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	private String deadDate;//下线日期
	private String deadTime;//下线时间s
	private String type;////公告的类型,0表示文字，1表示图片，2表示图文
	private String desc;//公告描述
	private String imageUrl;//图片地址
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getDeadDate() {
		return deadDate;
	}
	public void setDeadDate(String deadDate) {
		this.deadDate = deadDate;
	}
	public String getDeadTime() {
		return deadTime;
	}
	public void setDeadTime(String deadTime) {
		this.deadTime = deadTime;
	}
	public String getType() {
		if(type==null){
			return "";
		}else{
			return type;
		}
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		if(desc==null){
			return "";
		}else{
			return desc;
		}
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImageUrl() {
		if(imageUrl==null){
			return "";
		}
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
