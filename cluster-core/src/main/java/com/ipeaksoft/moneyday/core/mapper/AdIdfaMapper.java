package com.ipeaksoft.moneyday.core.mapper;

import org.springframework.stereotype.Repository;

import com.ipeaksoft.moneyday.core.entity.AdIdfa;

@Repository
public interface AdIdfaMapper {
	
	AdIdfa findAbIdfaByAbAndIdfa(AdIdfa adIdfa);

}
