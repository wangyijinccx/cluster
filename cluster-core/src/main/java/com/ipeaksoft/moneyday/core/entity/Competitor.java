package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

// 竞品信息相关的实体类
/**
 * @author sxy
 * 2015年3月23日 下午2:45:37
 * 
 */
public class Competitor {

    private Integer id;
    private String appname;
    private String urlscheme;
    private Date createTime;
    private Date modifyTime;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAppname() {
        return appname;
    }
    public void setAppname(String appname) {
        this.appname = appname;
    }
    public String getUrlscheme() {
        return urlscheme;
    }
    public void setUrlscheme(String urlscheme) {
        this.urlscheme = urlscheme;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
   
    
    
}
