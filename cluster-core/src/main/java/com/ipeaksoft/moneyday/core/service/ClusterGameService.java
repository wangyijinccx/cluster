package com.ipeaksoft.moneyday.core.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.ClusterGame;
import com.ipeaksoft.moneyday.core.mapper.ClusterGameMapper;

@Service
public class ClusterGameService {

	@Autowired
	private ClusterGameMapper clusterGameMapper;

	public int insert(ClusterGame clusterGame) {
		return clusterGameMapper.insert(clusterGame);
	}

	public List<Map<String, Object>> selectListGame(Integer start,
			Integer length) {
		return clusterGameMapper.selectListGame(start, length);
	}
	public int selectNum(){
		return clusterGameMapper.selectNum();
	}
	
	 public ClusterGame selectByPrimaryKey(Integer id){
		 return clusterGameMapper.selectByPrimaryKey(id);
	 }
	 
	 public int updateByPrimaryKeySelective(ClusterGame record){
		 return clusterGameMapper.updateByPrimaryKeySelective(record);
	 }
	 
	 public List<ClusterGame>  selectAll(){
		 return clusterGameMapper.selectAll();
	 };
}
