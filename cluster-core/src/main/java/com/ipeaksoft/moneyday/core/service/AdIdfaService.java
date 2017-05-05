package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.AdIdfa;
import com.ipeaksoft.moneyday.core.mapper.AdIdfaMapper;

@Service
public class AdIdfaService {
	
	@Autowired
	private AdIdfaMapper adIdfaMapper;
	
	public AdIdfa findAbIdfaByAbAndIdfa(AdIdfa adIdfa ){
		return adIdfaMapper.findAbIdfaByAbAndIdfa(adIdfa);
	}

}
