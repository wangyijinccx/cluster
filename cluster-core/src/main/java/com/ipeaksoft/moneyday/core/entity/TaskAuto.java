package com.ipeaksoft.moneyday.core.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ipeaksoft.moneyday.core.enums.AutoTaskSource;

public class TaskAuto {
    private Long id;

    private String appid;

    private String name;

    private String category;

    private String adid;

    private BigDecimal price;

    private String unit;

    private String clickUrl;

    private Date startTime;

    private Date endTime;

    private String taskType;

    private AutoTaskSource source;

    private Date createTime;

	private Date modifyTime;
    
	private String appname;
    
	private String icon;
	
	private String prize;
	private String noprize;
	
	//每日最大转化量
	private Integer dailyCap;
	
	private String description;
	
	private String keyWord;
    
    public Integer getDailyCap() {
		return dailyCap;
	}

	public void setDailyCap(Integer dailyCap) {
		this.dailyCap = dailyCap;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
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

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public AutoTaskSource getSource() {
        return source;
    }

    public void setSource(AutoTaskSource source) {
        this.source = source;
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

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getNoprize() {
		return noprize;
	}

	public void setNoprize(String noprize) {
		this.noprize = noprize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}


}