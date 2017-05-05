package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserTaskAdsActive;
import com.ipeaksoft.moneyday.core.mapper.UserTaskAdsActiveMapper;

@Service
public class AdsActiveService  extends BaseService {
    @Autowired
    private UserTaskAdsActiveMapper adsActiveMapper;

    public UserTaskAdsActive create(UserTaskAdsActive record){
    	adsActiveMapper.insert(record);
    	return record;
    }

}
