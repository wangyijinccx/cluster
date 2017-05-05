package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.Role;
import com.ipeaksoft.moneyday.core.mapper.RoleMapper;

@Service
public class RoleService extends BaseService {
    @Autowired
    private RoleMapper roleMapper;

	/**
	 * 根据ID获取一个角色
	 * @param id
	 * @return
	 */
	public Role getRoleById(int id){
		return roleMapper.selectByPrimaryKey(id);
	}

}
