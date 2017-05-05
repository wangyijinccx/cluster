package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.Device;

public interface DeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
    
    Device selectByIdfa(String idfa);
}