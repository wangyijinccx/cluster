package com.ipeaksoft.moneyday.api.vo;

public class UserVo {
	private String userID;//基本信息
	private String appleId;//苹果账号
	private String name;//姓名
	private String address;//住的地址
	private String province;//省份
	private String city;//城市
	private String region;//区
	private String IDCard;//身份证
	private String type;
	private String userName;
	private String tourist;//0－非游客，1：游客
	public String getTourist() {
		return tourist;
	}

	public void setTourist(String tourist) {
		this.tourist = tourist;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String inviteCode;
	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAppleId() {
		return appleId;
	}

	public void setAppleId(String appleId) {
		this.appleId = appleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String mobile;
	private String password;
	private String popularizedId;
	private String idfa;
	private String phoneType;
	private String usertype;//用户类型
	private String highUser;//是否是高级用户
	private String currentIdfa;//当前的IDFA
	public String getCurrentIdfa() {
		return currentIdfa;
	}

	public void setCurrentIdfa(String currentIdfa) {
		this.currentIdfa = currentIdfa;
	}

	public String getHighUser() {
		return highUser;
	}

	public void setHighUser(String highUser) {
		this.highUser = highUser;
	}



	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	private String OSversion;
	private String system;
	private String IP;
	private String location;
	private String appVersion;
	
	private String clientType;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPopularizedId() {
		return popularizedId;
	}

	public void setPopularizedId(String popularizedId) {
		this.popularizedId = popularizedId;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getOSversion() {
		return OSversion;
	}

	public void setOSversion(String oSversion) {
		OSversion = oSversion;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	
}
