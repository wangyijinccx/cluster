package com.ipeaksoft.moneyday.api.vo;

public class AdLangyi extends BaseObject {
    private static final long serialVersionUID = 1L;
    
    private String adid;
    private String ad;
    private String app_store_url;
    private String price;
    private String task_source;
    private Long itunesid;
	private String icon;
	private int prize;
	//每天的激活总数
	private int dailyCap;
	
	private String description;
	
	private String keyWord;
    
    public int getDailyCap() {
		return dailyCap;
	}

	public void setDailyCap(int dailyCap) {
		this.dailyCap = dailyCap;
	}

	public AdLangyi() {
        super();
    }
    
    public String getTask_source() {
		return task_source;
	}

	public void setTask_source(String task_source) {
		this.task_source = task_source;
	}

	public String getAdid() {
        return adid;
    }
    public void setAdid(String adid) {
        this.adid = adid;
    }
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public String getApp_store_url() {
        return app_store_url;
    }
    public void setApp_store_url(String app_store_url) {
        this.app_store_url = app_store_url;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Long getItunesid() {
        return itunesid;
    }
    public void setItunesid(Long itunesid) {
        this.itunesid = itunesid;
    }
    public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
     
}
