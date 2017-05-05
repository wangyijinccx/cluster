package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.Competitor;

public interface CompetitorMapper {

    int insert(Competitor record);

    int insertSelective(Competitor record);

    int updateByPrimaryKeySelective(Competitor record);

    int updateByPrimaryKey(Competitor record);

    Competitor selectByPrimaryKey(Integer id);

    List<Competitor> selectAll();

    List<Competitor> selectByMobile(String mobile);

    Integer countByMobileAndId(@Param(value = "mobile") String mobile, @Param(value = "competitorid") String competitorid);
}
