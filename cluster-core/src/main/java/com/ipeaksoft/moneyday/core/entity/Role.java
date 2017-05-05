package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Role {
    private Integer id;

    private String name;

    private Date createTime;

    private Date modifyTime;
	private Set<Authority> roleAuthorities = new HashSet<Authority>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
	public Set<Authority> getRoleAuthorities() {
		return roleAuthorities;
	}

	public void setRoleAuthorities(Set<Authority> roleAuthorities) {
		this.roleAuthorities = roleAuthorities;
	}


}