package com.ipeaksoft.moneyday.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserLoginHistory;
import com.ipeaksoft.moneyday.core.mapper.UserLoginHistoryMapper;

@Service
public class UserLoginHistoryService extends BaseService {
	
	@Autowired
	private UserLoginHistoryMapper userLoginHistoryMapper;

	public Integer addUserLoginHistory(UserLoginHistory userLoginHistory) {
		
		userLoginHistoryMapper.insertSelective(userLoginHistory);
		return userLoginHistory.getId();
	}
	
	/**
     * 分页获取用户登陆纪录
     * @param map
     * @return
     */
	@SuppressWarnings("rawtypes")
	public List<UserLoginHistory> pageUserLoginHistory(Map map) {
		
		return userLoginHistoryMapper.pageUserLoginHistory(map);
	}
	
	/**
     * 统计用户登陆纪录总数
     * @param map
     * @return
     */
    public int userLoginHistoryAmount(Map<String,Object>map) {
    	
    	return userLoginHistoryMapper.userLoginHistoryAmount(map);
    }

    public UserLoginHistory getByUserid(Integer userid) {
        return userLoginHistoryMapper.selectByUserid(userid);
    }

}
