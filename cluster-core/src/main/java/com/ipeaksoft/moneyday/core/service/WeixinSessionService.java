package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.WeixinSession;
import com.ipeaksoft.moneyday.core.mapper.WeixinSessionMapper;

@Service
public class WeixinSessionService extends BaseService {

	@Autowired
	WeixinSessionMapper mapper;
	
    public int deleteByPrimaryKey(String id){
    	return mapper.deleteByPrimaryKey(id);
    }

    public int create(WeixinSession record){
    	return mapper.insert(record);
    }

    public WeixinSession findByPrimaryKey(String id){
    	return mapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(WeixinSession record){
    	return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(WeixinSession record){
    	return mapper.updateByPrimaryKey(record);
    }

}
