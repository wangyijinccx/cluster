package com.ipeaksoft.moneyday.core.entity;
/**
 * 快速任务概览
 * @author Administrator
 *
 */
public class QuickTaskSurvey {
	private String rq;//日期
	private Integer ksrwwccs;//快速任务完成次数
	private Integer cyrs;//参与人数
	private Integer xsyh;//线上用户
	private Double xssy;//线上收益
	private Integer xxyh;///线下用户
	private Integer xxsy;///线下收益
	private Integer drzsy;///单日总收益
	private Double wcd;//完成度－－
	private Integer zsy;///总收益
	
	public Double getWcd() {
		return wcd;
	}
	public void setWcd(Double wcd) {
		this.wcd = wcd;
	}
	public Integer getZsy() {
		return zsy;
	}
	public void setZsy(Integer zsy) {
		this.zsy = zsy;
	}
	public String getRq() {
		return rq;
	}
	public void setRq(String rq) {
		this.rq = rq;
	}
	public Integer getKsrwwccs() {
		return ksrwwccs;
	}
	public void setKsrwwccs(Integer ksrwwccs) {
		this.ksrwwccs = ksrwwccs;
	}
	public Integer getCyrs() {
		return cyrs;
	}
	public void setCyrs(Integer cyrs) {
		this.cyrs = cyrs;
	}
	public Integer getXsyh() {
		return xsyh;
	}
	public void setXsyh(Integer xsyh) {
		this.xsyh = xsyh;
	}
	public Double getXssy() {
		return xssy;
	}
	public void setXssy(Double xssy) {
		this.xssy = xssy;
	}
	public Integer getXxyh() {
		return xxyh;
	}
	public void setXxyh(Integer xxyh) {
		this.xxyh = xxyh;
	}
	public Integer getXxsy() {
		return xxsy;
	}
	public void setXxsy(Integer xxsy) {
		this.xxsy = xxsy;
	}
	public Integer getDrzsy() {
		return drzsy;
	}
	public void setDrzsy(Integer drzsy) {
		this.drzsy = drzsy;
	}
}
