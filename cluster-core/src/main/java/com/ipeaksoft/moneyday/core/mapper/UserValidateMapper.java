package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.UserValidate;

public interface UserValidateMapper {
	int deleteByPrimaryKey(Long id);

	int insert(UserValidate record);

	int insertSelective(UserValidate record);

	UserValidate selectByPrimaryKey(Long id);

	UserValidate selectByMobile(String mobile);

	UserValidate selectByMobileAndTaskId(@Param(value = "mobile") String mobile,
			@Param(value = "taskId") String taskId);

	List<UserValidate> selectNeedCheckFor345();
	
	List<UserValidate> selectNeedCheckFor640();

	int updateByPrimaryKeySelective(UserValidate record);

	int updateByPrimaryKey(UserValidate record);

	int selectCountByAppid(String appid);

	@SuppressWarnings("rawtypes")
	List<UserValidate> selectUserValidateByDate(Map map);

	int deleteByMobileAndTaskId(@Param(value = "mobile") String mobile,
			@Param(value = "taskId") String taskId);
	
	/**
     * 分页获取vip账号检测记录
     * @param map
     * @return
     */
    @SuppressWarnings("rawtypes")
	List<UserValidate> pageUserValidateLog(Map map);
    
    /**
     * 统计vip账号检测次数
     * @param map
     * @return
     */
    int userValidateAmount(Map<String,Object>map);
}