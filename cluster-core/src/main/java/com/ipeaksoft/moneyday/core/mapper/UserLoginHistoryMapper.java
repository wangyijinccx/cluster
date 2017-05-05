package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserLoginHistory;

public interface UserLoginHistoryMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserLoginHistory record);

	int insertSelective(UserLoginHistory record);

	UserLoginHistory selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserLoginHistory record);

	int updateByPrimaryKey(UserLoginHistory record);
	
	/**
     * 分页获取用户登陆纪录
     * @param map
     * @return
     */
	@SuppressWarnings("rawtypes")
	List<UserLoginHistory> pageUserLoginHistory(Map map);
	
	/**
     * 统计用户登陆纪录总数
     * @param map
     * @return
     */
    int userLoginHistoryAmount(Map<String,Object>map);

    UserLoginHistory selectByUserid(Integer userid);
}