package com.ipeaksoft.moneyday.core.entity;
import java.util.Date;
public class TaskFastStatistics extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private int ksrwwczcs;
	public int getKsrwwczcs() {
		return ksrwwczcs;
	}
	public void setKsrwwczcs(int ksrwwczcs) {
		this.ksrwwczcs = ksrwwczcs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int cyrs;
	private int xsyhc;
	private int xssyjb;
	private int xxyhc;
	private int xxsyjb;
	private int drzsy;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCyrs() {
		return cyrs;
	}
	public void setCyrs(int cyrs) {
		this.cyrs = cyrs;
	}
	public int getXsyhc() {
		return xsyhc;
	}
	public void setXsyhc(int xsyhc) {
		this.xsyhc = xsyhc;
	}
	public int getXssyjb() {
		return xssyjb;
	}
	public void setXssyjb(int xssyjb) {
		this.xssyjb = xssyjb;
	}
	public int getXxyhc() {
		return xxyhc;
	}
	public void setXxyhc(int xxyhc) {
		this.xxyhc = xxyhc;
	}
	public int getXxsyjb() {
		return xxsyjb;
	}
	public void setXxsyjb(int xxsyjb) {
		this.xxsyjb = xxsyjb;
	}
	public int getDrzsy() {
		return drzsy;
	}
	public void setDrzsy(int drzsy) {
		this.drzsy = drzsy;
	}

}