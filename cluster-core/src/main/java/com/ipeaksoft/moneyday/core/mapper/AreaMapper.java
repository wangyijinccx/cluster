package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.Area;
import java.util.*;

public interface AreaMapper {
	/**
	 * 根据父级别编码获取子集数据（地区）
	 * 
	 * @param parentCode
	 * @return
	 */
	List<Area> findAreaByParentCode(int parentCode);

}