package com.ipeaksoft.moneyday.api.vo;

public class FastActive extends BaseObject {
	private static final long serialVersionUID = 1L;
	private String idfa;
	private String process;
	private String taskId;
	private String appID;
	private String macAddress;
	private String deviceKey;
	private String networkType;
	private String clientIP;
	private String OSVersion;
	private String language;
	private String SSID;
	private String CarrierName;
	private String jailBreak;
	// 客户端的类型:0网页1微信3app线下4app线上
	private Integer clientType;
	private String mobile;
	private String taskSource; // 任务的来源。“self"自有/"ruanlie"软猎/"xingzhetianxia"行者天下...等类型

	public FastActive() {
	    
	}

	public FastActive(String idfa, String process, String taskId, String appID,
			String macAddress, String deviceKey, String networkType,
			String clientIP, String OSVersion, String language, String SSID,
			String CarrierName, String jailBreak, int clientType, String mobile, String taskSource) {
		this.idfa = idfa;
		this.process = process;
		this.taskId = taskId;
		this.appID = appID;
		this.macAddress = macAddress;
		this.deviceKey = deviceKey;
		this.networkType = networkType;
		this.clientIP = clientIP;
		this.OSVersion = OSVersion;
		this.language = language;
		this.SSID = SSID;
		this.CarrierName = CarrierName;
		this.jailBreak = jailBreak;
		this.clientType = clientType;
		this.mobile = mobile;
		this.taskSource = taskSource;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getOSVersion() {
		return OSVersion;
	}

	public void setOSVersion(String oSVersion) {
		OSVersion = oSVersion;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
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

	public String getJailBreak() {
		return jailBreak;
	}

	public void setJailBreak(String jailBreak) {
		this.jailBreak = jailBreak;
	}

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

}
