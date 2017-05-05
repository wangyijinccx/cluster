package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class StatCash implements Comparable<StatCash>{
    private Date    day;

    private Integer rechargeAmount        = 0;

    private Integer rechargeOnlineAmount  = 0;

    private Integer rechargeOnlineTimes   = 0;

    private Integer rechargeOfflineAmount = 0;

    private Integer rechargeOfflineTimes  = 0;

    private Integer cashAmount            = 0;

    private Integer cashOnlineAmount      = 0;

    private Integer cashOnlineTimes       = 0;

    private Integer cashOfflineAmount     = 0;

    private Integer cashOfflineTimes      = 0;

    private Integer amount                = 0;

    private Integer pendingCount          = 0;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Integer rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Integer getRechargeOnlineAmount() {
        return rechargeOnlineAmount;
    }

    public void setRechargeOnlineAmount(Integer rechargeOnlineAmount) {
        this.rechargeOnlineAmount = rechargeOnlineAmount;
    }

    public Integer getRechargeOnlineTimes() {
        return rechargeOnlineTimes;
    }

    public void setRechargeOnlineTimes(Integer rechargeOnlineTimes) {
        this.rechargeOnlineTimes = rechargeOnlineTimes;
    }

    public Integer getRechargeOfflineAmount() {
        return rechargeOfflineAmount;
    }

    public void setRechargeOfflineAmount(Integer rechargeOfflineAmount) {
        this.rechargeOfflineAmount = rechargeOfflineAmount;
    }

    public Integer getRechargeOfflineTimes() {
        return rechargeOfflineTimes;
    }

    public void setRechargeOfflineTimes(Integer rechargeOfflineTimes) {
        this.rechargeOfflineTimes = rechargeOfflineTimes;
    }

    public Integer getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Integer cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Integer getCashOnlineAmount() {
        return cashOnlineAmount;
    }

    public void setCashOnlineAmount(Integer cashOnlineAmount) {
        this.cashOnlineAmount = cashOnlineAmount;
    }

    public Integer getCashOnlineTimes() {
        return cashOnlineTimes;
    }

    public void setCashOnlineTimes(Integer cashOnlineTimes) {
        this.cashOnlineTimes = cashOnlineTimes;
    }

    public Integer getCashOfflineAmount() {
        return cashOfflineAmount;
    }

    public void setCashOfflineAmount(Integer cashOfflineAmount) {
        this.cashOfflineAmount = cashOfflineAmount;
    }

    public Integer getCashOfflineTimes() {
        return cashOfflineTimes;
    }

    public void setCashOfflineTimes(Integer cashOfflineTimes) {
        this.cashOfflineTimes = cashOfflineTimes;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(Integer pendingCount) {
        this.pendingCount = pendingCount;
    }

    public int compareTo(StatCash o) {
        return o.getDay().compareTo(day);
    }
    
}