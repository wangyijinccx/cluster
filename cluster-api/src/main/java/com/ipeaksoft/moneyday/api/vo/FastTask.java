package com.ipeaksoft.moneyday.api.vo;

import com.ipeaksoft.moneyday.core.entity.TaskFast;

public class FastTask extends BaseObject {
	private static final long serialVersionUID = 1L;
	private String idfa;
	private String userId;
	private String clickTime;
	private String tourist;// 0-
	private String taskId;
	private String icon;// Icon的地址
	private String appID;// 应用的appID
	private String name;// 应用的名字
	private String shortDesc;// 任务描述
	private String remainNum;// 剩余数目
	private String remainTime;// 剩余时间
	private Float reward;// 任务的奖励
	private String status;// 任务完成的状态
	private String keyword;// 任务的关键字
	private String downloadUrl;// 任务的下载地址
	private String size;// 应用的大小
	private String advancedTask;// 0都可以做，1只有高级用户可以做
	private String mobile;
	private String type;
	private String sequence;// 排序
	private String urlscheme;
	private String compareType;// 对比方式
	private String limit;// 审核过期时间（int）--分钟
	private String operateStep;// 操作步骤
	private String total;
	private Integer finished;

	public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public String getOperateStep() {
        return operateStep;
    }

    public void setOperateStep(String operateStep) {
        this.operateStep = operateStep;
    }

    public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCompareType() {
		return compareType;
	}

	public void setCompareType(String compareType) {
		this.compareType = compareType;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getUrlscheme() {
		return urlscheme;
	}

	public void setUrlscheme(String urlscheme) {
		this.urlscheme = urlscheme;
	}

	public String getClickTime() {
		return clickTime;
	}

	public void setClickTime(String clickTime) {
		this.clickTime = clickTime;
	}

	public String getSequence() {
		if (sequence == null) {
			return "";
		}
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getType() {
		if (type == null) {
			return "";
		}
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		if (icon == null) {
			return "";
		}
		return icon;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAppID() {
		if (appID == null) {
			return "";
		}
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getName() {
		if (name == null) {
			return "";
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		if (shortDesc == null) {
			return "";
		}
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getRemainNum() {
		if (remainNum == null) {
			return "";
		}
		return remainNum;
	}

	public void setRemainNum(String remainNum) {
		this.remainNum = remainNum;
	}

	public String getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(String remainTime) {
		this.remainTime = remainTime;
	}

	public Float getReward() {
		return reward;
	}

	public void setReward(Float reward) {
		this.reward = reward;
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

	public String getKeyword() {
		if (keyword == null) {
			return "";
		}
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAdvancedTask() {
		return advancedTask;
	}

	public void setAdvancedTask(String advancedTask) {
		this.advancedTask = advancedTask;
	}

	public FastTask() {

	}

	public FastTask(String idfa, String userId, String tourist) {
		this.idfa = idfa;
		this.userId = userId;
		this.tourist = tourist;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public TaskFast convertModel() {
		TaskFast active = new TaskFast();
		// 游客
		if ("1".equals(tourist)) {
			active.setSearchIdfa(idfa);
		} else {
			if (mobile == null || "".equals(mobile)) {
				active.setSearchIdfa(idfa);
			} else {
				active.setMobile(mobile);
			}
		}
		return active;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTourist() {
		return tourist;
	}

	public void setTourist(String tourist) {
		this.tourist = tourist;
	}
}
