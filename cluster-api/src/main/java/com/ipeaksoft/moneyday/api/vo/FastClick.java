package com.ipeaksoft.moneyday.api.vo;

import java.util.Date;

import com.ipeaksoft.moneyday.core.entity.UserTaskFastClick;
import com.ipeaksoft.moneyday.core.util.Constant;

public class FastClick extends Click {

	private static final long serialVersionUID = 1L;
	private String taskID;
	private String taskSource; // 任务的来源。“self"自有/"ruanlie"软猎/"xingzhetianxia"行者天下...等类型

	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public FastClick() {

	}

	public FastClick(String mobile, String idfa, String taskID, String appID,
			String appName, String points, String macAddress, String clientIP,
			String OSVersion, String language, String SSID, String CarrierName,
			String currentProcess, int jailBreak, int clientType) {
		super(mobile, idfa, appID, appName, points, macAddress, clientIP,
				OSVersion, language, SSID, CarrierName, currentProcess,
				jailBreak, clientType);
		this.taskID = taskID;
	}

	public UserTaskFastClick convertModel() {
		UserTaskFastClick click = new UserTaskFastClick();
		click.setMobile(mobile);
		click.setIdfa(idfa);
		click.setTaskId(Long.parseLong(taskID));
		click.setAppid(appID);
		click.setAppname(appName);
		click.setPoint(points);
		click.setCarrierName(CarrierName);
		click.setClientip(clientIP);
		click.setJailBreak(jailBreak);
		click.setLanguage(language);
		click.setMacAddress(macAddress);
		click.setOsversion(OSVersion);
		click.setProcess(currentProcess);
		click.setSsid(SSID);
		click.setClientType((null==clientType) ? Constant.CLIENTTYPE_APPOFFLINE : clientType);
		click.setCreateTime(new Date());
		return click;
	}
}
