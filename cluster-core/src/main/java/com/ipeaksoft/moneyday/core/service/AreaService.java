package com.ipeaksoft.moneyday.core.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.mapper.AreaMapper;
import com.ipeaksoft.moneyday.core.entity.Area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AreaService extends BaseService {

	@Autowired
	private AreaMapper AreaMapper;
	/**
	 * 根据父级别编码获取子集数据（地区）
	 * 
	 * @param parentCode
	 * @return
	 */
	public List<Area>findAreaByParentCode(int parentCode){
		return AreaMapper.findAreaByParentCode(parentCode);
	}
}