package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.AdsRequest;

public interface AdsRequestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdsRequest record);

    int insertSelective(AdsRequest record);

    AdsRequest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdsRequest record);

    int updateByPrimaryKey(AdsRequest record);
}