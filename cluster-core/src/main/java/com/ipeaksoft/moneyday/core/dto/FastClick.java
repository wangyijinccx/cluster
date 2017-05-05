package com.ipeaksoft.moneyday.core.dto;

import java.util.Date;

import com.ipeaksoft.moneyday.core.entity.UserTaskFastClick;
import com.ipeaksoft.moneyday.core.util.Constant;

public class FastClick extends Click {

	private static final long serialVersionUID = 1L;
	protected String taskId;
	private String callback;

	
	public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public FastClick() {

	}

	public FastClick(String mobile, String idfa, String taskID, String appID,
			String appName, String points, String macAddress, String clientIP,
			String OSVersion, String language, String SSID, String CarrierName,
			String currentProcess, int jailBreak, int clientType, String taskId) {
		super(mobile, idfa, appID, appName, points, macAddress, clientIP,
				OSVersion, language, SSID, CarrierName, currentProcess,
				jailBreak, clientType);
		this.taskId = taskId;
	}

	public UserTaskFastClick convertModel() {
		UserTaskFastClick click = new UserTaskFastClick();
		click.setMobile(mobile);
		click.setIdfa(idfa);
		try {
			click.setTaskId(Long.parseLong(taskId));
		} catch (NumberFormatException e) {
		}
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
		click.setClientType(Constant.CLIENTTYPE_WECHAT);
		click.setCreateTime(new Date());
		return click;
	}
}
