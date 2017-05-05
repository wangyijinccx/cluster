package com.ipeaksoft.moneyday.core.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ipeaksoft.moneyday.core.entity.AdminUser;
import com.ipeaksoft.moneyday.core.entity.BlackUser;
import com.ipeaksoft.moneyday.core.entity.TaskSearch;
import com.ipeaksoft.moneyday.core.entity.User;
import com.ipeaksoft.moneyday.core.entity.UserActionHistory;
import com.ipeaksoft.moneyday.core.entity.UserLoginException;
import com.ipeaksoft.moneyday.core.entity.UserRecord;
import com.ipeaksoft.moneyday.core.entity.UserTask;
import com.ipeaksoft.moneyday.core.entity.UserValidate;
import com.ipeaksoft.moneyday.core.exception.UserNotFoundException;
import com.ipeaksoft.moneyday.core.mapper.BlackUserMapper;
import com.ipeaksoft.moneyday.core.mapper.UserActionHistoryMapper;
import com.ipeaksoft.moneyday.core.mapper.UserLoginExceptionMapper;
import com.ipeaksoft.moneyday.core.mapper.UserMapper;
import com.ipeaksoft.moneyday.core.mapper.UserRecordMapper;
import com.ipeaksoft.moneyday.core.mapper.UserValidateMapper;
import com.ipeaksoft.moneyday.core.util.DateUtil;

