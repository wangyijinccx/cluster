package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AdminUser {
    private Integer id;

    private String username;

    private String password;

    private String companyName;

    private String linkman;

    private String phone;

    private String comment;

    private Integer isValid;

    private Date createTime;

    private Date modifyTime;

    private Integer pid;

    private Byte level;
	private Set<Role> userRoles = new HashSet<Role>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }
    
	public Set<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

}