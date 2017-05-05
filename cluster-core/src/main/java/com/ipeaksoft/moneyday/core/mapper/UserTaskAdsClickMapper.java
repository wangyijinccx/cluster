package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.UserTaskAdsClick;

public interface UserTaskAdsClickMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserTaskAdsClick record);

    int insertSelective(UserTaskAdsClick record);

    UserTaskAdsClick selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTaskAdsClick record);

    int updateByPrimaryKey(UserTaskAdsClick record);
}