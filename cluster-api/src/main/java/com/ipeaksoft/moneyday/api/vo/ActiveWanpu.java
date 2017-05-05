package com.ipeaksoft.moneyday.api.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class ActiveWanpu extends ActiveBase {
	private static final long serialVersionUID = 1L;
	// 被下载应用ID
	private String adv_id;
	// 调用推荐列表的应用ID
	private String app_id;
	// 调用推荐列表时传递的key或用户ID XXX@sina.com
	private String key;
	// 设备唯码(ios7以下使用MAC地址,ios7以上使用idfa)
	private String udid;
	// 设备openudid 5d2fd12f4c011eab4cdcec66d09e429ad8d251bc
	private String open_udid;
	// 价格,单位元 2.5，如果获取到该参数值为0或null，则表示该条数据无效
	private String bill;
	// 积分,单位为服务端设置(金币) 50，如果判断bill为0或null，则给用户积分时，points也为0.
	private String points;
	// 被激活应用名称 %E6%B5%8B%E8%AF%95，utf-8格式转码。接收到需URLDecoder
	private String ad_name;
	// 状态 1为正常激活
	private String status;
	// 激活时间 用户产生激活行为时间，需解码，例 ：2014-04-25+17%3A27%3A48.0
	private String activate_time;
	// 订单号 由此字段判断接收数据是否唯一，如：4E6A4EE6B8735C3AF944DC88A97A941B
	private String order_id;
	// 随机串 此字段参与加密操作，值如：05141441400146701119
	private String random_code;

	/**
	 * 验证密钥(老) 密钥串，md5(random_code + order_id)
	 * 值如：58075BF0BEE3E8F557C7804D678F51FD 可以废弃此加密方式
	 */
	private String secret_key;

	/**
	 * 验证密钥结果值(新) 新增的验证密钥，此功能需在配置回调地址时同步添加一个密钥串。密钥加密方式：
	 * Md5(${adv_id}${app_id}${key
	 * }${udid}${bill}${points}${activate_time}${order_id}${回调密钥})
	 * 回调密钥不会被传递，需要在服务端添加，或联系客服进行配置。
	 * 注：1.接收到的activate_time数据如果是解码后，那么在加密数据里需先进行URLEncoder转码并大写
	 * 2.万普方发送的wapskey的值是大写字符串，开发者接收到数据后需进行对应处理
	 */
	private String wapskey;

	public ActiveWanpu() {

	}

	public ActiveWanpu(String adv_id, String app_id, String key, String udid,
			String open_udid, String bill, String points, String ad_name,
			String status, String activate_time, String order_id,
			String random_code, String secret_key, String wapskey) {
		this.adv_id = adv_id;
		this.app_id = app_id;
		this.key = key;
		this.udid = udid;
		this.open_udid = open_udid;
		this.bill = bill;
		this.points = points;
		this.ad_name = ad_name;
		this.status = status;
		this.activate_time = activate_time;
		this.order_id = order_id;
		this.random_code = random_code;
		this.secret_key = secret_key;
		this.wapskey = wapskey;
	}

	public String getAdv_id() {
		return adv_id;
	}

	public void setAdv_id(String adv_id) {
		this.adv_id = adv_id;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getOpen_udid() {
		return open_udid;
	}

	public void setOpen_udid(String open_udid) {
		this.open_udid = open_udid;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActivate_time() {
		return activate_time;
	}

	public void setActivate_time(String activate_time) {
		this.activate_time = activate_time;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getRandom_code() {
		return random_code;
	}

	public void setRandom_code(String random_code) {
		this.random_code = random_code;
	}

	public String getSecret_key() {
		return secret_key;
	}

	public void setSecret_key(String secret_key) {
		this.secret_key = secret_key;
	}

	public String getWapskey() {
		return wapskey;
	}

	public void setWapskey(String wapskey) {
		this.wapskey = wapskey;
	}

	private static final String KEY_WANPU = "AM23E7UX2312B6QZ3MP3";
	public boolean verifySign(){
		String time = null;
		try {
			time = URLEncoder.encode(activate_time, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		String plaintext = adv_id+app_id+key+udid+bill+points+time+order_id+KEY_WANPU;
		String sign = MD5(plaintext);
		return sign.equalsIgnoreCase(wapskey);
	}
	
	private String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
