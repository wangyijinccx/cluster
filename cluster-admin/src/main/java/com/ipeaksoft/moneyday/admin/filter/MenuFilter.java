package com.ipeaksoft.moneyday.admin.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ipeaksoft.moneyday.admin.dto.Menu;
import com.ipeaksoft.moneyday.admin.dto.MenuService;

public class MenuFilter extends HandlerInterceptorAdapter {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MenuService menuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	HttpSession session = request.getSession();
    	@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>)session.getAttribute("menus");
    	logger.debug("menuList: {}", menuList);
    	if (menuList == null || menuList.size() == 0){
        	String username = null;
        	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        	if (principal instanceof UserDetails) {
        	  username = ((UserDetails)principal).getUsername();
        	} else {
        	  username = principal.toString();
        	}
        	logger.debug("username: {}", username);
        	if (StringUtils.isNotEmpty(username)){
            	List<Menu> menus = menuService.loadMenu(username);
            	session.setAttribute("menus", menus);
        	}
    	}
        return true;
    }

}
