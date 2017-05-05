package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

/**
 * @description 兑换模块下交易订单相关的实体类
 * @author sxy
 * 2015年1月22日 下午6:07:27
 * 
 */
public class StatRecharged{
    private Date    day;

    private Integer amount                = 0;

    private Integer rechargeAmountSuccess        = 0;

    private Integer rechargeAmountFail        = 0;
    
    private Integer cashAmountSuccess            = 0;

    private Integer cashAmountFail            = 0;

    private Integer times   = 0;

    private Integer successtimes = 0;

    private Integer failtimes  = 0;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRechargeAmountSuccess() {
        return rechargeAmountSuccess;
    }

    public void setRechargeAmountSuccess(Integer rechargeAmountSuccess) {
        this.rechargeAmountSuccess = rechargeAmountSuccess;
    }

    public Integer getRechargeAmountFail() {
        return rechargeAmountFail;
    }

    public void setRechargeAmountFail(Integer rechargeAmountFail) {
        this.rechargeAmountFail = rechargeAmountFail;
    }

    public Integer getCashAmountSuccess() {
        return cashAmountSuccess;
    }

    public void setCashAmountSuccess(Integer cashAmountSuccess) {
        this.cashAmountSuccess = cashAmountSuccess;
    }

    public Integer getCashAmountFail() {
        return cashAmountFail;
    }

    public void setCashAmountFail(Integer cashAmountFail) {
        this.cashAmountFail = cashAmountFail;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getSuccesstimes() {
        return successtimes;
    }

    public void setSuccesstimes(Integer successtimes) {
        this.successtimes = successtimes;
    }

    public Integer getFailtimes() {
        return failtimes;
    }

    public void setFailtimes(Integer failtimes) {
        this.failtimes = failtimes;
    }

}