package com.ipeaksoft.moneyday.core.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.StatCash;

public interface StatCashMapper {
    int deleteByPrimaryKey(Date day);

    int insert(StatCash record);

    int insertSelective(StatCash record);

    List<StatCash> selectPageByDay(Map<String, Object> map);
    
    StatCash selectByPrimaryKey(Date day);

    int updateByPrimaryKeySelective(StatCash record);

    int updateByPrimaryKey(StatCash record);

    int getAllMoney();
    
    Integer getAllCash();

    int countAllByWhere(Map<String, Object> map);
}