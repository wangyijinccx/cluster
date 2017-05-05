package com.ipeaksoft.moneyday.core.dto;

import com.ipeaksoft.moneyday.core.entity.UserTaskAdsActive;

/**
 * 爱德威激活对象
 * identifier=1000&achieve_id=abdd100&point=100&user=1000&idfa=abcd-bcde-defg-efgh&appName=测试app&openudid=asdfsaf
 * @author Administrator
 *
 */
public class ActiveAidewei extends ActiveBase {
	private static final long serialVersionUID = 1L;

	// 用户的ID，用来定位具体的用户
	private String identifier;
	// 爱德威对成果的唯一标识
	private String achieve_id;
	// 返还给用户的金币数
	private String point;
	private String user;
	private String appName;
	// 有就传 广告标识符
	private String idfa;
	// 有就传 开源的广告唯一标识符
	private String openudid;

	public ActiveAidewei() {

	}

	public ActiveAidewei(String identifier, String achieve_id, String point,
			String user, String appName, String idfa, String openudid) {
		this.identifier = identifier;
		this.achieve_id = achieve_id;
		this.point = point;
		this.appName = appName;
		this.idfa = idfa;
		this.user = user;
		this.openudid = openudid;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getAchieve_id() {
		return achieve_id;
	}

	public void setAchieve_id(String achieve_id) {
		this.achieve_id = achieve_id;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getOpenudid() {
		return openudid;
	}

	public void setOpenudid(String openudid) {
		this.openudid = openudid;
	}

	public UserTaskAdsActive convertModel() {
		UserTaskAdsActive active = new UserTaskAdsActive();

		return active;
	}
}
