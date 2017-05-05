package com.ipeaksoft.moneyday.api.vo;

public class WanXiangVo extends BaseObject {

    public static final String KEY = "zhangtong";

    private static final long serialVersionUID = 1L;
    
    private String            adId;
    private String            mac;
    private String            idfa;
    private String            deviceId;
    private String            sign; // MD5加密
    private Integer           Type;
    
    private String mobile;
    
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAdId() {
        return adId;
    }
    public void setAdId(String adId) {
        this.adId = adId;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getIdfa() {
        return idfa;
    }
    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    public Integer getType() {
        return Type;
    }
    public void setType(Integer type) {
        Type = type;
    }

}
