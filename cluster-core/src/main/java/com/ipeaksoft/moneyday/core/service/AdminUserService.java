package com.ipeaksoft.moneyday.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.AdminUser;
import com.ipeaksoft.moneyday.core.entity.UserRole;
import com.ipeaksoft.moneyday.core.mapper.AdminUserMapper;
import com.ipeaksoft.moneyday.core.mapper.UserRoleMapper;

@Service
public class AdminUserService extends BaseService {
    @Autowired
    private AdminUserMapper adminUserMapper;
    
    @Autowired
    private UserRoleMapper userRoleMapper;
    
    public int deleteByPrimaryKey(Integer id){
    	return adminUserMapper.deleteByPrimaryKey(id);
    }

    public int addUser(AdminUser record){
    	adminUserMapper.insert(record);
    	UserRole ur = new UserRole();
    	ur.setCreateTime(new Date());
    	ur.setModifyTime(new Date());
    	ur.setUserId(record.getId());
    	int level = record.getLevel();
    	if(-1 == level) {
    		ur.setRoleId(1);
    	} else if (0 == level) {
    		ur.setRoleId(2);
    	} else if(4 == level) {
    		ur.setRoleId(4);
    	} else {
    		ur.setRoleId(3);
    	}
    	userRoleMapper.insert(ur);
		return record.getId();
    }

    public int insertSelective(AdminUser record){
    	return adminUserMapper.insertSelective(record);
    }

    public AdminUser getUserById(Integer id){
    	return adminUserMapper.selectByPrimaryKey(id);
    }
    
    public AdminUser getLevel3UserById(Integer id){
    	return adminUserMapper.selectLevel3ByPrimaryKey(id);
    }
    
	public AdminUser getUserByName(String name) {
		return adminUserMapper.getUserByName(name);
	}

    public int updateUser(AdminUser record){
    	return adminUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AdminUser record){
    	return adminUserMapper.updateByPrimaryKey(record);
    }
    
	public int setUserInvalid(int id) {
		return adminUserMapper.setUserInvalid(id);
	}
	
	public List<AdminUser> getValidAdmin(){
		return adminUserMapper.getValidUsersByRoleName("普通管理员");
	}
	
	public List<AdminUser> findUserByWhere(AdminUser record){
		return adminUserMapper.findUserByWhere(record);
	}
	
	/**
	 * 获取推广员/管理员  用户列表
	 * @param parameters //参数对象
	 * @return List<AdminUser>
	 */
	public List<AdminUser> findPageUserByWhere(Map<String,Object> parameters){
		return adminUserMapper.findPageUserByWhere(parameters);
	}
	
	public int findPageUserByWhereCount(Map<String,Object> parameters){
		return adminUserMapper.findPageUserByWhereCount(parameters);
	}

}