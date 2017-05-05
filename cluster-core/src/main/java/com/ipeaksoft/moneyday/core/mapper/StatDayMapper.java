package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.StatDay;

public interface StatDayMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatDay record);

    int insertSelective(StatDay record);

    StatDay selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StatDay record);

    int updateByPrimaryKey(StatDay record);
    
    /**
     * 分页查询任务按天统计
     * @param map
     * @return
     */
    List<StatDay> findPageList(Map<String,Object> map);
    
    /**
     * 统计分页查询所有记录数
     * @param map
     * @return
     */
    int findPageListCount(Map<String,Object> map);
    
    /**
     * 获取总收益
     * @param map
     * @return
     */
    int findAllEarnings(int taskType);
}