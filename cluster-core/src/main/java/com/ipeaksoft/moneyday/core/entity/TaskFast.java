package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskFast extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String appid;
	private String taskname;
	private String description;
	private String img;
	private Byte priority;
	private Short numorder;
	private String downloadUrl;
	private Double size;// 应用大小　
	private String compareType;// 对比方式
	private Integer limit;// 审核过期时间（int）--分钟
	private String taskSource;// 任务来源 “self"自有/"ruanlie"软猎/"xingzhetianxia"行者天下...等类型
	private String operateStep;// 操作步骤
	private String processName;//进程名称
	private Integer award;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date endTime;
	private Integer total;
	private Integer finished;
	private Date createTime;
	private Integer operator;
	private String appDescription;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date showStartTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date showEndTime;
	private Integer showNumorder;
	private String status;
	private String searchIdfa;
	private String mobile;
	private String type;
	private String statusName;
	private String orderStr;
	private String urlscheme;
	private String remainTime;
	private String searchFrom;
	private String searchEnd;
	private int taskType;
	private String keyWord;
	private int searchOrderNum;
	private String adId;
	private String channelName;
	private String xyId;
	
	//针对自动任务，记录接入价格
	private String income;
	
	//针对嵌入热云或者talkingdata之类SDK的游戏的数据对接短链
	private String sdkLink;
	private boolean duplicate;
	//是否需要激活上报
	private boolean activeUpload;
	//附加参数
	private String adId2;

    public String getAdId2() {
		return adId2;
	}

	public void setAdId2(String adId2) {
		this.adId2 = adId2;
	}

	public boolean isActiveUpload() {
		return activeUpload;
	}

	public void setActiveUpload(boolean activeUpload) {
		this.activeUpload = activeUpload;
	}

	public String getSdkLink() {
		return sdkLink;
	}

	public void setSdkLink(String sdkLink) {
		this.sdkLink = sdkLink;
	}

	public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	
	public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getCompareType() {
		return compareType;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setCompareType(String compareType) {
		this.compareType = compareType;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getUrlscheme() {
		return urlscheme;
	}

	public void setUrlscheme(String urlscheme) {
		this.urlscheme = urlscheme;
	}

	public String getOrderStr() {
		return orderStr;
	}

	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSearchIdfa() {
		if (searchIdfa == null) {
			return "";
		}
		return searchIdfa;
	}

	public String getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(String remainTime) {
		this.remainTime = remainTime;
	}

	public void setSearchIdfa(String searchIdfa) {
		this.searchIdfa = searchIdfa;
	}

	public String getMobile() {
		if (mobile == null) {
			return "";
		}
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		if (status == null) {
			return "";
		}
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSearchFrom() {
		return searchFrom;
	}

	public void setSearchFrom(String searchFrom) {
		this.searchFrom = searchFrom;
	}

	public String getSearchEnd() {
		return searchEnd;
	}

	public void setSearchEnd(String searchEnd) {
		this.searchEnd = searchEnd;
	}

	public String getAppDescription() {
		if (appDescription == null) {
			return "";
		}
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public Date getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(Date showStartTime) {
		this.showStartTime = showStartTime;
	}

	public Date getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(Date showEndTime) {
		this.showEndTime = showEndTime;
	}

	public Integer getShowNumorder() {
		return showNumorder;
	}

	public void setShowNumorder(Integer showNumorder) {
		this.showNumorder = showNumorder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	public Byte getPriority() {
		return priority;
	}

	public void setPriority(Byte priority) {
		this.priority = priority;
	}

	public Short getNumorder() {
		return numorder;
	}

	public void setNumorder(Short numorder) {
		this.numorder = numorder;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
	}

	public Integer getAward() {
		return award;
	}

	public void setAward(Integer award) {
		this.award = award;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getFinished() {
		return finished;
	}

	public void setFinished(Integer finished) {
		this.finished = finished;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getSearchOrderNum() {
		return searchOrderNum;
	}

	public void setSearchOrderNum(int searchOrderNum) {
		this.searchOrderNum = searchOrderNum;
	}

	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public String getOperateStep() {
        return operateStep;
    }

    public void setOperateStep(String operateStep) {
        this.operateStep = operateStep;
    }

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}
	public boolean isDuplicate() {
		return duplicate;
	}

	public void setDuplicate(boolean duplicate) {
		this.duplicate = duplicate;
	}

	public String getXyId() {
		return xyId;
	}

	public void setXyId(String xyId) {
		this.xyId = xyId;
	}
}