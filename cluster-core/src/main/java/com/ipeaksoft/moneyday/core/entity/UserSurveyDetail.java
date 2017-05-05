package com.ipeaksoft.moneyday.core.entity;

public class UserSurveyDetail  extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 100L;
	private String date;// 日期
	private Integer newuser;// 新用户人数
	private Integer visitor;// 游客人数

	private Integer alluser;// 注册人数
	private Integer visitortouser;// 游客转用户人数
	private Double pecent;// 转化率
	private Integer ptzgj;// 普通转高级
	private Double ptzgjpecent;// 普通转高级转化率
	private Integer loginactive;// 登录活跃人数
	private Integer downloadactive;// 下载人数

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getNewuser() {
		return newuser;
	}

	public void setNewuser(Integer newuser) {
		this.newuser = newuser;
	}

	public Integer getVisitor() {
		return visitor;
	}

	public void setVisitor(Integer visitor) {
		this.visitor = visitor;
	}

	public Integer getAlluser() {
		return alluser;
	}

	public void setAlluser(Integer alluser) {
		this.alluser = alluser;
	}

	public Integer getVisitortouser() {
		return visitortouser;
	}

	public void setVisitortouser(Integer visitortouser) {
		this.visitortouser = visitortouser;
	}

	public Double getPecent() {
		return pecent;
	}

	public void setPecent(Double pecent) {
		this.pecent = pecent;
	}

	public Integer getPtzgj() {
		return ptzgj;
	}

	public void setPtzgj(Integer ptzgj) {
		this.ptzgj = ptzgj;
	}

	public Double getPtzgjpecent() {
		return ptzgjpecent;
	}

	public void setPtzgjpecent(Double ptzgjpecent) {
		this.ptzgjpecent = ptzgjpecent;
	}

	public Integer getLoginactive() {
		return loginactive;
	}

	public void setLoginactive(Integer loginactive) {
		this.loginactive = loginactive;
	}

	public Integer getDownloadactive() {
		return downloadactive;
	}

	public void setDownloadactive(Integer downloadactive) {
		this.downloadactive = downloadactive;
	}

}
