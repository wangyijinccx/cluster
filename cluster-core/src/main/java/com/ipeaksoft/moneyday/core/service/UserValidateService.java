package com.ipeaksoft.moneyday.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserValidate;
import com.ipeaksoft.moneyday.core.mapper.UserValidateMapper;

@Service
public class UserValidateService {
    @Autowired
    private UserValidateMapper userValidateMapper;

    public int insert(UserValidate record){
    	return userValidateMapper.insert(record);
    }

    public UserValidate selectByPrimaryKey(Long id){
    	return userValidateMapper.selectByPrimaryKey(id);
    }
    
    public UserValidate selectByMobile(String mobile){
    	return userValidateMapper.selectByMobile(mobile);
    }

    public UserValidate selectByMobileAndTaskId(String mobile, String taskId){
    	return userValidateMapper.selectByMobileAndTaskId(mobile, taskId);
    }

    public List<UserValidate> selectNeedCheckFor345(){
    	return userValidateMapper.selectNeedCheckFor345();
    }
    
    public List<UserValidate> selectNeedCheckFor640(){
    	return userValidateMapper.selectNeedCheckFor640();
    }

    public int selectCountByAppid(String appid){
    	return userValidateMapper.selectCountByAppid(appid);
    }
    
    public int updateByPrimaryKeySelective(UserValidate record){
    	return userValidateMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Long id){
    	return userValidateMapper.deleteByPrimaryKey(id);
    }
    
    public int deleteByMobileAndTaskId(String mobile, String taskId){
    	return userValidateMapper.deleteByMobileAndTaskId(mobile, taskId);
    }
    
    /**
	 * 分页获取vip账号检测记录
	 * @param where
	 * @return
	 */
	public List<UserValidate> pageUserValidateLog(Map<String, Object> where) {

		return userValidateMapper.pageUserValidateLog(where);
	}
	
	/**
	 * 统计vip账号检测次数
	 * @param map
	 * @return
	 */
	public int userValidateAmount(Map<String, Object> map) {
		return userValidateMapper.userValidateAmount(map);
	}
    
}
