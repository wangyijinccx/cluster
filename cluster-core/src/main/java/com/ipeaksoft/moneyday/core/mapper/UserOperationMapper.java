package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.UserOperation;

public interface UserOperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserOperation record);

    int insertSelective(UserOperation record);

    UserOperation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserOperation record);

    int updateByPrimaryKey(UserOperation record);
}