package com.ipeaksoft.moneyday.core.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserRecordLockService extends BaseService {
	private final Set<String> activeUsers = Collections.synchronizedSet(new HashSet<String>());

	/**
	 * 粗略实现自旋锁，尝试3次
	 * 
	 * @param userid
	 * @return
	 */
	public boolean aquireLock(String userid) {
		int i = 0;
		while (activeUsers.contains(userid) && i++ < 3) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
		if (i < 3) {
			activeUsers.add(userid);
			return true;
		} else {
			if (activeUsers.contains(userid)) {
				return false;
			} else {
				activeUsers.add(userid);
				return true;
			}
		}
	}

	public void realseLock(String userid) {
		activeUsers.remove(userid);
	}
}
