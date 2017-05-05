package com.ipeaksoft.moneyday.core.dto;

import java.util.Date;

/**
 * 通用的字典表
 * @author sxy
 * 2015年5月28日 下午4:02:21
 * 
 */
public class Dictionary extends BaseObject {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String key;
    private String value;
    private String description;
    private Integer type;
    private Date createTime;
    
    public Dictionary() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
  
    
    
}
