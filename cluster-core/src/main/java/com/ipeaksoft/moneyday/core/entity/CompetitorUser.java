package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

// 每个用户对应的竞品信息
public class CompetitorUser {
   
    private Integer id;
    private String mobile;
    private String idfa;
    private String competitorid;
    private Date createTime;
    private Date modifyTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getIdfa() {
        return idfa;
    }
    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }
    public String getCompetitorid() {
        return competitorid;
    }
    public void setCompetitorid(String competitorid) {
        this.competitorid = competitorid;
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
    @Override
    public String toString() {
        return super.toString();
    }
    
}
