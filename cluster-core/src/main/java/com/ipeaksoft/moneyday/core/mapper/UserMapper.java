package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.TaskSearch;
import com.ipeaksoft.moneyday.core.entity.User;
import com.ipeaksoft.moneyday.core.entity.UserTask;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    Long insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);
    
    int updateByMobileKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByName(String username);
    
    List<User> findPageByWhere(Map map);
    
    int findPageByWhereCount(Map map);
    
    User selectByMobile(String mobile);
    
    User selectByIdfa(String idfa);
    
    User getUserByAppleId(String appleId);
    
    List<User> findUserByWhere(User user);
    
    List<User> findUserByMobileAndId(User user);
    
    List<TaskSearch> findTaskBillDetailByWhere(Map map);
    
    User login(User user);
    /**
     * 分页查询用户完成的任务数
     * @param map
     * @return
     */
    List<UserTask> findTaskByUser(Map<String,Object> map);
    
    /**
     * 统计分页数量
     * @param map
     * @return
     */
    int findTaskByUserCount(Map<String,Object>map);

    User selectWeixinUserByMobile(String mobile);
    
    /**
     * 分页获取vip账号
     * @param map
     * @return
     */
    @SuppressWarnings("rawtypes")
	List<User> pageWeightAccount(Map map);

    @SuppressWarnings("rawtypes")
	List<User> pageWeightAccountNew(Map map);

    /**
     * 统计vip账号总数
     * @param map
     * @return
     */
    int weightAccountAmount(Map<String,Object>map);

    int weightAccountAmountNew(Map<String,Object>map);

    List<User> selectUserAll();
    
    /**
	 * 删除一个用户的所有信息（仅为了方便测试提供，不对外提供这个接口）
	 * @param mobile
	 * @return
	 */
    int deleteUserAllInfo(String mobile);
    
    /**
     * 获取所有权重账号汇总信息
     * @param map
     * @return
     */
    List<Map<String, Object>> getAllWeightAccount();

    /**
     * 获取所有权重账号明细信息
     * @param map
     * @return
     */
    List<Map<String, Object>> getAllWeightAccountInfo();

    List<User> selectListByIdfa(String idfa);
    
}