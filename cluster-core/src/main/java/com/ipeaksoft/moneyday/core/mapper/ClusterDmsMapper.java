package com.ipeaksoft.moneyday.core.mapper;


import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.ClusterDms;

public interface ClusterDmsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ClusterDms record);

	int insertSelective(ClusterDms record);

	ClusterDms selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ClusterDms record);

	int updateByPrimaryKey(ClusterDms record);

	ClusterDms checkDms(@Param("name") String name, @Param("url") String url);
}