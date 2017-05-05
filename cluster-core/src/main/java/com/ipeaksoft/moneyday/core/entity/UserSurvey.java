package com.ipeaksoft.moneyday.core.entity;

public class UserSurvey extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Integer regitUsersAll;//累计注册用户
	public Integer getRegitUsersAll() {
		return regitUsersAll;
	}
	public void setRegitUsersAll(Integer regitUsersAll) {
		this.regitUsersAll = regitUsersAll;
	}
	private String fromto;//用户来源
	private String type;//用户类型
	private Integer users;//人数
	public String getFromto() {
		return fromto;
	}
	public void setFromto(String fromto) {
		this.fromto = fromto;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getUsers() {
		return users;
	}
	public void setUsers(Integer users) {
		this.users = users;
	}
	private Integer onlineAUsers;// 在线A类用户　
	private Integer onlineBUsers;// 在线B类用户　
	private Integer onlineCUsers;// 在线c类用户　
	private Integer onlineUsers;// 在线普通用户
	
	private Integer offlineAUsers;// 线下A类用户　
	private Integer offlineBUsers;// 线下B类用户　
	private Integer offlineCUsers;// 线下c类用户　
	private Integer offlineUsers;// 线下普通用户
	public Integer getOnlineAUsers() {
		return onlineAUsers;
	}
	public void setOnlineAUsers(Integer onlineAUsers) {
		this.onlineAUsers = onlineAUsers;
	}
	public Integer getOnlineBUsers() {
		return onlineBUsers;
	}
	public void setOnlineBUsers(Integer onlineBUsers) {
		this.onlineBUsers = onlineBUsers;
	}
	public Integer getOnlineCUsers() {
		return onlineCUsers;
	}
	public void setOnlineCUsers(Integer onlineCUsers) {
		this.onlineCUsers = onlineCUsers;
	}
	public Integer getOnlineUsers() {
		return onlineUsers;
	}
	public void setOnlineUsers(Integer onlineUsers) {
		this.onlineUsers = onlineUsers;
	}
	public Integer getOfflineAUsers() {
		return offlineAUsers;
	}
	public void setOfflineAUsers(Integer offlineAUsers) {
		this.offlineAUsers = offlineAUsers;
	}
	public Integer getOfflineBUsers() {
		return offlineBUsers;
	}
	public void setOfflineBUsers(Integer offlineBUsers) {
		this.offlineBUsers = offlineBUsers;
	}
	public Integer getOfflineCUsers() {
		return offlineCUsers;
	}
	public void setOfflineCUsers(Integer offlineCUsers) {
		this.offlineCUsers = offlineCUsers;
	}
	public Integer getOfflineUsers() {
		return offlineUsers;
	}
	public void setOfflineUsers(Integer offlineUsers) {
		this.offlineUsers = offlineUsers;
	}

}