@Service
public class UserService extends BaseService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private WeixinUserService weixinUserService;
	@Autowired
	private UserRecordMapper userRecordMapper;
	@Autowired
	private UserLoginExceptionMapper userLoginExceptionMapper;
	@Autowired
	private BlackUserMapper blackUserMapper;

	@Autowired
	private UserActionHistoryMapper serActionHistoryMapper;

	@Autowired
	private UserValidateMapper userValidateMapper;

	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	public Long addUser(User record) {
		// Long userId=Long.parseLong(CreateID.generate9());
		// record.setUserid(userId);
		return userMapper.insert(record);
	}

	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	public User getUserById(Long id) throws UserNotFoundException, Exception {
		User user = userMapper.selectByPrimaryKey(id);
		if (null != user) {
			return userMapper.selectByPrimaryKey(id);
		} else {
			throw new UserNotFoundException("User not found Exception");
		}
	}

	public int updateUser(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByMobile(User record) {
		return userMapper.updateByMobileKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public User getUserByName(String username) {
		return userMapper.selectByName(username);
	}

	public User getUserByMobile(String mobile) {
		return userMapper.selectByMobile(mobile);
	}

	public User getWeixinUserByMobile(String mobile) {
		return userMapper.selectWeixinUserByMobile(mobile);
	}

	public User login(User record) throws Exception {
		User usr = userMapper.login(record);
		// 增加登录行为
		if (usr != null) {
			UserActionHistory ua = new UserActionHistory();
			ua.setCreateTime(new Date());
			ua.setUserid(usr.getUserid());
			ua.setActionType(1);// 登录
			serActionHistoryMapper.insert(ua);
		}
		return userMapper.login(record);
	}

	public BlackUser selectBlackUserByMobile(String mobile) {
		BlackUser bk = blackUserMapper.selectByMobile(mobile);
		return bk;
	}

	public List<User> getListByIdfa(String Idfa) {
		return userMapper.selectListByIdfa(Idfa);
	}
	
	public User getUserByIdfa(String Idfa) {
	    return userMapper.selectByIdfa(Idfa);
	}

	public User getUserByAppleId(String appleId) {
		return userMapper.getUserByAppleId(appleId);
	}

	public List<User> findPageByWhere(Map map) {
		return userMapper.findPageByWhere(map);
	}

	public int findPageByWhereCount(Map map) {
		return userMapper.findPageByWhereCount(map);
	}

	public List<User> findUserByWhere(User user) {
		return userMapper.findUserByWhere(user);
	}

	public List<User> findUserByMobileAndId(User user) {
		return userMapper.findUserByMobileAndId(user);
	}

	public String getValidStatus(String mobile) {
		UserValidate uv = userValidateMapper.selectByMobile(mobile);
		if (uv == null) {
			return "3";
		}
		String status = uv.getEnable();
		if ("Y".equalsIgnoreCase(status)) {
			return "1";
		} else if ("N".equalsIgnoreCase(status)) {
			return "0";
		} else {
			return "2";
		}
	}

	public UserRecord selectTodayAwardByUserId(String mobile) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", mobile);
		map.put("today", DateUtil.getTodayStr());
		List<UserRecord> list = userRecordMapper.selectTodayAwardByMobile(map);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Integer getTotalAwardByMobile(String mobile) {
		return userRecordMapper.getTotalAwardByMobile(mobile);
	}

	public Integer getTodayAwardByUserId(String mobile) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", mobile);
		map.put("today", DateUtil.getTodayStr());
		Integer i = null;
		try {
			i = userRecordMapper.getTodayAwardByMobile(map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return i;
	}

	public List<TaskSearch> findTaskBillDetailByWhere(Map map) {
		return userMapper.findTaskBillDetailByWhere(map);
	}

	public int insertUserLoginException(UserLoginException record) {
		// List<UserLoginException>
		// list=userLoginExceptionMapper.selectByMobile(record.getMoblie());
		// if(list==null){
		return userLoginExceptionMapper.insert(record);
		// }else{
		// UserLoginException rl=list.get(0);
		// rl.setCity(record.getCity());
		// rl.setProvince(record.getProvince());
		// rl.setRegion(record.getRegion());
		// rl.setCreateTime(new Date());
		// rl.setClientType(record.getClientType());
		// return userLoginExceptionMapper.updateByPrimaryKey(record);
		// }

	}

	public List<UserLoginException> getExceptionList(String mobile) {
		return userLoginExceptionMapper.selectByMobile(mobile);
	}

	public UserLoginException selectByMobileAndIdfa(String mobile, String idfa) {
		UserLoginException ule = new UserLoginException();
		ule.setMoblie(mobile);
		ule.setIdfa(idfa);
		return userLoginExceptionMapper.selectByMobileAndIdfa(ule);
	}

	public List<BlackUser> getBlackUserList() {
		return blackUserMapper.selectAll();
	}

	@Transactional(readOnly=false)
	public int ProcessExceptionByUserId(Long id, String mobile, AdminUser operator) {
		User user = userMapper.selectByMobile(mobile);
		if (null == user) {
			return 0;
		}
		user.setStatus(1);
		int effectRow = userMapper.updateByPrimaryKey(user);
		// 查出最后一次处理完到现在的所有异常记录
		List<UserLoginException> ules = userLoginExceptionMapper.selectUnProcessByMobile(mobile);
		UserLoginException lastUle = ules.get(0);
		for(int i = 1; i < ules.size(); i++) {
			if(ules.get(i).getCreateTime().after(lastUle.getCreateTime())) {
				lastUle = ules.get(i);
			}
		}
		// 将最后一条异常记录的idfa更新到user中
		String idfa = lastUle.getIdfa();
		User tempUser = new User();
		tempUser.setMobile(mobile);
		tempUser.setIdfa(idfa);
		userMapper.updateByMobileKeySelective(tempUser);
		// 更新所有异常的处理时间，最后一条记录还需要将status设为1
		for(UserLoginException ule : ules) {
			if(ule.getId().equals(lastUle.getId())) {
				ule.setStatus("1");
			} else {
				ule.setStatus("0");
			}
			ule.setOperator(operator.getUsername());
			ule.setProcessTime(new Date());
			userLoginExceptionMapper.updateByPrimaryKeySelective(ule);
		}
		return effectRow;
	}

	public void addBlackUser(Long id) {
		BlackUser blackUser = blackUserMapper.selectByUserId(id);
		if (blackUser == null) {
			User user = userMapper.selectByPrimaryKey(id);
			BlackUser record = new BlackUser();
			record.setCreateTime(new Date());
			record.setUserid(id);
			record.setIdfa(user.getIdfa());
			record.setMobile(user.getMobile());
			record.setStatus(true);
			record.setUsername(user.getName());
			blackUserMapper.insert(record);
		}
	}

	public void renewBlackUser(Long id) {
		BlackUser blackUser = blackUserMapper.selectByPrimaryKey(id);
		String mobile = blackUser.getMobile();
		User user = new User();
		user.setMobile(mobile);
		user.setStatus(1);
		userMapper.updateByMobileKeySelective(user);
		blackUserMapper.deleteByPrimaryKey(id);
	}

	public List<UserValidate> findUserValidateList(String startDate, String endDate) {
		Map map = new HashMap();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<UserValidate> list = userValidateMapper.selectUserValidateByDate(map);
		return list;
	}

	/**
	 * 黑名单分页查询
	 * 
	 * @param where
	 * @return
	 */
	public List<BlackUser> findPageWhere(Map<String, Object> where) {

		return blackUserMapper.findPageWhere(where);

	}

	/**
	 * 黑名单分页查询 统计总条数
	 * 
	 * @param where
	 * @return
	 */
	public int findPageWhereCount(Map<String, Object> where) {
		return blackUserMapper.findPageWhereCount(where);
	}

	/**
	 * 分页查询用户完成的任务数
	 * 
	 * @param map
	 * @return
	 */
	public List<UserTask> findTaskByUser(Map<String, Object> map) {
		return userMapper.findTaskByUser(map);
	}

	/**
	 * 统计分页数量
	 * 
	 * @param map
	 * @return
	 */
	public int findTaskByUserCount(Map<String, Object> map) {
		return userMapper.findTaskByUserCount(map);
	}
	
	/**
	 * 分页获取vip账号
	 * @param where
	 * @return
	 */
	public List<User> pageWeightAccount(Map<String, Object> where) {
		return userMapper.pageWeightAccount(where);
	}

	public List<User> pageWeightAccountNew(Map<String, Object> where) {
		return userMapper.pageWeightAccountNew(where);
	}

	/**
	 * 统计vip账号总数
	 * @param map
	 * @return
	 */
	public int weightAccountAmount(Map<String, Object> map) {
		return userMapper.weightAccountAmount(map);
	}
	
	public int weightAccountAmountNew(Map<String, Object> map) {
		return userMapper.weightAccountAmountNew(map);
	}
	
	/**
	 * 删除一个用户的所有信息（仅为了方便测试提供，不对外提供这个接口）
	 * @param mobile
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int deleteUserAllInfo(String mobile) {
		return userMapper.deleteUserAllInfo(mobile);
	}
	
	/**
     * 获取所有权重账号汇总信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> getAllWeightAccount() {
    	return userMapper.getAllWeightAccount();
    }
    
    /**
     * 获取所有权重账号明细信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> getAllWeightAccountInfo() {
        return userMapper.getAllWeightAccountInfo();
    }

}