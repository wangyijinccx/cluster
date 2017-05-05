package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserAward;

public interface UserAwardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAward record);

    int insertSelective(UserAward record);

    UserAward selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAward record);

    int updateByPrimaryKey(UserAward record);
    
   int HasNewRewardBymobile(Map map);
    
    UserAward findUserAwardByUserId(Map map);
    
    List<UserAward>  selectByStatus(Integer status);
    
    List<UserAward> selectByMonthDate(Map date);
    
    UserAward selectBymobile(String mobile);
    
    UserAward  selectByMobileAndDate(Map map);
    
    Integer selectAwardByMobile(Map<String, Object> map);
    
    Integer selectAdsTaskByMobileAndDate(Map map);
    
    Integer selectFastTaskByMobileAndDate(Map map);
    
    List<String> selectAdsTaskDateByMobileAndDate(Map map);
    
    List<String> selectFastTaskDateByMobileAndDate(Map map);
}