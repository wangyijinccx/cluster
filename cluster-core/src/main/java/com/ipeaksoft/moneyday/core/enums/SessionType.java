package com.ipeaksoft.moneyday.core.enums;

public enum SessionType {
	OPENID("openid"),
	IDFA("idfa"),
	MOBILE("mobile");
	
	private final String key;
	private SessionType(String key){
		this.key = key;
	}
	
	public String getKey(){
		return key;
	}
}
