package com.ipeaksoft.moneyday.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ipeaksoft.moneyday.core.entity.ClusterDms;
import com.ipeaksoft.moneyday.core.entity.ClusterGameAccount;
import com.ipeaksoft.moneyday.core.enums.Status;
import com.ipeaksoft.moneyday.core.service.ClusterDmsService;
import com.ipeaksoft.moneyday.core.service.ClusterGameAccountService;
import com.ipeaksoft.moneyday.core.service.HttpService;

@Controller
@RequestMapping(value = "/cs")
public class ClientServerController extends BaseController {
	@Autowired
	private ClusterDmsService clusterDmsService;
	@Autowired
	HttpService httpService;
	@Autowired
	private ClusterGameAccountService clusterGameAccountService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@ResponseBody
	@RequestMapping(value = "/dms_register")
	public String dms_register(String base_url, String name,
			HttpServletRequest request) {
		String result = "{\"errCode\":0,\"errMsg\":\"添加成功\"}";
		try {
			ClusterDms cdms = clusterDmsService.checkDms(name, base_url);
			if (null != cdms) {
				return "{\"id\":" + cdms.getIndicate() + "}";
			}
			ClusterDms clusterDms = new ClusterDms();
			String indicate = UUID.randomUUID().toString().replace("-", ""); // 服务器标示
			clusterDms.setIndicate(indicate);
			clusterDms.setUrl(base_url);
			clusterDms.setName(name);
			// clusterDms.setStatus("normal");
			clusterDms.setModifyTime(new Date());
			clusterDms.setCreateTime(new Date());
			if (clusterDmsService.insertSelective(clusterDms) < 1) {
				result = "{\"errCode\":1001,\"errMsg\":\"添加失败\"}";
			} else {
				result = "{\"id\":" + indicate + "}";
			}
		} catch (Exception e) {
			result = "{\"status\":1002,\"msg\":\"未知异常\"}";
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/script_result", method = (RequestMethod.POST))
	public void script_result(HttpServletRequest request) throws IOException {
		BufferedReader reader = request.getReader();
		char[] buf = new char[512];
		int len = 0;
		StringBuffer contentBuffer = new StringBuffer();
		while ((len = reader.read(buf)) != -1) {
			contentBuffer.append(buf, 0, len);
		}
		String content = contentBuffer.toString();
		if (content == null) {
			content = "";
		}
		JSONObject json = JSONObject.parseObject(content);
		String gameId = json.getString("gameId");
		String account = json.getString("username");
		String server = json.getString("server");
		String result = json.getString("result");
		Map<String, Object> map = clusterGameAccountService.selectGames(gameId,
				account, server);
		String scrStatus = Status.valueOf(result).getKey();
		if (!scrStatus.equals(map.get("status"))) {
			ClusterGameAccount model = new ClusterGameAccount();
			model.setId((Integer) map.get("id"));
			model.setStatus(scrStatus);
			clusterGameAccountService.updateByPrimaryKeySelective(model);
		}
	}
}
