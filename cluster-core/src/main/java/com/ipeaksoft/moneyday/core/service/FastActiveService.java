package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserTaskFastActive;
import com.ipeaksoft.moneyday.core.mapper.UserTaskFastActiveMapper;

@Service
public class FastActiveService extends BaseService {
    @Autowired
    private UserTaskFastActiveMapper fastActiveMapper;
    
    public UserTaskFastActive create(UserTaskFastActive record){
    	fastActiveMapper.insert(record);
    	return record;
    }

    public UserTaskFastActive findByTaskId(String mobile, Long taskId, Integer clientType) {
        return fastActiveMapper.selectByMobileAndTaskId(mobile, taskId, clientType);
    }
    
    public UserTaskFastActive findByIdfa(String idfa, Long taskId, Integer clientType) {
        return fastActiveMapper.selectByIdfaAndTaskId(idfa, taskId, clientType);
    }

    public UserTaskFastActive findByAppid(String mobile, String appid, Integer clientType) {
        return fastActiveMapper.selectByMobileAndAppid(mobile, appid, clientType);
    }

}
