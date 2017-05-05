package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.VisitorHistory;

public interface VisitorHistoryMapper {
    int deleteByPrimaryKey(String idfa);

    int insert(VisitorHistory record);

    int insertSelective(VisitorHistory record);

    VisitorHistory selectByPrimaryKey(String idfa);

    int updateByPrimaryKeySelective(VisitorHistory record);

    int updateByPrimaryKey(VisitorHistory record);
}