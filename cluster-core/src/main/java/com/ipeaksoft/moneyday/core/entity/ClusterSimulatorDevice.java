package com.ipeaksoft.moneyday.core.entity;

public class ClusterSimulatorDevice {
	private String udid;  // 设备id
	private String internalId;  // 内部id, 刷机备份相关的那个id
	private String platform; // 系统
	private String version;  // 系统版本
	private String model;  // 设备型号, 对于iPhone, 可能是iPhone4,1这样, 对于android, 就可能是Samsung S6这样
	private String state;  // 当前设备状态
	private String name; // 设备名称,
	private Boolean emulator;  // true表示是模拟器
	private String vendor;  // 设备制造商, 比如Nox表示是夜神模拟器, Google表示这应该是一个Nexus系列手机或者官方模拟器
	
	// 仅当设备状态是BUSY时有意义
	private String script;  // 正在运行的脚本名称
	private String scriptState;  // 脚本运行状态
	private String scriptErrorCode; // 脚本状态如果是error, 这里是脚本的错误码
	private String scriptErrorMsg; // 脚本状态如果是error, 这里是脚本的错误信息
	public String getUdid() {
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
	}
	public String getInternalId() {
		return internalId;
	}
	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getEmulator() {
		return emulator;
	}
	public void setEmulator(Boolean emulator) {
		this.emulator = emulator;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public String getScriptState() {
		return scriptState;
	}
	public void setScriptState(String scriptState) {
		this.scriptState = scriptState;
	}
	public String getScriptErrorCode() {
		return scriptErrorCode;
	}
	public void setScriptErrorCode(String scriptErrorCode) {
		this.scriptErrorCode = scriptErrorCode;
	}
	public String getScriptErrorMsg() {
		return scriptErrorMsg;
	}
	public void setScriptErrorMsg(String scriptErrorMsg) {
		this.scriptErrorMsg = scriptErrorMsg;
	}
}
