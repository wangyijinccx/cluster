package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.StatDayTaskAds;

public interface StatDayTaskAdsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatDayTaskAds record);

    int insertSelective(StatDayTaskAds record);

    StatDayTaskAds selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StatDayTaskAds record);

    int updateByPrimaryKey(StatDayTaskAds record);
}