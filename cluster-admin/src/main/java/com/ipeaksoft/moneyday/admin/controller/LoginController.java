package com.ipeaksoft.moneyday.admin.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipeaksoft.moneyday.core.entity.AdminUser;
import com.ipeaksoft.moneyday.core.service.AdminUserService;

@Controller
@RequestMapping(value = "/")
public class LoginController extends BaseController{

	public final static String USER_SESSION_KEY = "user_session_key";

	@Autowired
	protected AdminUserService adminUserService;

	@RequestMapping(value = "/index")
	public String loginSuccess(ModelMap map, Principal principal,
			HttpServletRequest request) {

		String name = principal.getName();
		AdminUser user = adminUserService.getUserByName(name);
		request.getSession().setAttribute(USER_SESSION_KEY, user);
		if(4 == user.getLevel()) {
			return "redirect:/weightAccount/weight_account_list.jsp";
		} else {
			return "redirect:/cserver/publish";
		}
	}

	@RequestMapping(value = "/login")
	public String login(ModelMap map, Integer error) {
		if (error != null) {
			if (error.intValue() == 1)
				map.addAttribute("errorMessage", "用户名或密码错误!");
			else if (error.intValue() == 3)
				map.addAttribute("errorMessage", "用户已从别处登录!");
		}
		return "/login";
	}

	@RequestMapping(value = "/denied")
	public String loginerror(ModelMap map) {
		return "/common/403";
	}

	@RequestMapping(value = "/logout")
	public String logout(ModelMap map) {
		System.out.println("logout called...");
		return "/login";

	}
}
