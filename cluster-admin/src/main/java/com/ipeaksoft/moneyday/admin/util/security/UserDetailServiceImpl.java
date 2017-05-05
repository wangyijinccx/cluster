package com.ipeaksoft.moneyday.admin.util.security;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ipeaksoft.moneyday.core.entity.AdminUser;
import com.ipeaksoft.moneyday.core.entity.Role;
import com.ipeaksoft.moneyday.core.service.AdminUserService;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 * @author
 */

@Component("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	protected AdminUserService adminUserService;

	/**
	 * 获取用户Detail信息的回调函数.
	 */
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException,
			DataAccessException {
		try {
			// userName= URLEncoder.encode(userName,"UTF-8");
			userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		AdminUser user = adminUserService.getUserByName(userName);
		if (user == null)
			throw new UsernameNotFoundException("用户" + userName + " 不存在");

		if (user.getIsValid() < 1)
			throw new UsernameNotFoundException(userName + " 已失效");

		Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(user);

		// 中无以下属性,暂时全部设为true.
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		org.springframework.security.core.userdetails.UserDetails userdetail = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuths);

		return userdetail;
	}

	/**
	 * 获得用户所有角色的权限.
	 */
	private Set<GrantedAuthority> obtainGrantedAuthorities(AdminUser user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		Set<Role> userRoles = user.getUserRoles();
		if (user != null) {
			for (Role role : userRoles) {
				authSet.add(new SimpleGrantedAuthority(role.getName()));
			}
		}
		return authSet;
	}
}