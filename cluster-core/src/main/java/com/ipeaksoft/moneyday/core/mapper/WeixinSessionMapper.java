package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.WeixinSession;

public interface WeixinSessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(WeixinSession record);

    int insertSelective(WeixinSession record);

    WeixinSession selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WeixinSession record);

    int updateByPrimaryKey(WeixinSession record);
}