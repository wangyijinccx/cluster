package com.ipeaksoft.moneyday.core.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.Notice;
import com.ipeaksoft.moneyday.core.entity.UserNotice;
import com.ipeaksoft.moneyday.core.mapper.NoticeMapper;
import com.ipeaksoft.moneyday.core.mapper.UserAwardMapper;
import com.ipeaksoft.moneyday.core.mapper.UserNoticeMapper;
import com.ipeaksoft.moneyday.core.util.DateUtil;

@Service
public class NoticeService extends BaseService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Autowired
	private UserAwardMapper userAwardMapper;

	@Autowired
	private UserNoticeMapper userNoticeMapper;

	public int deleteByPrimaryKey(Long id) {
		return noticeMapper.deleteByPrimaryKey(id);
	}

	public Notice selectByPrimaryKey(Long id) {
		return noticeMapper.selectByPrimaryKey(id);
	}

	public int addNotice(Notice record) {
		return noticeMapper.insert(record);
	}

	public int insertSelective(Notice record) {
		return noticeMapper.insertSelective(record);
	}

	public int updateNotice(Notice record) {
		return noticeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Notice record) {
		return noticeMapper.updateByPrimaryKey(record);
	}

	public List<Notice> selectAll(String mobile) {
		String today = DateUtil.getNowDateTime();
		Map map = new HashMap();
		map.put("today", today);
		map.put("mobile", mobile);
		List<Notice> list = noticeMapper.selectAll(today);
		List<UserNotice> uns = userNoticeMapper.selectByMobile(mobile);
		for (Notice notice : list) {
			notice.setStatus("0");
			for (UserNotice rn : uns) {
				if (notice.getId() == rn.getNoticeId()) {
					notice.setStatus("1");
					break;
				}
			}
		}
		return list;
	}

	public String hasNewAnnounce(String mobile) {
		String today = DateUtil.getNowDateTime();
		Map map = new HashMap();
		map.put("today", today);
		map.put("mobile", mobile);
		int count = noticeMapper.hasNewAnnounce(map);
		if (count > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	public void updateReadStatus(Long noticeId, String mobile) {
		Map map = new HashMap();
		map.put("noticeId", noticeId);
		map.put("mobile", mobile);
		UserNotice un = userNoticeMapper.selectByMobileAndNoticeId(map);
		if (un == null) {
			UserNotice record = new UserNotice();
			record.setCreateTime(new Date());
			record.setMobile(mobile);
			record.setNoticeId(noticeId);
			record.setStatus("1");
			userNoticeMapper.insert(record);
		}
	}

	public String hasNewReward(String mobile) {
		Map map = new HashMap();
		String today = DateUtil.getTodayStr();
		map.put("mobile", mobile);
		map.put("today", today);
		int i = 0;
		int count = 0;
		try {
			count = userAwardMapper.HasNewRewardBymobile(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	public Integer getAllClickPeoples() {
		int i = noticeMapper.getAdsClickUsers();
		int j = noticeMapper.getFastClickUsers();
		return i + j;
	}

	public Long getAllUserAward() {
		Long i = new Long(0);
		try {
			i = noticeMapper.getAllUserAward();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 分页查询公告内容
	 * 
	 * @param where
	 * @return
	 */
	public List<Notice> findPageList(Map<String, Object> where) {
		try {
			return noticeMapper.findPageList(where);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 统计公告所有条数
	 * 
	 * @param where
	 * @return
	 */
	public int findPageListCount(Map<String, Object> where) {
		try {
			return noticeMapper.findPageListCount(where);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}