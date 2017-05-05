package com.ipeaksoft.moneyday.core.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLoginHistory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7287890585359785815L;

	private Integer id;

	private Long userId;

	private String ip;

	private String country;

	private String area;

	private String province;

	private String city;

	private String county;

	private String isp;

	private Date createTime;

	private Date modifyTime;
	
	/**
	 * 非数据库字段
	 */
	private String  puser1;      // 1级推广员
    private String  puser2;      // 2级推广员
    private String  puser3;      // 3级推广员
    private String mobile;      // 账号

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getPuser1() {
		return puser1;
	}

	public void setPuser1(String puser1) {
		this.puser1 = puser1;
	}

	public String getPuser2() {
		return puser2;
	}

	public void setPuser2(String puser2) {
		this.puser2 = puser2;
	}

	public String getPuser3() {
		return puser3;
	}

	public void setPuser3(String puser3) {
		this.puser3 = puser3;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserLoginHistory [id=" + id + ", userId=" + userId + ", ip=" + ip + ", country="
				+ country + ", area=" + area + ", province=" + province + ", city=" + city
				+ ", county=" + county + ", isp=" + isp + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", puser1=" + puser1 + ", puser2=" + puser2
				+ ", puser3=" + puser3 + ", mobile=" + mobile + "]";
	}

}