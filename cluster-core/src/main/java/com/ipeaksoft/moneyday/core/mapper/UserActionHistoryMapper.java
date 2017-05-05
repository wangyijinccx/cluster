package com.ipeaksoft.moneyday.core.mapper;

import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserActionHistory;

public interface UserActionHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserActionHistory record);

    int insertSelective(UserActionHistory record);

    UserActionHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserActionHistory record);

    int updateByPrimaryKey(UserActionHistory record);
    
    UserActionHistory selectByLastDay(Map map);
}