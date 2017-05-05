package com.ipeaksoft.moneyday.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.StatRecharged;
import com.ipeaksoft.moneyday.core.mapper.StatRechargedMapper;

@Service
public class StatRechargedService extends BaseService {
    
    @Autowired
    private StatRechargedMapper statRechargedMapper;
    
    public int addOne(StatRecharged record){
    	return statRechargedMapper.insert(record);
    }

    public int insertSelective(StatRecharged record){
    	return statRechargedMapper.insertSelective(record);
    }

    public StatRecharged getStatByDay(Date day){
    	return statRechargedMapper.selectByPrimaryKey(day);
    }
    
    public List<StatRecharged> getPageByDay(Map<String, Object> map){
        return statRechargedMapper.selectPageByDay(map);
    }

    public int updateOne(StatRecharged record){
    	return statRechargedMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StatRecharged record){
    	return statRechargedMapper.updateByPrimaryKey(record);
    }

    public int countAllByWhere(Map<String, Object> map) {
        return statRechargedMapper.countAllByWhere(map);
    }
}