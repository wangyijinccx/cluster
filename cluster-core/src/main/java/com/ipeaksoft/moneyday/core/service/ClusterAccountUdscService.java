package com.ipeaksoft.moneyday.core.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.ClusterAccountUdsc;
import com.ipeaksoft.moneyday.core.mapper.ClusterAccountUdscMapper;


@Service
public class ClusterAccountUdscService {

	@Autowired
	private ClusterAccountUdscMapper clusterAccountUdscMapper;
	
	public List<ClusterAccountUdsc> selectByTaskId(Integer taskid){
		return clusterAccountUdscMapper.selectByTaskId(taskid);
	}
	
	public int updateByPrimaryKeySelective(ClusterAccountUdsc record){
		return clusterAccountUdscMapper.updateByPrimaryKeySelective(record);
	}
	
	public  int insertSelective(ClusterAccountUdsc record){
		return clusterAccountUdscMapper.insertSelective(record);
	}
	
	public ClusterAccountUdsc selectByPrimaryKey(Integer id){
		return clusterAccountUdscMapper.selectByPrimaryKey(id);
	}
	
	public Map<String, Object> selectByUdid(String udid){
		return clusterAccountUdscMapper.selectByUdid(udid);
	}

	
}
