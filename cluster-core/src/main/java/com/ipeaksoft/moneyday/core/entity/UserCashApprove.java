package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserCashApprove {
    private Long id;

    private String orderid;

    private String ordernum;

    private String result;

    private String description;

    private Integer operator;

    private Date approveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }
}