package com.ipeaksoft.moneyday.core.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.AdsSource;
import com.ipeaksoft.moneyday.core.mapper.AdsSourceMapper;

@Service
public class AdsSourceService extends BaseService{
	@Autowired
	AdsSourceMapper mapper;
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    public AdsSource selectByPrimaryKey(Integer id){
    	return mapper.selectByPrimaryKey(id);
    }
    
    public AdsSource selectByKey(String key){
    	return mapper.selectByKey(key);
    }
    
    public List<AdsSource> selectAll(){
    	return mapper.selectAll();
    }
    
    public List<AdsSource> selectByModifyTime(Date date){
    	return mapper.selectByModifyTime(format.format(date));
    }
    
    public int updateByPrimaryKeySelective(AdsSource adsSource){
    	return mapper.updateByPrimaryKeySelective(adsSource);
    }
    
    public int insert(AdsSource adsSource){
    	return mapper.insert(adsSource);
    }
    

}