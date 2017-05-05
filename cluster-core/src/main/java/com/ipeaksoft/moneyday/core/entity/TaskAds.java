package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class TaskAds {
    private Integer id;

    private String name;
    
	private String image;
    
    private String description;

    private String requestUrl;

    private Date createTime;

    private Integer operator;

    private Byte priority;

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Short numorder;
    
	private String enable;
	
	private String userName;
	private String mobile;

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
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
    public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}