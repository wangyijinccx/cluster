package com.ipeaksoft.moneyday.admin.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.Authority;
import com.ipeaksoft.moneyday.core.mapper.AuthorityMapper;

@Service
public class MenuService {

	@Autowired
	protected AuthorityMapper authorityMapper;

	public List<Menu> loadMenu(String userName){
		List<Menu> menus = new ArrayList<Menu>();
		List<Authority> auths = authorityMapper.loadByUserName(userName);
		Map<Long, Menu> map = new HashMap<Long, Menu>();
		for (Authority a: auths){
			Menu menu = new Menu();
			menu.setName(a.getDescription());
			menu.setLink(a.getLink());

			Long pid = a.getPid();
			if (pid == null){
				menus.add(menu);
				map.put(a.getId(), menu);
			}
			else{
				map.get(pid).addSubMenus(menu);
			}
		}
		return menus;
	}
}
