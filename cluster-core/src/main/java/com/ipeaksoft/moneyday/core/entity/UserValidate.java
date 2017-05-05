package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserValidate {
    private Long id;

    private String mobile;

    private String appId;
    
    private String taskId;

    private String appname;

    private String appcate;

    private String downloadUrl;

    private String imgUrl;

    private Date createTime;

    private Integer rank;
    
	private Date downloadTime;

    private Integer rankLater;

    private Date modifyTime;

    private String enable;
    
	private String clientType;
	
	private Integer rankLaterSecond;

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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppcate() {
        return appcate;
    }

    public void setAppcate(String appcate) {
        this.appcate = appcate;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getDownloadTime() {
		return downloadTime;
	}

	public void setDownloadTime(Date downloadTime) {
		this.downloadTime = downloadTime;
	}

    public Integer getRankLater() {
        return rankLater;
    }

    public void setRankLater(Integer rankLater) {
        this.rankLater = rankLater;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
    public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public Integer getRankLaterSecond() {
		return rankLaterSecond;
	}

	public void setRankLaterSecond(Integer rankLaterSecond) {
		this.rankLaterSecond = rankLaterSecond;
	}
}