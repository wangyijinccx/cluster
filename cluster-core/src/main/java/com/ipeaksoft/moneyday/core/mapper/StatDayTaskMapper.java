package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.StatDayTask;

public interface StatDayTaskMapper {
	int deleteByPrimaryKey(Long id);

	int insert(StatDayTask record);

	int insertSelective(StatDayTask record);

	StatDayTask selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(StatDayTask record);

	int updateByPrimaryKey(StatDayTask record);

	/**
	 * 分页查询某天任务统计列表
	 * 
	 * @param map
	 * @return
	 */
	List<StatDayTask> findPageList(Map<String, Object> map);
    /**
     * 分页查询某天任务统计列表 总条数
     * @param map
     * @return
     */
	int findPageListCount(Map<String, Object> map);
}