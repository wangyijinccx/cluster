package com.ipeaksoft.moneyday.core.enums;

public enum Status {
	OFFLINE("宕机"),
	BUSY("占用"),
	FREE("空闲"),
	BOOT("启动中"),
	RUNNING("2"),
    ERROR("3"),
    DONE("1"),
    PAUSE("4"),
    STOP("1");
    ;

    private final String key;

    private Status(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
