package com.ipeaksoft.moneyday.core.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.IdfaApp;
import com.ipeaksoft.moneyday.core.mapper.IdfaAppMapper;

@Service
public class IdfaAppService extends BaseService {
    @Autowired
    private IdfaAppMapper mapper;

    public int deleteByPrimaryKey(Integer id){
    	return mapper.deleteByPrimaryKey(id);
    }

    public int insert(IdfaApp record){
    	return mapper.insert(record);
    }

    public IdfaApp selectByPrimaryKey(Integer id){
    	return mapper.selectByPrimaryKey(id);
    }

    public int selectDuplicateCntByAppidAndIdfa(String appid, String idfa){
    	return mapper.selectDuplicateCntByAppidAndIdfa(appid, idfa);
    }

    public int selectCntByAppidAndIdfa(String appid, String idfa){
    	return mapper.selectCntByAppidAndIdfa(appid, idfa);
    }

    public List<String> selectByAppidAndIdfas(String appid, Collection<String> idfas){
    	return mapper.selectByAppidAndIdfas(appid, idfas);
    }
    
	public List<IdfaApp> selectByAppidAndTime(String appid, String startDate,
			String endDate) {
		return mapper.selectByAppidAndTime(appid, startDate, endDate);
	}

	public List<IdfaApp> selectJoinComp(String appid, String startDate,
			String endDate){
		return mapper.selectJoinComp(appid, startDate, endDate);
	}

	public List<IdfaApp> selectDiffComp(String appid, String startDate,
			String endDate){
		return mapper.selectDiffComp(appid, startDate, endDate);
	}

}