package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.BlackUser;

public interface BlackUserMapper {
    int deleteByPrimaryKey(Long id);
  
    int insert(BlackUser record);

    int insertSelective(BlackUser record);

    BlackUser selectByPrimaryKey(Long id);
    
    BlackUser selectByUserId(Long id);

    int updateByPrimaryKeySelective(BlackUser record);

    int updateByPrimaryKey(BlackUser record);
    
    int deleteByUserId(Long id);
    
    List<BlackUser> selectAll();
    
    BlackUser selectByMobile(String mobile);
    
    /**
     * 黑名单分页查询
     * @param where
     * @return
     */
    List<BlackUser>findPageWhere(Map<String,Object> where);
    /**
     * 黑名单分页查询 统计总条数
     * @param where
     * @return
     */
    int findPageWhereCount(Map<String,Object> where);
}