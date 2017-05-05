package com.ipeaksoft.moneyday.core.entity;

public class UserPerformance extends AdminUser{
	private Integer jobs;//完成任务数
	private Integer fastJobs;//快速任务数
	private Integer adsJobs;//常规任务数
	private Integer shouyi;
	private Integer fastShouyi;
	private Integer adsShouyi;
	private Double cash;
	public Integer getJobs() {
		return jobs;
	}
	public void setJobs(Integer jobs) {
		this.jobs = jobs;
	}
	public Integer getFastJobs() {
		return fastJobs;
	}
	public void setFastJobs(Integer fastJobs) {
		this.fastJobs = fastJobs;
	}
	public Integer getAdsJobs() {
		return adsJobs;
	}
	public void setAdsJobs(Integer adsJobs) {
		this.adsJobs = adsJobs;
	}
	public Integer getShouyi() {
		return shouyi;
	}
	public void setShouyi(Integer shouyi) {
		this.shouyi = shouyi;
	}
	public Integer getFastShouyi() {
		return fastShouyi;
	}
	public void setFastShouyi(Integer fastShouyi) {
		this.fastShouyi = fastShouyi;
	}
	public Integer getAdsShouyi() {
		return adsShouyi;
	}
	public void setAdsShouyi(Integer adsShouyi) {
		this.adsShouyi = adsShouyi;
	}
	public Double getCash() {
		return cash;
	}
	public void setCash(Double cash) {
		this.cash = cash;
	}
	
}
