package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ipeaksoft.moneyday.core.entity.AdminUser;

@Repository
public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);
    
    AdminUser selectLevel3ByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
    
    AdminUser getUserByName(String name);
    
    int setUserInvalid(int id);
   
    /**
     *按区域+学校+团队 
     * @param name
     * @return
     */
    List<AdminUser> findUserByWhere(AdminUser record);

    List<AdminUser> getValidUsersByRoleName(String roleName);
    
    List<AdminUser> findPageUserByWhere(Map<String,Object> parameters);
    
    int findPageUserByWhereCount(Map<String,Object> parameters);
}