package com.ipeaksoft.moneyday.core.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.LoginAward;
import com.ipeaksoft.moneyday.core.entity.User;
import com.ipeaksoft.moneyday.core.entity.UserAward;
import com.ipeaksoft.moneyday.core.entity.UserRecord;
import com.ipeaksoft.moneyday.core.entity.UserTaskAward;
import com.ipeaksoft.moneyday.core.enums.UserRecordType;
import com.ipeaksoft.moneyday.core.mapper.UserAwardMapper;
import com.ipeaksoft.moneyday.core.mapper.UserMapper;
import com.ipeaksoft.moneyday.core.mapper.UserRecordMapper;
import com.ipeaksoft.moneyday.core.mapper.UserTaskAwardMapper;
import com.ipeaksoft.moneyday.core.util.DateUtil;

@Service
public class UserAwardService extends BaseService {

	@Autowired
	private UserAwardMapper userAwardMapper;

	@Autowired
	UserRecordLockService lock;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRecordMapper userRecordMapper;
	@Autowired
	private UserTaskAwardMapper userTaskAwardMapper;

	public Integer getAwardByMobile(Map<String, Object> map) {
		return userAwardMapper.selectAwardByMobile(map);
	}

	/**
	 * 获取当前用户下次领取奖励所需天数
	 * 
	 * @param mobile
	 * @param receivedAwardCount
	 *            已领取奖励次数
	 * @param dayOfMonth
	 *            当月满勤天数
	 * @return
	 */
	private int getNeedDay(String mobile, int receivedAwardCount, int dayOfMonth) {
		int needDay = 0;
		if (receivedAwardCount < 7) {
			needDay = dayOfMonth;
		}
		if (receivedAwardCount < 5) {
			needDay = 25;
		}
		if (receivedAwardCount < 4) {
			needDay = 15;
		}
		if (receivedAwardCount < 3) {
			needDay = 10;
		}
		if (receivedAwardCount < 2) {
			needDay = 5;
		}
		if (receivedAwardCount < 1) {
			needDay = 2;
		}
		return needDay;
	}

	/**
	 * 获取当前用户下次领取奖励数量
	 * 
	 * @param mobile
	 * @param receivedAwardCount
	 *            已领取奖励次数
	 * @return
	 */
	private int getAward(String mobile, int receivedAwardCount) {
		int award = 0;
		if (receivedAwardCount == 6) {
			award = 0;
		}
		if (receivedAwardCount < 6) {
			award = 400;
		}
		if (receivedAwardCount < 5) {
			award = 300;
		}
		if (receivedAwardCount < 4) {
			award = 150;
		}
		if (receivedAwardCount < 3) {
			award = 100;
		}
		if (receivedAwardCount < 2) {
			award = 50;
		}
		if (receivedAwardCount < 1) {
			award = 10;
		}
		return award;
	}

	public LoginAward getLoginAwards(String mobile) {
		Date date = new Date();
		UserAward ua = updateUserAwardStatus(mobile, date);
		LoginAward la = new LoginAward();
		la.setStatus(ua.getStatus());
		la.setReceiveAmount(String.valueOf(ua.getAward()));
		la.setPercentage(ua.getTaskDays() + "/" + ua.getNeedDays());
		la.setDesc(ua.getDescription());
		return la;
	}

