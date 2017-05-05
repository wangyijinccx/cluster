package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class UserCashOrder {

    private Date day;

    private Integer amount;

    private Integer status;

    private Integer times;

    private String fromto;

    private String exchange_type;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getFromto() {
        return fromto;
    }

    public void setFromto(String fromto) {
        this.fromto = fromto;
    }

    public String getExchange_type() {
        return exchange_type;
    }

    public void setExchange_type(String exchange_type) {
        this.exchange_type = exchange_type;
    }

}
