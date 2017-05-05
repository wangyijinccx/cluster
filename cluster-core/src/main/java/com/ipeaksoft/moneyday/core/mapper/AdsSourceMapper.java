package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;

import com.ipeaksoft.moneyday.core.entity.AdsSource;

public interface AdsSourceMapper {
    AdsSource selectByPrimaryKey(Integer id);
    AdsSource selectByKey(String key);
    List<AdsSource> selectAll();
    List<AdsSource> selectByModifyTime(String modifyTime);
    int updateByPrimaryKeySelective(AdsSource adsSource);
    int insert(AdsSource adsSource);
}