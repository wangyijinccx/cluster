package com.ipeaksoft.moneyday.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.TaskAds;
import com.ipeaksoft.moneyday.core.mapper.TaskAdsMapper;

@Service
public class TaskAdsService extends BaseService {
    @Autowired
    private TaskAdsMapper taskAdsMapper;
    
    public int create(TaskAds record){
    	return taskAdsMapper.insert(record);
    }
    
    public int updateByPrimaryKey(TaskAds record){
    	return taskAdsMapper.updateByPrimaryKey(record);
    }
    
    public List<TaskAds> listAll(){
    	return taskAdsMapper.listAll();
    }
    
    public List<TaskAds>selectByWhere(Map<String,Object> map){
    	return taskAdsMapper.selectByWhere(map);
    }
    
    public int selectByWhereCount(Map<String,Object> map){
    	return taskAdsMapper.selectByWhereCount(map);
    }
    
    public TaskAds selectByPrimaryKey(int id){
    	return taskAdsMapper.selectByPrimaryKey(id);
    }
    
}