	/**
	 * 更新用户奖励状态
	 * 
	 * @param mobile
	 * @param date
	 * @return
	 */
	private UserAward updateUserAwardStatus(String mobile, Date date) {
		UserAward ua = userAwardMapper.selectBymobile(mobile);

		Map map = new HashMap();
		map.put("mobile", mobile);
		map.put("from", DateUtil.getMinMonthDate(date));
		map.put("to", date);
		int receivedAwardCount = userTaskAwardMapper.getReceivedAwardCount(map);

		// 当月满勤天数
		int dayOfMonth = DateUtil.getDayOfMonth(date);

		int needDay = getNeedDay(mobile, receivedAwardCount, dayOfMonth);

		int taskDays = tasksByMonth(mobile, date);
		if (ua == null) {
			UserAward temp = new UserAward();
			if (taskDays > 0) {
				temp.setModifyTime(date);
				temp.setDescription("已登陆做任务" + taskDays + "天");
				temp.setMobile(mobile);
				temp.setTaskDays(taskDays > needDay ? needDay : taskDays);
				temp.setAward(getAward(mobile, receivedAwardCount));
				temp.setNeedDays(needDay);
				if (temp.getNeedDays() == temp.getTaskDays()) {
					// 全部领完
					if (receivedAwardCount == 6) {
						temp.setStatus("0");
					} else {
						temp.setStatus("1");
					}
				} else {
					temp.setStatus("0");
				}
				userAwardMapper.insert(temp);
			} else {
				temp.setModifyTime(date);
				temp.setDescription("已登陆做任务0天");
				temp.setMobile(mobile);
				temp.setAward(0);
				temp.setStatus("0");// 未领取
				temp.setTaskDays(0);
				temp.setNeedDays(2);
				userAwardMapper.insert(temp);
			}
			return temp;
		} else {
			if (taskDays > 0) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				String dateMonth = year + "-" + month;

				cal.setTime(ua.getModifyTime());
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
				String modifyMonth = year + "-" + month;

				// 只更新日期属于同一个月的记录，以防定时任务执行超过一次
				if (dateMonth.equals(modifyMonth)) {
					ua.setTaskDays(taskDays > needDay ? needDay : taskDays);
					ua.setAward(getAward(mobile, receivedAwardCount));
					ua.setNeedDays(needDay);
					ua.setDescription("已登陆做任务" + taskDays + "天");
					ua.setModifyTime(date);
					if (ua.getNeedDays() == ua.getTaskDays()) {
						// 全部领完
						if (receivedAwardCount == 6) {
							ua.setStatus("0");
						} else {
							ua.setStatus("1");
						}
					} else {
						ua.setStatus("0");
					}
					userAwardMapper.updateByPrimaryKey(ua);
				}
			}
		}
		return ua;
	}

	// 跑批方法
	public void monthDo() {
		// 为防止用户做任务后从来没进入发现界面，从而没有添加user award
		Date now = new Date();
		List<User> users = userMapper.selectUserAll();
		for (Iterator<User> it = users.iterator(); it.hasNext();) {
			User user = it.next();
			updateUserAwardStatus(user.getMobile(),
					DateUtil.getSpecifiedDayTimeBefore(now));
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		int year = cal.get(Calendar.YEAR);// 得到年
		int month = cal.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
		String date = DateUtil.getSpecifiedDayBefore(
				year + "-" + month + "-" + "1").substring(0, 7);
		while (true) {
			Map map = new HashMap();
			map.put("date", date);
			List<UserAward> list = userAwardMapper.selectByMonthDate(map); // 获取上一个月的做任务奖励
			List<UserAward> sList = userAwardMapper.selectByStatus(1); // 获取上一个月所有可领取的做任务奖励
			// 如果已领取任务的记录为空
			if (sList == null || sList.size() == 0) {
				// 清0
				for (UserAward ua : list) {
					ua.setTaskDays(0);
					ua.setNeedDays(2);
					ua.setAward(0);
					ua.setStatus("0");
					ua.setDescription("已登陆做任务0天");
					ua.setModifyTime(now);
					userAwardMapper.updateByPrimaryKey(ua);
				}
				break;
			} else {
				// 循环领取做任务奖励
				for (UserAward ua : sList) {
					if ("1".equals(ua.getStatus())) {
						receiveReward(ua.getMobile(), "1");
					}
				}
			}
		}
	}

	/**
	 * 领取奖励
	 * 
	 * @param mobile
	 * @param flag
	 *            区分标志，如果是定时任务执行该方法flag为1
	 */
	public void receiveReward(String mobile, String flag) {
		UserAward ua = userAwardMapper.selectBymobile(mobile);

		if (ua != null && "1".equals(ua.getStatus())) {
			create(ua);// 领取奖励

			Date date = new Date();
			if ("1".equals(flag)) {
				date = DateUtil.getSpecifiedDayTimeBefore(date);
			}

			Map map = new HashMap();
			map.put("mobile", mobile);
			map.put("from", DateUtil.getMinMonthDate(date));
			map.put("to", date);
			int receivedAwardCount = userTaskAwardMapper
					.getReceivedAwardCount(map);

			int dayOfMonth = DateUtil.getDayOfMonth(date);

			int needDay = getNeedDay(mobile, receivedAwardCount, dayOfMonth);

			int taskDays = tasksByMonth(mobile, date);

			ua.setTaskDays(taskDays > needDay ? needDay : taskDays);
			ua.setAward(getAward(mobile, receivedAwardCount));
			ua.setNeedDays(needDay);
			ua.setDescription("已登陆做任务" + taskDays + "天");
			ua.setModifyTime(date);
			if (ua.getNeedDays() == ua.getTaskDays()) {
				if (receivedAwardCount == 6) {
					ua.setStatus("0");
				} else {
					ua.setStatus("1");
				}
			} else {
				ua.setStatus("0");
			}
			userAwardMapper.updateByPrimaryKey(ua);
		}
	}

	/**
	 * 创建领取奖励记录
	 * 
	 * @param ua
	 */
	private void create(UserAward ua) {
		UserRecord record = new UserRecord();
		record.setMobile(ua.getMobile());
		record.setAward(ua.getAward());
		record.setPid(ua.getId());
		record.setCreateTime(ua.getModifyTime());
		record.setType(UserRecordType.AWARD);
		StringBuffer sf = new StringBuffer();
		sf.append("本月" + ua.getTaskDays());
		sf.append("日有任务收益");
		sf.append("  +" + ua.getAward());
		record.setDescription(sf.toString());
		int totalAward = ua.getAward();
		String mobile = ua.getMobile();

		UserTaskAward ut = new UserTaskAward();
		ut.setAward(ua.getAward());
		ut.setCreateTime(ua.getModifyTime());
		ut.setMobile(ua.getMobile());
		ut.setTaskName(sf.toString());
		if (lock.aquireLock(mobile)) {
			try {
				UserRecord last = userRecordMapper.selectLastByMobile(mobile);
				if (last != null) {
					totalAward += last.getTotalAward();
				}
				record.setTotalAward(totalAward);
				userRecordMapper.insert(record);
				userTaskAwardMapper.insert(ut);

				User user = new User();
				user.setMobile(mobile);
				user.setAward(totalAward);
				userMapper.updateByMobileKeySelective(user);
			} finally {
				lock.realseLock(mobile);
			}
		}
	}

	/**
	 * 当月或上月做任务的天数
	 * 
	 * @param mobile
	 * @param date
	 * @return
	 */
	private int tasksByMonth(String mobile, Date date) {
		String today = new SimpleDateFormat("yyyy-MM-dd").format(date)
				.substring(0, 7);// 当前月份
		Map map = new HashMap();
		map.put("mobile", mobile);
		map.put("today", today);
		int i = 0;
		List<String> list = new ArrayList();
		List<String> fast = userAwardMapper
				.selectFastTaskDateByMobileAndDate(map);
		List<String> ads = userAwardMapper
				.selectAdsTaskDateByMobileAndDate(map);
		if (fast != null) {
			list.addAll(fast);
		}
		if (ads != null) {
			list.addAll(ads);
		}
		// 去重
		Set set = new HashSet(list);
		return set.size();
		// int ads=userAwardMapper.selectAdsTaskByMobileAndDate(map);
		// return i+fast+ads;
	}

	public Integer getAward(String mobile) {
		Date now=new Date();
		Map map = new HashMap();
		map.put("mobile", mobile);
		map.put("from", DateUtil.getMinMonthDate(now));
		map.put("to", now);
		int receivedAwardCount = userTaskAwardMapper
				.getReceivedAwardCount(map);
		int award=getAward(mobile, receivedAwardCount);
		return award;
	}

	public int insert(UserAward record) {
		return userAwardMapper.insert(record);
	}
}