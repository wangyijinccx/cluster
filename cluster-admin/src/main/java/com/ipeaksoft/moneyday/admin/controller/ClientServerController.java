package com.ipeaksoft.moneyday.admin.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ipeaksoft.moneyday.core.enums.Status;
import com.ipeaksoft.moneyday.core.service.ClusterAccountUdscService;
import com.ipeaksoft.moneyday.core.service.ClusterDmsService;
import com.ipeaksoft.moneyday.core.service.ClusterGameAccountService;
import com.ipeaksoft.moneyday.core.service.HttpService;
import com.ipeaksoft.moneyday.core.util.TestDeom;

@Controller
@RequestMapping(value = "/cserver")
public class ClientServerController extends BaseController {
	@Autowired
	private ClusterDmsService clusterDmsService;
	@Autowired
	HttpService httpService;
	@Autowired
	private  ClusterAccountUdscService clusterAccountUdscService; 
	@Autowired
	private ClusterGameAccountService clusterGameAccountService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@RequestMapping(value = "/publish")
	public String publish(ModelMap map, Principal principal,
			HttpServletRequest request) {
		return "/monitor/published";
	}

	@ResponseBody
	@RequestMapping(value = "/getDevices")
	public String getDevices(HttpServletRequest request) {
		//int start = Integer.parseInt(request.getParameter("start"));// 开始记录数
		int pageSize = 0;// 每页记录数
		String sEcho = request.getParameter("draw");// 搜索内容
		String url = devices;
		String callback = httpService.get(url);
		
		callback  = TestDeom.getCall();
		
		
		JSONObject json = JSONObject.parseObject(callback);
		JSONArray devices = json.getJSONArray("devices");
		for (int i = 0; i < devices.size(); i++) {
			JSONObject item = devices.getJSONObject(i);
			String state = item.getString("state");
			if("BUSY".equalsIgnoreCase(state)){
				String gameId = item.getString("gameId");
				String account = item.getString("username");
				String server = item.getString("server");
				Map<String, Object> map = clusterGameAccountService
						.selectGames(gameId, account, server);
				String gameName = (String) map.get("name");
				item.put("gameName", gameName);
				String scriptState = item.getString("scriptState");
				String scrStatus = Status.valueOf(scriptState).getKey();
				item.put("scrStatus", scrStatus);
				item.put("id", (Integer) map.get("id"));
			}
		}
		int total = 0;
		String result = devices.toString();
		result = "{\"draw\":" + sEcho + ",\"recordsTotal\":" + pageSize
				+ ",\"recordsFiltered\":" + total + ",\"data\":" + result + "}";
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/reboot")
	public Long reboot(HttpServletRequest request) {
		long result = 1001;
		try {
			String udid  = request.getParameter("udid");
			String url = String.format(reboot_device, udid);
		    String content = httpService.get(url);
		    
		    //content = "{\"errCode\" : 0 ,\"errMsg\" : \"xxx\" }";
		    
		    JSONObject json =  JSONObject.parseObject(content);
		    if (null == json
					|| (null != json.getString("errCode") && !"0".equals(json
							.getString("errCode")))) {
		    	result = 1002;
		    }
		} catch (Exception e) {
			result = 1002;
		}
		return result;
	}
}
