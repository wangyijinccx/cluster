package com.ipeaksoft.moneyday.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipeaksoft.moneyday.core.entity.StatDayTask;
import com.ipeaksoft.moneyday.core.mapper.StatDayTaskMapper;
@Service
public class StatDayTaskService extends BaseService {
	@Autowired
	private StatDayTaskMapper statDayTaskMapper;
	/**
     * 分页查询某天任务统计列表
     * @param map
     * @return
     */
	
    public List<StatDayTask>findPageList(Map<String,Object>map){
    	return statDayTaskMapper.findPageList(map);
    }
    /**
     * 分页查询某天任务统计列表总条数
     * @param map
     * @return
     */
    public int findPageListCount(Map<String, Object> map){
    	return statDayTaskMapper.findPageListCount(map);
    }
}
