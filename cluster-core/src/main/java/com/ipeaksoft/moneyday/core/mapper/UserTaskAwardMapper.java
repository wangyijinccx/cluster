package com.ipeaksoft.moneyday.core.mapper;

import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserTaskAward;

public interface UserTaskAwardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserTaskAward record);

    int insertSelective(UserTaskAward record);

    UserTaskAward selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTaskAward record);

    int updateByPrimaryKey(UserTaskAward record);
    
    Integer getReceivedAward(Map<String,Object> map);
    
    Integer getReceivedAwardCount(Map<String,Object> map);
}