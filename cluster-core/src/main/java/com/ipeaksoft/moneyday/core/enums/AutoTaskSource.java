package com.ipeaksoft.moneyday.core.enums;

public enum AutoTaskSource {
    BATMOBI("BATMOBI"),
    Mobvista("Mobvista"),
    YEAHMOBI("YeahMobi"),
    AVAZU("AVAZU"),
    Appcoach("Appcoach"),
    WanPu("WanPu"),
    DianRu("DianRu"),
    ;

    private final String key;

    private AutoTaskSource(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
