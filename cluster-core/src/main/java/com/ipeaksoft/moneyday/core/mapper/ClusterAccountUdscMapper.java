package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.ClusterAccountUdsc;

public interface ClusterAccountUdscMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClusterAccountUdsc record);

    int insertSelective(ClusterAccountUdsc record);

    ClusterAccountUdsc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClusterAccountUdsc record);

    int updateByPrimaryKey(ClusterAccountUdsc record);
    
    List<ClusterAccountUdsc> selectByTaskId(@Param(value = "taskid")Integer taskid);
    
    Map<String, Object> selectByUdid(@Param(value = "udid")String udid);
}