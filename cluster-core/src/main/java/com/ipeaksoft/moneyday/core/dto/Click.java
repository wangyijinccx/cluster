package com.ipeaksoft.moneyday.core.dto;

/**
 * 2015年3月9日 下午3:26:33
 */
public class Click extends BaseObject {
	protected static final long serialVersionUID = 1L;
	protected String mobile;
	protected String idfa;
	// 是否快速任务
	// protected String speedTask;
	protected String appID;
	protected String appName;
	// 应用的奖励金额
	protected String points;
	// mac地址
	protected String macAddress;
	// 客户端IP
	protected String clientIP;
	// 系统版本
	protected String OSVersion;
	// 系统语言
	protected String language;
	// 路由器的名字
	protected String SSID;
	// 运营商
	protected String CarrierName;
	// 当前进程
	protected String currentProcess;
	// 0表示没有越狱，大于0表示越狱了
	protected int jailBreak;
	// 客户端的类型:0网页1微信3app线下4app线上
	protected int clientType;

	public Click() {

	}

	public Click(String mobile, String idfa, String appID, String appName,
			String points, String macAddress, String clientIP,
			String OSVersion, String language, String SSID, String CarrierName,
			String currentProcess, int jailBreak, int clientType) {
		this.mobile = mobile;
		this.idfa = idfa;
//		this.speedTask = speedTask;
		this.appID = appID;
		this.appName = appName;
		this.points = points;
		this.macAddress = macAddress;
		this.clientIP = clientIP;
		this.OSVersion = OSVersion;
		this.language = language;
		this.SSID = SSID;
		this.CarrierName = CarrierName;
		this.currentProcess = currentProcess;
		this.jailBreak = jailBreak;
		this.clientType = clientType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	// public String getSpeedTask() {
	// return speedTask;
	// }
	//
	// public void setSpeedTask(String speedTask) {
	// this.speedTask = speedTask;
	// }

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public String getOSVersion() {
		return OSVersion;
	}

	public void setOSVersion(String oSVersion) {
		OSVersion = oSVersion;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSSID() {
		return SSID;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public String getCarrierName() {
		return CarrierName;
	}

	public void setCarrierName(String carrierName) {
		CarrierName = carrierName;
	}

	public String getCurrentProcess() {
		return currentProcess;
	}

	public void setCurrentProcess(String currentProcess) {
		this.currentProcess = currentProcess;
	}

	public int getJailBreak() {
		return jailBreak;
	}

	public void setJailBreak(int jailBreak) {
		this.jailBreak = jailBreak;
	}

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }
	
}
