package com.ipeaksoft.moneyday.core.mapper;

import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserTaskAds;

public interface UserTaskAdsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserTaskAds record);

    int insertSelective(UserTaskAds record);

    UserTaskAds selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTaskAds record);

    int updateByPrimaryKey(UserTaskAds record);

    Integer selectAwardByMobile(Map<String, Object> map);
}