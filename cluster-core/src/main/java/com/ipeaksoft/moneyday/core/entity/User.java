package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class User {
	
	private Long id;
	private Long userid;
	private String username;
	private String passwd;
	private String fromto;
	private String type;
	private Date createTime;
	private String idfa;
	private String pUser;
	private String name;
	private String mobile;
	private String appleAccount;
	private String address;
	private Integer award;
	private String idCard;
	private Integer exceptionnum;
	private Integer taskfast;
	private Integer taskads;
	private String nickname;// 微信用户的昵称
	private String headimgurl;// 微信用户的头像
	private Integer competitorNum;// 竞品数量
	private String clientType;
	private Date typeTime;
	private String nation;
	private String province;
	private String city;
	private String area;
	private String isValid;
	private Integer status;//
	private String ip;// 新增
	private String provinceName;
	private String exceptionlevel;
	private String cityName;
	private String areaName;
	private String inviteCode;
	private Integer weightFlag; // 权重标记，0未下载 1已下载未审核 2已测试，有变化 3 无权重
	private Integer weightCount; // 完成奖励任务次数
	private String puser1; // 1级推广员
	private String puser2; // 2级推广员
	private String puser3; // 3级推广员
	private Date lastDownloadTime; // 最后一次奖励任务下载时间
	
	public Date getLastDownloadTime() {
        return lastDownloadTime;
    }

    public void setLastDownloadTime(Date lastDownloadTime) {
        this.lastDownloadTime = lastDownloadTime;
    }

    public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getCompetitorNum() {
        return competitorNum;
    }

    public void setCompetitorNum(Integer competitorNum) {
        this.competitorNum = competitorNum;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Integer getTaskfast() {
		return taskfast;
	}

	public void setTaskfast(Integer taskfast) {
		this.taskfast = taskfast;
	}

	public Integer getTaskads() {
		return taskads;
	}

	public void setTaskads(Integer taskads) {
		this.taskads = taskads;
	}

	public Integer getExceptionnum() {
		return exceptionnum;
	}

	public void setExceptionnum(Integer exceptionnum) {
		this.exceptionnum = exceptionnum;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getExceptionlevel() {
		return exceptionlevel;
	}

	public void setExceptionlevel(String exceptionlevel) {
		this.exceptionlevel = exceptionlevel;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getFromto() {
		return fromto;
	}

	public void setFromto(String fromto) {
		this.fromto = fromto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getpUser() {
		return pUser;
	}

	public void setpUser(String pUser) {
		this.pUser = pUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAppleAccount() {
		return appleAccount;
	}

	public void setAppleAccount(String appleAccount) {
		this.appleAccount = appleAccount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAward() {
		return award;
	}

	public void setAward(Integer award) {
		this.award = award;
	}

	public Date getTypeTime() {
		return typeTime;
	}

	public void setTypeTime(Date typeTime) {
		this.typeTime = typeTime;
	}

	public Integer getWeightFlag() {
		return weightFlag;
	}

	public void setWeightFlag(Integer weightFlag) {
		this.weightFlag = weightFlag;
	}

	public Integer getWeightCount() {
		return weightCount;
	}

	public void setWeightCount(Integer weightCount) {
		this.weightCount = weightCount;
	}

	public String getPuser1() {
		return puser1;
	}

	public void setPuser1(String puser1) {
		this.puser1 = puser1;
	}

	public String getPuser2() {
		return puser2;
	}

	public void setPuser2(String puser2) {
		this.puser2 = puser2;
	}

	public String getPuser3() {
		return puser3;
	}

	public void setPuser3(String puser3) {
		this.puser3 = puser3;
	}
	
}