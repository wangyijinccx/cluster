package com.ipeaksoft.moneyday.admin.util.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ipeaksoft.moneyday.core.entity.AdminUser;
import com.ipeaksoft.moneyday.core.service.AdminUserService;

public class SpringSecurityUtils {

	@Autowired
	protected AdminUserService adminUserService;

	public SpringSecurityUtils() {
		super();
	}

	public SpringSecurityUtils(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	/**
	 * 取得当前用户的登录名,如果当前用户未登录则返回null.
	 */
	public static String getCurrentUserName() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth == null)
			return null;
		return auth.getName();
	}

	/**
	 * 取得当前用户信息,如果当前用户未登录则返回null.
	 */
	public  AdminUser getCurrentUserDetail() {
		String userName = getCurrentUserName();
		return adminUserService.getUserByName(userName);
	}

}
