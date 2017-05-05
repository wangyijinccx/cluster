package com.ipeaksoft.moneyday.core.enums;

public enum UserRecordType {
	FAST("快速任务"),
	ADS("联盟任务"),
	RECHARGE("充值"),
	RECHARGE_FAIL("充值失败"),
	CASH("提现"),
	CASH_FAIL("提现失败"),
	AWARD("连续任务奖励");
	
	private final String key;
	private UserRecordType(String key){
		this.key = key;
	}
	
	public String getKey(){
		return key;
	}
}
