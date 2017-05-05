package com.ipeaksoft.moneyday.core.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.StatRecharged;

public interface StatRechargedMapper {
    int deleteByPrimaryKey(Date day);

    int insert(StatRecharged record);

    int insertSelective(StatRecharged record);

    List<StatRecharged> selectPageByDay(Map<String, Object> map);
    
    StatRecharged selectByPrimaryKey(Date day);

    int updateByPrimaryKeySelective(StatRecharged record);

    int updateByPrimaryKey(StatRecharged record);

    int countAllByWhere(Map<String, Object> map);
}