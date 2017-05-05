package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.StatMember;

public interface StatMemberMapper {
	
	/**
	 * 分页查询程序员任务收益统计
	 * @param where
	 * @return
	 */
	List<StatMember>findPageList(Map<String,Object> where);
	
	/**
	 * 分页查询程序员任务收益统计总记录数
	 * @param where
	 * @return
	 */
	int findPageListCount(Map<String,Object>where);
}