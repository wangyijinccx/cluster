package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserRecord;

public interface UserRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRecord record);

    int insertSelective(UserRecord record);

    UserRecord selectByPrimaryKey(Long id);
    UserRecord selectLastByMobile(String mobile);

    int updateByPrimaryKeySelective(UserRecord record);

    int updateByPrimaryKey(UserRecord record);
    
    List<UserRecord> selectTodayAwardByMobile(Map map);
    
  	Integer getTodayAwardByMobile(Map map);
  	
	Integer getTotalAwardByMobile(String mobile);

    List<UserRecord> selectPageByMobile(Map<String, Object> map);
}