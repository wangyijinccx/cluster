package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.ClusterGame;

public interface ClusterGameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClusterGame record);

    int insertSelective(ClusterGame record);

    ClusterGame selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClusterGame record);

    int updateByPrimaryKey(ClusterGame record);
    
    List<Map<String, Object>> selectListGame(
			@Param(value = "currentPage") Integer start,
			@Param(value = "pageSize") Integer length);
    
    int selectNum();
    
    List<ClusterGame>  selectAll();
}