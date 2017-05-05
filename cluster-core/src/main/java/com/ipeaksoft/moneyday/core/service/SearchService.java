package com.ipeaksoft.moneyday.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.dto.PageResult;
import com.ipeaksoft.moneyday.core.entity.StatMember;
import com.ipeaksoft.moneyday.core.entity.TaskFastStatistics;
import com.ipeaksoft.moneyday.core.entity.User;
import com.ipeaksoft.moneyday.core.entity.UserSurvey;
import com.ipeaksoft.moneyday.core.entity.UserSurveyDetail;
import com.ipeaksoft.moneyday.core.mapper.SearchMapper;
import com.ipeaksoft.moneyday.core.mapper.StatDayMapper;
import com.ipeaksoft.moneyday.core.mapper.StatMemberMapper;
import com.ipeaksoft.moneyday.core.mapper.UserMapper;

@Service
public class SearchService extends BaseService {

	@Autowired
	private SearchMapper searchMapper;

	@Autowired
	private StatDayMapper statDayMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private StatMemberMapper statMemberMapper;

	// 开始时间，结束时间
	public List<UserSurveyDetail> findByWhere(Map<String, Object> map) {
		List<UserSurveyDetail> list = searchMapper.findByWhere(map);
		return list;
	}

	public int findByWhereCount(Map<String, Object> map) {
		return searchMapper.findByWhereCount(map);
	}

	// 开始时间，结束时间
	public List<UserSurvey> getUserSurveyList(String startDate, String endDate) {
		List<UserSurvey> list = searchMapper.getUserSurvey(startDate, endDate);
		return list;
	}

	// 开始时间，结束时间
	public UserSurvey getUserSurvey(String startDate, String endDate) {
		List<UserSurvey> list = searchMapper.getUserSurvey(startDate, endDate);
		UserSurvey us = null;
		if (list != null && list.size() > 0) {
			us = list.get(0);
			// us = new UserSurvey();
			// us.setRegitUsersAll(list.size());
			// for(UserSurvey user:list){
			// char type=user.getType().toCharArray()[0];
			// //线下
			// if("offline".equals(user.getFromto())){
			// switch(type){
			// case 'A':us.setOfflineAUsers(user.getUsers());break;
			// case 'B':us.setOfflineBUsers(user.getUsers());break;
			// case 'C':us.setOfflineCUsers(user.getUsers());break;
			// case 'D':us.setOfflineUsers(user.getUsers());break;
			// }
			//
			// }else{ //线上
			// switch(type){
			// case 'A':us.setOnlineAUsers(user.getUsers());break;
			// case 'B':us.setOnlineBUsers(user.getUsers());break;
			// case 'C':us.setOnlineCUsers(user.getUsers());break;
			// case 'D':us.setOnlineUsers(user.getUsers());break;
			// }
			// }
			// }
		}
		return us;
	}

	// /**
	// * 任务详情
	// *
	// * @param start
	// * @param end
	// * @return
	// */
	// public List<StatDay> findListByDate(String start, String end) {
	// Map map = new HashMap();
	// map.put("start", start);
	// map.put("end", end);
	// List<StatDay> list = statDayMapper.findListByDate(map);
	// return list;
	// }

	public List<Map> findFastTaskByWhere(String from, String to) {
		Map map = new HashMap();
		map.put("from", from);
		map.put("to", to);
		List<Map> list = searchMapper.findFastTask(map);

		return list;
	}

	/**
	 * 快速任务
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Map> findFastTaskListByDay(String day) {
		List<Map> list = searchMapper.findFastTaskListByDay(day);
		return list;
	}

	/**
	 * 常规任务按天统计　
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Map> findAdsTaskListByDay(String day) {
		List<Map> list = searchMapper.findAdsTaskListByDay(day);
		return list;
	}

	/**
	 * 快速任务按天，任务号查询
	 * 
	 * @param day
	 * @param taskId
	 * @return
	 */
	public List<Map> findFastTaskDetailListByDay(String day, Integer taskId) {
		Map map = new HashMap();
		map.put("day", day);
		map.put("taskId", taskId);
		List<Map> list = searchMapper.findFastTaskDetailListByDay(map);
		return list;
	}

