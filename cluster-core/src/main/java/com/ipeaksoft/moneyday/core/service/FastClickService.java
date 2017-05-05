package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserTaskFastClick;
import com.ipeaksoft.moneyday.core.mapper.UserTaskFastClickMapper;

@Service
public class FastClickService extends BaseService {
    @Autowired
    private UserTaskFastClickMapper fastClickMapper;
    
    public UserTaskFastClick create(UserTaskFastClick record){
    	fastClickMapper.insert(record);
    	return record;
    }
    
    public int updateBySelective(UserTaskFastClick record){
        return fastClickMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteById(Long id) {
        return fastClickMapper.deleteByPrimaryKey(id);
    }

    public UserTaskFastClick getOneByIdfa(String idfa, String appid) {
        return fastClickMapper.selectByIdfa(idfa, appid);
    }

    public UserTaskFastClick findById(Long id) {
        return fastClickMapper.selectByPrimaryKey(id);
    }
    
//    public UserTaskFastClick findByTaskId(String mobile, Long taskId, Integer clientType) {
//        return fastClickMapper.selectByMobileAndTaskId(mobile, taskId, clientType);
//    }

    public UserTaskFastClick findByTaskId(String mobile, Long taskId) {
        return fastClickMapper.selectByMobileAndTaskId(mobile, taskId);
    }

    public UserTaskFastClick findByAppid(String mobile, String appid, Integer clientType) {
        return fastClickMapper.selectByMobileAndAppid(mobile, appid, clientType);
    }

    public UserTaskFastClick findChannelByTaskId(String idfa, Long taskId) {
        return fastClickMapper.selectByIdfaAndTaskId(idfa, taskId);
    }
    
}
