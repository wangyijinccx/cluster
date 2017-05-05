package com.ipeaksoft.moneyday.core.entity;

public class LoginAward {
	private String desc;//任务描述
	private String status;//任务状态，0代表不可领取，1代表可以领取，2代表领取完毕
	private String percentage;//任务完成的百分比
	private String receiveAmount;//连续登陆任务完成的奖励
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPercentage() {
		if(percentage==null){
			return "";
		}else{
			return percentage;
		}
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getReceiveAmount() {
		return receiveAmount;
	}
	public void setReceiveAmount(String receiveAmount) {
		this.receiveAmount = receiveAmount;
	}
}