	/**
	 * 用户概览
	 */
	public List<Map> findUsersSurveyListByWhere(String start, String end) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<Map> list = searchMapper.findUsersSurveyListByWhere(map);
		return list;
	}

	/**
	 * 用户概览按天
	 */
	public List<Map> findUsersSurveyListByDay(String day) {
		List<Map> list = searchMapper.findUsersSurveyListByDay(day);
		return list;
	}

	/**
	 * 用户概览按天
	 */
	public List<Map> findUsersSurveyListByDayAndType(String day, String type) {
		Map map = new HashMap();
		map.put("day", day);
		map.put("type", type);
		List<Map> list = searchMapper.findUsersSurveyListByDayAndType(map);
		return list;
	}

	/**
	 * 聚得用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public User findUser(String userName) {
		return userMapper.selectByName(userName);
	}

	/**
	 * 用户明细
	 */
	public List<Map> findUserDetailList(String from, String to, String userName) {
		Map map = new HashMap();
		map.put("from", from);
		map.put("to", to);
		map.put("userName", userName);
		List<Map> list = searchMapper.findUserDetailList(map);
		return list;
	}

	/**
	 * 快速任务统计查询
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<TaskFastStatistics> findFastTaskStatistics(String startDate, String endDate,
			int startIndex, int pageSize) {
		Map map = new HashMap();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("currentPage", startIndex);
		map.put("pageSize", pageSize);
		List<TaskFastStatistics> items = searchMapper.findFastTaskStatistics(map);
		return items;
	}

	/**
	 * 快速任务统计查询(总条数)
	 * 
	 * @param map
	 * @return
	 */
	public int findFastTaskStatisticsCount(String startDate, String endDate, int startIndex,
			int pageSize) {
		Map map = new HashMap();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("currentPage", startIndex);
		map.put("pageSize", pageSize);
		return searchMapper.findFastTaskStatisticsCount(map);
	}

	/**
	 * 获取快速任务总收益
	 * 
	 * @return
	 */
	public int getTaskFastIncome() {
		return searchMapper.getTaskFastIncome();
	}

	/**
	 * 获取业绩查询数据_不分页
	 * 
	 * @author qianqian
	 * @date 2015-03-03
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageResult getPerformanceData(int userId, String startDate, String endData) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user_id", userId);
		param.put("start", -1);
		param.put("length", 0);
		param.put("start_date", startDate);
		param.put("end_date", endData);

		PageResult result = new PageResult();

		List<List<?>> resultSet = searchMapper.getPerformance(param);

		result.setRecordsFiltered(((List<Long>) resultSet.get(0)).get(0));
		result.setData((List<Map<String, Object>>) resultSet.get(1));

		return result;
	}

	/**
     * 获取业绩查询数据_分页
     * 
     * @author qianqian
     * @date 2015-03-03
     * @return
     */
    @SuppressWarnings("unchecked")
    public PageResult getPerformanceData(int userId, int start, int length, String startDate,
    		String endData) {
    	Map<String, Object> param = new HashMap<String, Object>();
    	param.put("user_id", userId);
    	param.put("start", start);
    	param.put("length", length);
    	param.put("start_date", startDate);
    	param.put("end_date", endData);
    
    	PageResult result = new PageResult();
    
    	List<List<?>> resultSet = searchMapper.getPerformance(param);
    
    	result.setRecordsFiltered(((List<Long>) resultSet.get(0)).get(0));
    	result.setData((List<Map<String, Object>>) resultSet.get(1));
    
    	return result;
    }

    /**
	 * 获取业绩查询详细数据
	 * 
	 * @author qianqian
	 * @date 2015-03-03
	 * @return
	 */
	public List<Map<String, Object>> getPerformanceItemData(int userId, String startDate,
			String endData) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user_id", userId);
		param.put("start_date", startDate);
		param.put("end_date", endData);

		return searchMapper.getPerformanceItem(param);
	}

	public List<Map<String, Object>> getPerformanceBillItemData(int userId, String startDate, String endDate) {
        return searchMapper.getPerformanceBillItem(userId, startDate, endDate);
    }
	
	public List<Map<String, Object>> getPerformanceMoneyData(int userId, String startDate, String endDate) {
	    return searchMapper.getPerformanceMoneyItem(userId, startDate, endDate);
	}

    public List<Map<String, Object>> getPerformanceChannelData(int userId, String startDate, String endDate) {
        return searchMapper.getPerformanceChannelItem(userId, startDate, endDate);
    }

    public List<Map<String, Object>> getPerformanceChannel(String startDate, String endDate) {
        return searchMapper.getPerformanceChannel(startDate, endDate);
    }

    public List<Map<String, Object>> getPerformanceChannelClick(String startDate, String endDate) {
        return searchMapper.getPerformanceChannelClick(startDate, endDate);
    }

    /**
	 * 分页查询程序员任务收益统计
	 * 
	 * @param where
	 * @return
	 */
	public List<StatMember> findPageList(Map<String, Object> where) {
		return statMemberMapper.findPageList(where);
	}

	/**
	 * 分页查询程序员任务收益统计总记录数
	 */
	public int findPageListCount(Map<String, Object> where) {
		return statMemberMapper.findPageListCount(where);
	}

}