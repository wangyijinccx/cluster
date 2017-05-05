package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class BlackUser {
    private Long id;

    private Long userid;

    private String username;

    private Date createTime;

    private String idfa;

    private Boolean status;

    private String mobile;
    
    private String name;
    
    private Date registerTime;
    
    private Integer award;
    
    private Integer exceptioncount;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getAward() {
		return award;
	}

	public void setAward(Integer award) {
		this.award = award;
	}

	public Integer getExceptioncount() {
		return exceptioncount;
	}

	public void setExceptioncount(Integer exceptioncount) {
		this.exceptioncount = exceptioncount;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa == null ? null : idfa.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
}