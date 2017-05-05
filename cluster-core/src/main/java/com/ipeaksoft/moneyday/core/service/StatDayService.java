package com.ipeaksoft.moneyday.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.StatDay;
import com.ipeaksoft.moneyday.core.mapper.StatDayMapper;
@Service
public class StatDayService extends BaseService{
	@Autowired
	private StatDayMapper statDayMapper;

	 /**
     * 分页查询任务按天统计
     * @param map
     * @return
     */
    public List<StatDay> findPageList(Map<String,Object> map){
    	return statDayMapper.findPageList(map);
    }
    
    /**
     * 统计分页查询所有记录数
     * @param map
     * @return
     */
   public int findPageListCount(Map<String,Object> map){
    	return statDayMapper.findPageListCount(map);
    }
   
   /**
    * 获取总收益
    * @param taskType
    * @return
    */
   public int findAllEarnings(int taskType){
	   return statDayMapper.findAllEarnings(taskType);
   }

  
}
