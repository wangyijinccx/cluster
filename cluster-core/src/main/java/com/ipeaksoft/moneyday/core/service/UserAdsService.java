package com.ipeaksoft.moneyday.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserTaskAds;
import com.ipeaksoft.moneyday.core.mapper.UserTaskAdsMapper;
import  com.ipeaksoft.moneyday.core.mapper.UserAwardMapper;

@Service
public class UserAdsService  extends BaseService {
    @Autowired
    private UserTaskAdsMapper userTaskAdsMapper;
    @Autowired
    private UserAwardMapper userAwardMapper;
    public UserTaskAds create(UserTaskAds record){
    	userTaskAdsMapper.insert(record);
    	return record;
    }
    public Integer getAwardByMobile(Map<String, Object> map) {
        return userTaskAdsMapper.selectAwardByMobile(map);
    }

}
