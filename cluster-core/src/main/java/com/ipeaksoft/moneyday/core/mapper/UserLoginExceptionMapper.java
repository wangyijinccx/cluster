package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserLoginException;

public interface UserLoginExceptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLoginException record);

    int insertSelective(UserLoginException record);

    UserLoginException selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLoginException record);

    int updateByPrimaryKey(UserLoginException record);
    
    List<UserLoginException> selectByMobile(String mobile);
    
    List<UserLoginException> selectUnProcessByMobile(String mobile);
    
    /**
     * 获取未处理的异常
     * @param map
     * @return
     */
    List<UserLoginException> findPage(Map<String,Object> map);
    
    /**
     * 获取未处理异常信息总条数
     * @return
     */
    int findPageCount();
    
    UserLoginException selectByMobileAndIdfa(UserLoginException record);
    
}