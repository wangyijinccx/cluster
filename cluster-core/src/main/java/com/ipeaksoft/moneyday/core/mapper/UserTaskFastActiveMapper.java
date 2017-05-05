package com.ipeaksoft.moneyday.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.UserTaskFastActive;

public interface UserTaskFastActiveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserTaskFastActive record);

    int insertSelective(UserTaskFastActive record);

    UserTaskFastActive selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTaskFastActive record);

    int updateByPrimaryKey(UserTaskFastActive record);


    UserTaskFastActive selectByMobileAndTaskId(@Param(value= "mobile")String mobile, @Param(value="taskId")Long taskId,  @Param(value="clientType")Integer clientType);

    UserTaskFastActive selectByMobileAndAppid(@Param(value= "mobile")String mobile, @Param(value="appid")String appid,  @Param(value="clientType")Integer clientType);

    UserTaskFastActive selectByIdfaAndTaskId(@Param(value= "idfa")String idfa, @Param(value="taskId")Long taskId,  @Param(value="clientType")Integer clientType);
}