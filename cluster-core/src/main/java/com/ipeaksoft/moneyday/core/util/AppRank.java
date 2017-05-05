package com.ipeaksoft.moneyday.core.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 检验指定AppleId是否有效URL实体
 * 
 * @author chenshuangyuan
 *
 */
public class AppRank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cat; // Appstore的分类
	private Integer tab; // 0为收费，1为免费，2为畅销
	private Integer pos; // 排名
	private Integer appid; // Appstore上面App的Id
	private String name; // App名称
	private String url; // app的url，也就是checkUrl
	private Integer price; // App的价格
	private Integer size; // App的大小
	private Date createTime;
	private Date modifyTime;
	private String[] icons;

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public Integer getTab() {
		return tab;
	}

	public void setTab(Integer tab) {
		this.tab = tab;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
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

	public String[] getIcons() {
		return icons;
	}

	public void setIcons(String[] icons) {
		this.icons = icons;
	}

	@Override
	public String toString() {
		return "AppRank [cat=" + cat + ", tab=" + tab + ", pos=" + pos + ", appid=" + appid
				+ ", name=" + name + ", url=" + url + ", price=" + price + ", size=" + size
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", icons="
				+ Arrays.toString(icons) + "]";
	}
	
}
