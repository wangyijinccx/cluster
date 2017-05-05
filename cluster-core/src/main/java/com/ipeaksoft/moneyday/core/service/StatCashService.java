package com.ipeaksoft.moneyday.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.StatCash;
import com.ipeaksoft.moneyday.core.mapper.StatCashMapper;

@Service
public class StatCashService extends BaseService {
    
    @Autowired
    private StatCashMapper statCashMapper;
    
    public int addUser(StatCash record){
    	return statCashMapper.insert(record);
    }

    public int insertSelective(StatCash record){
    	return statCashMapper.insertSelective(record);
    }

    public StatCash getStatByDay(Date day){
    	return statCashMapper.selectByPrimaryKey(day);
    }
    
    public List<StatCash> getPageByDay(Map<String, Object> map){
        return statCashMapper.selectPageByDay(map);
    }

    public int updateUser(StatCash record){
    	return statCashMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StatCash record){
    	return statCashMapper.updateByPrimaryKey(record);
    }

    public int getAllMoney() {  // 获取所有订单的累积兑换金额，不区分订单的状态
        return statCashMapper.getAllMoney();
    }

    public int countAllByWhere(Map<String, Object> map) {
        return statCashMapper.countAllByWhere(map);        
    }
}