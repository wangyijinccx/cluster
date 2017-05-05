package com.ipeaksoft.moneyday.admin.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String link;
	private List<Menu> subMenus = new ArrayList<Menu>();

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<Menu> getSubMenus() {
		return subMenus;
	}
	public void addSubMenus(Menu menu) {
		this.subMenus.add(menu);
	}

}
