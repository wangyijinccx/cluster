package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class Version {
    private Integer id;

    private String os;
    
    private int clientType;

    private String version;
    
    private String url;//新版本的下载地址
    
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersionDesc() {
		return versionDesc;
	}

	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}

	private String versionDesc;//任务部分有更新

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}