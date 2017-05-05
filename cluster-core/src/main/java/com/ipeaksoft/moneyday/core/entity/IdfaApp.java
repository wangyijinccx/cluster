package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class IdfaApp {
    private Integer id;

    private String idfa;

    private String appid;

    private Date createTime;
    
	private Integer numorder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Integer getNumorder() {
		return numorder;
	}

	public void setNumorder(Integer numorder) {
		this.numorder = numorder;
	}


}