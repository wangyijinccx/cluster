package com.ipeaksoft.moneyday.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserCashApprove;
import com.ipeaksoft.moneyday.core.mapper.UserCashApproveMapper;

@Service
public class UserCashApproveService extends BaseService {
    
    @Autowired
    private UserCashApproveMapper userCashApproveMapper;
    
    public int deleteByPrimaryKey(Long id){
    	return userCashApproveMapper.deleteByPrimaryKey(id);
    }

    public int addUser(UserCashApprove record){
    	return userCashApproveMapper.insert(record);
    }

    public int insertSelective(UserCashApprove record){
    	return userCashApproveMapper.insertSelective(record);
    }

    public UserCashApprove getUserById(Long id){
    	return userCashApproveMapper.selectByPrimaryKey(id);
    }

    public int updateUser(UserCashApprove record){
    	return userCashApproveMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserCashApprove record){
    	return userCashApproveMapper.updateByPrimaryKey(record);
    }

    public int countPageByOrder(Map<String, Object> map) {
        return userCashApproveMapper.countPageByOrder(map);
    }

    public List<UserCashApprove> getPageByOrder(Map<String, Object> map) {
        return userCashApproveMapper.selectPageByOrder(map);
    }

    
}