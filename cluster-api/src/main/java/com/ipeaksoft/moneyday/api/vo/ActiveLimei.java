package com.ipeaksoft.moneyday.api.vo;

/**
 * 力美激活对象
 * aduid=aduid_limei&uid=uid_limei&aid=aid_limei&point=150&sign=abcd&source=abc&timestamp=119988&idfa=abcd-bcde-defg-efgh&orderID=1234567890&title=测试app&cid=aa
 * @author Administrator
 *
 */
public class ActiveLimei extends ActiveBase {
	private static final long serialVersionUID = 1L;
	// 媒体广告位ID
	private String aduid;
	// mac地址
	private String uid;
	// 媒体类型如果为多用户类型,如网游媒体。需要传用户的账号
	private String aid;
	// 返还给用户的金币数
	private String point;
	// 签名信息
	private String sign;
	//
	private String source;
	// 当前产生的时间戳
	private String timestamp;
	// 广告标识符
	private String idfa;
	// 力美积分商城订单 id
	private String orderID;
	// 广告名称
	private String title;
	// 用户完成任务时存在
	private String cid;

	public ActiveLimei() {
	}

	public ActiveLimei(String aduid, String uid, String aid, String point,
			String sign, String source, String timestamp, String idfa,
			String orderID, String title, String cid) {
		this.aduid = aduid;
		this.uid = uid;
		this.aid = aid;
		this.point = point;
		this.sign = sign;
		this.source = source;
		this.timestamp = timestamp;
		this.idfa = idfa;
		this.orderID = orderID;
		this.title = title;
		this.cid = cid;
	}

	public String getAduid() {
		return aduid;
	}

	public void setAduid(String aduid) {
		this.aduid = aduid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
