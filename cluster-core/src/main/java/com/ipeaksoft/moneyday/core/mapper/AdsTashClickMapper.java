package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.AdsTashClick;

public interface AdsTashClickMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdsTashClick record);

    int insertSelective(AdsTashClick record);

    AdsTashClick selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdsTashClick record);

    int updateByPrimaryKey(AdsTashClick record);
}