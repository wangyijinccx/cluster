package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.TaskAds;

public interface TaskAdsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskAds record);

    int insertSelective(TaskAds record);
    
    TaskAds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskAds record);

    int updateByPrimaryKey(TaskAds record);
    
    List<TaskAds> listAll();
    
    List<TaskAds>selectByWhere(Map<String,Object> map);
    
    int selectByWhereCount(Map<String,Object> map);
}