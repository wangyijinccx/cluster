package com.ipeaksoft.moneyday.core.dto;

public class ActiveDomob extends ActiveBase {
	private static final long serialVersionUID = 1L;
	//字符串	订单ID。该值是唯一的，如果开发者接收到相同的订单号，那说明该订单已经存在。
	private String orderid;
	//字符串	Publisher ID，即开发者的积分墙应用ID
	private String pubid;
	//字符串	广告名称
	private String ad;
	//整型	广告ID，即offer ID
	private String adid;
	/**
	 * iOS平台，若开发者没有在积分墙iOS SDK中绑定userid，
	 * 或对于没有升级到嵌入了SDK 2.0.3以上版本SDK的用户，
	 * 则user为经过md5加密的用户设备的带冒号的大写的MAC地址。
	 * 例子：md5('24:AB:81:5E:F6:1E')= 13A81BB8DCA00BE81794E246C8429C0E
	 * android平台，如果开发者没有在积分墙android SDK中绑定userid，则user为设备的imei
	 */
	private String user;
	//字符串	设备号。
	private String device;
	//整型	渠道号。预留给android的推广，对于iOS来说该值为0
	private String channel;
	//浮点型，保留两位小数	开发者获得的收入
	private String price;
	//整型	用户可获得的积分
	private String point;
	//整型	成功结算的时间戳，精确到秒
	private String ts;
	//字符串	签名。根据private_key与所有参数共同计算得出。
	private String sign;

	public ActiveDomob(){}
	public ActiveDomob(String orderid, String pubid, String ad, String adid,
			String user, String device, String channel, String price, 
			String point, String ts, String sign){
		this.orderid = orderid;
		this.pubid = pubid;
		this.ad = ad;
		this.adid = adid;
		this.user = user;
		this.device = device;
		this.channel = channel;
		this.price =  price;
		this.point = point;
		this.ts = ts;
		this.sign = sign;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getPubid() {
		return pubid;
	}
	public void setPubid(String pubid) {
		this.pubid = pubid;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getAdid() {
		return adid;
	}
	public void setAdid(String adid) {
		this.adid = adid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

}
