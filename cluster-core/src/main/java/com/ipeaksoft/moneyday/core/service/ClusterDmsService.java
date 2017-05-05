package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.ClusterDms;
import com.ipeaksoft.moneyday.core.mapper.ClusterDmsMapper;

@Service
public class ClusterDmsService {

	@Autowired
	private ClusterDmsMapper clusterDmsMapper;

	public int insertSelective(ClusterDms record) {
		return clusterDmsMapper.insertSelective(record);
	}

	public ClusterDms checkDms(String name, String url) {
		return clusterDmsMapper.checkDms(name, url);
	}

}
