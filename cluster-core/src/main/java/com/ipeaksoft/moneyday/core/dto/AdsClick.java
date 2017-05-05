package com.ipeaksoft.moneyday.core.dto;

import java.util.Date;

import com.ipeaksoft.moneyday.core.entity.UserTaskAdsClick;

public class AdsClick extends Click {

	private static final long serialVersionUID = 1L;
	private String unionName;

	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AdsClick() {

	}

	public AdsClick(String mobile, String idfa, String unionName, String appID,
			String appName, String points, String macAddress, String clientIP,
			String OSVersion, String language, String SSID, String CarrierName,
			String currentProcess, int jailBreak, int clientType) {
		super(mobile, idfa, appID, appName, points, macAddress, clientIP,
				OSVersion, language, SSID, CarrierName, currentProcess,
				jailBreak, clientType);
		this.unionName = unionName;
	}

	public UserTaskAdsClick convertModel() {
		UserTaskAdsClick click = new UserTaskAdsClick();
		click.setMobile(mobile);
		click.setIdfa(idfa);
		click.setUnionName(unionName);
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
		click.setCreateTime(new Date());
		click.setClientType(clientType);
		return click;
	}
}
