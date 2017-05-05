package com.ipeaksoft.moneyday.core.entity;

import java.io.Serializable;
import java.util.Date;

public class UserTaskAdsClick implements Serializable{

	private static final long serialVersionUID = 3681160244208380951L;

	private Long id;

    private String mobile;

    private String idfa;

    private String unionName;

    private String appid;

    private String appname;

    private String point;

    private String macAddress;

    private String clientip;

    private String osversion;

    private String language;

    private String ssid;

    private String carrierName;

    private String process;

    private Integer jailBreak;
    
    private Integer clientType;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }

    public String getOsversion() {
        return osversion;
    }

    public void setOsversion(String osversion) {
        this.osversion = osversion;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Integer getJailBreak() {
        return jailBreak;
    }

    public void setJailBreak(Integer jailBreak) {
        this.jailBreak = jailBreak;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}