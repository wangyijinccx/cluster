package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.AdsTashActive;

public interface AdsTashActiveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdsTashActive record);

    int insertSelective(AdsTashActive record);

    AdsTashActive selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdsTashActive record);

    int updateByPrimaryKey(AdsTashActive record);
}