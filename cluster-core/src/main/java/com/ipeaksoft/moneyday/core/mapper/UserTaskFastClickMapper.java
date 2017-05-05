package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.UserTaskFastClick;

public interface UserTaskFastClickMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserTaskFastClick record);

    int insertSelective(UserTaskFastClick record);

    UserTaskFastClick selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTaskFastClick record);

    int updateByPrimaryKey(UserTaskFastClick record);

    UserTaskFastClick selectByMobileAndAppid(Map<String, Object> paramsMap);

    UserTaskFastClick selectByIdfa(@Param(value= "idfa")String idfa, @Param(value="appid")String appid);

    UserTaskFastClick selectByMobileAndTaskId(@Param(value= "mobile")String mobile, @Param(value="taskId")Long taskId);

    UserTaskFastClick selectByMobileAndAppid(@Param(value= "mobile")String mobile, @Param(value="appid")String appid,  @Param(value="clientType")Integer clientType);

    UserTaskFastClick selectByIdfaAndTaskId(@Param(value= "idfa")String idfa, @Param(value="taskId")Long taskId);
    
	List<UserTaskFastClick> selectNoLocation();

    int updateLocationByPrimaryKey(UserTaskFastClick record);
}