package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserLoginException {
    private Long id;
    private String moblie;
    private String city;
    private String province;
    private String region;
    private Date createTime;
    private String appleId;
    private Date processTime;
    private String operator;
    private String clientType;
    private String status;
    private String userName;
    private String address;
    private Integer exceptionnum;
    private String idfa;
    
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public Integer getExceptionnum() {
		return exceptionnum;
	}

	public void setExceptionnum(Integer exceptionnum) {
		this.exceptionnum = exceptionnum;
	}
	
    public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public Date getProcessTime() { 
		return processTime;
	}

	public void setProcessTime(Date processTime) {
		this.processTime = processTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie == null ? null : moblie.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAppleId() {
        return appleId;
    }

    public void setAppleId(String appleId) {
        this.appleId = appleId == null ? null : appleId.trim();
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa == null ? null : idfa.trim();
    }
}