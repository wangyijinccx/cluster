package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserTaskAdsClick;
import com.ipeaksoft.moneyday.core.mapper.UserTaskAdsClickMapper;

@Service
public class AdsClickService  extends BaseService {
    @Autowired
    private UserTaskAdsClickMapper adsClickMapper;

    public UserTaskAdsClick create(UserTaskAdsClick record){
    	adsClickMapper.insert(record);
    	return record;
    }

}
