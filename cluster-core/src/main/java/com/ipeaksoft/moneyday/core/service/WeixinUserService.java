package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.WeixinUser;
import com.ipeaksoft.moneyday.core.mapper.WeixinUserMapper;

@Service
public class WeixinUserService extends BaseService {

	@Autowired
	WeixinUserMapper mapper;
	
    public int deleteByPrimaryKey(String id){
    	return mapper.deleteByPrimaryKey(id);
    }

    public int create(WeixinUser record){
    	return mapper.insert(record);
    }

    public WeixinUser findByPrimaryKey(String id){
    	return mapper.selectByPrimaryKey(id);
    }

    public WeixinUser findByOpenid(String openid){
    	return mapper.selectByOpenid(openid);
    }

    public WeixinUser findByMobile(String mobile){
    	return mapper.selectByMobile(mobile);
    }

    public int updateByPrimaryKeySelective(WeixinUser record){
    	return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(WeixinUser record){
    	return mapper.updateByPrimaryKey(record);
    }

    public int updateByOpenid(WeixinUser record){
    	return mapper.updateByOpenid(record);
    }
    
    public int bindMobile(String openid, String mobile){
    	WeixinUser record = new WeixinUser();
    	record.setOpenid(openid);
    	record.setMobile(mobile);
    	return mapper.updateByOpenid(record);
    }
    
    public int bindUserid(String openid, long userid){
    	WeixinUser record = new WeixinUser();
    	record.setOpenid(openid);
    	record.setUserid(userid);
    	return mapper.updateByOpenid(record);
    }

    public int bindIdfa(String openid, String idfa){
    	WeixinUser record = new WeixinUser();
    	record.setOpenid(openid);
    	record.setIdfa(idfa);
    	return mapper.updateByOpenid(record);
    }

}
