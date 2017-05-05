package com.ipeaksoft.moneyday.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.User;
import com.ipeaksoft.moneyday.core.entity.UserTaskFast;
import com.ipeaksoft.moneyday.core.mapper.UserMapper;
import com.ipeaksoft.moneyday.core.mapper.UserTaskFastMapper;

@Service
public class UserFastService extends BaseService {
    @Autowired
    private UserTaskFastMapper userTaskFastMapper;
    @Autowired
    private UserMapper userMapper;
    
    public Integer getAwardByMobile(Map<String, Object> map) {
        return userTaskFastMapper.selectAwardByMobile(map);
    }
    
    public UserTaskFast create(UserTaskFast record){
    	User user = userMapper.selectByMobile(record.getMobile());
    	if (null != user && "C".equalsIgnoreCase(user.getType())){
    		record.setAward((int)(record.getAward()*1.1));
    	}
    	userTaskFastMapper.insert(record);
    	return record;
    }
    
    public UserTaskFast update(UserTaskFast record){
    	userTaskFastMapper.updateByPrimaryKeySelective(record);
    	return record;
    }

}
