package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class AdsSource {
    private Integer id;

    private String key;

    private String value;

    private String description;

    private Boolean enable;

    private String clickUrl;

	private String duplicateUrl;

    private String activeUrl;

    private Date createTime;

	private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getDuplicateUrl() {
		return duplicateUrl;
	}

	public void setDuplicateUrl(String duplicateUrl) {
		this.duplicateUrl = duplicateUrl;
	}

    public String getActiveUrl() {
        return activeUrl;
    }

    public void setActiveUrl(String activeUrl) {
        this.activeUrl = activeUrl;
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
}