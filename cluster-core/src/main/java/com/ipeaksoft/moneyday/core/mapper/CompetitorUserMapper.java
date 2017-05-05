package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.CompetitorUser;

public interface CompetitorUserMapper {

    int insert(CompetitorUser record);
    
    int insertSelective(CompetitorUser record);

    int updateByPrimaryKeySelective(CompetitorUser record);

    int updateByPrimaryKey(CompetitorUser record);

}
