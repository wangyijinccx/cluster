package com.ipeaksoft.moneyday.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public String host ="localhost";
	// 获得所有设备列表
	public String devices = "http://"+host+"/dms/devices";
	// 得到所有的脚本列表
	public String scripts = "http://"+host+"/dms/scripts";
	// 得到某个游戏有哪些脚本可以跑
	public String game_scripts = "http://"+host+"/dms/game_scripts?id=%s&version=%s&platform=%s";
	// 重启一个设备
	public String reboot_device = "http://"+host+"/dms/reboot_device?udid=%s";
	// 执行脚本
	public String run_script = "http://"+host+"/dms/run_script"
			+ "?udid=%s&internal_id=%s&script_id=%s&game_id=%s"
			+ "&username=%s&password=%s&server=%s&time=%s&recover=";
	//强行停止当前脚本
	public String stop_script="http://"+host+"/dms/stop_script?udid=%s";
	//强行停止所有脚本
	public String stop_all_scripts = "http://"+host+"/dms/stop_all_scripts?udid=%s";
	//暂停当前脚本
	public String pause_script = "http://"+host+"/dms/pause_script?udid=%s";
	//继续当前脚本
	public String resume_script = "http://"+host+"/dms/resume_script?udid=%s";


}