package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class StatDaySearch {
    private Long id;

    private Date day;

    private Integer timesFast;

    private Integer awardFast;

    private Integer timesAds;

    private Integer awardAds;

    private Integer awardTotal;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getTimesFast() {
        return timesFast;
    }

    public void setTimesFast(Integer timesFast) {
        this.timesFast = timesFast;
    }

    public Integer getAwardFast() {
        return awardFast;
    }

    public void setAwardFast(Integer awardFast) {
        this.awardFast = awardFast;
    }

    public Integer getTimesAds() {
        return timesAds;
    }

    public void setTimesAds(Integer timesAds) {
        this.timesAds = timesAds;
    }

    public Integer getAwardAds() {
        return awardAds;
    }

    public void setAwardAds(Integer awardAds) {
        this.awardAds = awardAds;
    }

    public Integer getAwardTotal() {
        return awardTotal;
    }

    public void setAwardTotal(Integer awardTotal) {
        this.awardTotal = awardTotal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}