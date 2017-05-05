package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.UserTaskAdsActive;

public interface UserTaskAdsActiveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserTaskAdsActive record);

    int insertSelective(UserTaskAdsActive record);

    UserTaskAdsActive selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTaskAdsActive record);

    int updateByPrimaryKey(UserTaskAdsActive record);
}