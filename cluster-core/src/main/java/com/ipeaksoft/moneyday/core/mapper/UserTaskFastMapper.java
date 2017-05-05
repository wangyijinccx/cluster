package com.ipeaksoft.moneyday.core.mapper;

import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserTaskFast;

public interface UserTaskFastMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserTaskFast record);

    int insertSelective(UserTaskFast record);

    UserTaskFast selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTaskFast record);

    int updateByPrimaryKey(UserTaskFast record);
    
    Integer selectAwardByMobile(Map<String, Object> map);
}