package com.ipeaksoft.moneyday.api.vo;

import java.io.UnsupportedEncodingException;


/**
 * _fb=128239823&order=12345&app=1009898&ap=测试app&adid=8789
 * &user=1000&device=abcd-bcde-defg-efgh&chn=0&price=1.0&points=100
 * &time=20150118&storeid=0080&sig=dd&sign=ddeeff
 * @author Administrator
 *
 */
public class ActiveYouMi extends ActiveBase {
	private static final long serialVersionUID = 1L;
	//该值是在请求过程中传入的预留参数fb
	private String _fb;
	//订单ID：该值是唯一的，如果开发者接收到相同的订单号，那说明该订单已经存在。
	private String order;
	//App ID	开发者应用ID
	private String app;
	//广告名，如果是应用类型的广告则是应用名
	private String ad;
	//广告的编号ID
	private String adid;
	//用户ID
	private String user;
	//设备ID：iOS是MAC地址，iOS 7 没有MAC地址则传 (IDFA)
	private String device;
	//渠道号，对于IOS来说该值为0
	private String chn;
	//开发者获得的收入
	private String price;
	//用户可以赚取的金币
	private String points;
	//有米创建订单的时间
	private String time;
	//应用商店的Id
	private String storeid;
	//保留字段（无意义）
	private String sig;
	//签名
	private String sign;

	public ActiveYouMi(){}
//	public ActiveYouMi(String _fb, String order, String app, String ad,
//			String adid, String user, String device, String chn, 
//			String price, String points, String time, String storeid,
//			String sig, String sign){
//		this._fb = _fb;
//		this.order = order;
//		this.app = app;
//		try {
//			this.ad = URLDecoder.decode(ad, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//		}
//		this.adid = adid;
//		this.user = user;
//		this.device = device;
//		this.chn = chn;
//		this.price = price;
//		this.points = points;
//		this.time = time;
//		this.storeid = storeid;
//		this.sig = sig;
//		this.sign = sign;
//	}
	
	public String get_fb() {
		return _fb;
	}
	public void set_fb(String _fb) {
		this._fb = _fb;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		try {
			this.ad = new String(ad.getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public String getChn() {
		return chn;
	}
	public void setChn(String chn) {
		this.chn = chn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStoreid() {
		return storeid;
	}
	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}


}
