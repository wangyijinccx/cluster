package com.ipeaksoft.moneyday.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipeaksoft.moneyday.core.entity.UserLoginException;
import com.ipeaksoft.moneyday.core.mapper.UserLoginExceptionMapper;

public class UserLoginExceptionService extends BaseService {
	@Autowired
	private UserLoginExceptionMapper userLoginExceptionMapper;

	/**
	 * 获取未处理的异常记录
	 * @param start 起始索引
	 * @param limit 每页条数
	 * @return
	 */
	public List<UserLoginException> findPage(String start,String limit) {
		Map<String, Object> map =new HashMap<String,Object>();
		map.put("currentPage", start);
		map.put("pageSize", limit);
		return userLoginExceptionMapper.findPage(map);
	}
	
	/**
	 * 获取未处理异常总条数
	 * @return
	 */
	public int findPageCount(){
		return userLoginExceptionMapper.findPageCount();
	}

}
