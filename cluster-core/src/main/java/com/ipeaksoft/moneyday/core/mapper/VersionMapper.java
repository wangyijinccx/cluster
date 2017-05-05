package com.ipeaksoft.moneyday.core.mapper;

import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.Version;

public interface VersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Version record);

    int insertSelective(Version record);

    Version selectByPrimaryKey(Integer id);
    
    Version selectByOs(String os);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);

    Version selectByVersion(Version record);
}