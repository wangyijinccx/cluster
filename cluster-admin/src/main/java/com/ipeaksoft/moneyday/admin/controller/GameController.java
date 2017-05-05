package com.ipeaksoft.moneyday.admin.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import com.ipeaksoft.moneyday.admin.util.JsonTransfer;
import com.ipeaksoft.moneyday.core.entity.ClusterGame;
import com.ipeaksoft.moneyday.core.service.ClusterGameService;

@Controller
@RequestMapping(value = "/game")
public class GameController extends BaseController {
	@Autowired
	private ClusterGameService clusterGameService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@RequestMapping(value = "/published")
	public String published(ModelMap map, Principal principal,
			HttpServletRequest request) {
		return "/game/published";
	}

	@RequestMapping(value = "/create")
	public String create(ModelMap map, Principal principal,
			HttpServletRequest request) {
		return "/game/create";
	}

	@RequestMapping(value = "/update")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("id");
		mv.addObject("id", Long.parseLong(request.getParameter("id")));
		ClusterGame game = clusterGameService.selectByPrimaryKey(Integer
				.parseInt(id));
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");// 小写的mm表示的是分钟
		String dstr = game.getGameTime();
		try {
			Date date = sdf.parse(dstr);
			game.setGameTime2(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}
		mv.getModelMap().put("game", game);
		mv.setViewName("/game/update");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/data_load")
	public String data_load(HttpServletRequest request) throws Exception {
		try {
			// SimpleDateFormat sdf = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int start = Integer.parseInt(request.getParameter("start"));// 开始记录数
			int pageSize = Integer.parseInt(request.getParameter("length"));// 每页记录数
			String sEcho = request.getParameter("draw");// 搜索内容
			List<Map<String, Object>> list = clusterGameService.selectListGame(
					start, pageSize);
			// for (Map<String, Object> map : list) {
			// map.put("gameTime", sdf.format((Date) map.get("create_time")));
			// }
			int total = clusterGameService.selectNum();
			String result = JsonTransfer.getJsonFromList(sEcho, list);
			result = "{\"draw\":" + sEcho + ",\"recordsTotal\":" + pageSize
					+ ",\"recordsFiltered\":" + total + ",\"data\":" + result
					+ "}";
			return result;
		} catch (Exception ex) {
			throw ex;
		}

	}

	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(ClusterGame clusterGame, HttpServletRequest request) {
		String result = "{\"status\":true,\"msg\":\"添加成功\"}";
		try {
			clusterGame.setCreateTime(new Date());
			clusterGame.setModifyTime(new Date());
			if (clusterGameService.insert(clusterGame) < 1) {
				result = "{\"status\":true,\"msg\":\"添加失败\"}";
			}

		} catch (Exception e) {
			result = "{\"status\":true,\"msg\":\"添加失败\"}";
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/updateInfo")
	public String updateInfo(ClusterGame clusterGame, HttpServletRequest request) {
		String result = "{\"status\":true,\"msg\":\"更新成功\"}";
		try {
			// 进行更新操作
			ClusterGame model = clusterGameService
					.selectByPrimaryKey(clusterGame.getId());
			if (model == null) {
				result = "{\"status\":true,\"msg\":\"不存在该对象\"}";
			} else {
				model.setName(clusterGame.getName());
				model.setGameTime(clusterGame.getGameTime());
				model.setBundleid(clusterGame.getBundleid());
				model.setVersion(clusterGame.getVersion());
				model.setPlatform(clusterGame.getPlatform());
				model.setModifyTime(new Date());
				if (clusterGameService.updateByPrimaryKeySelective(model) < 1) {
					result = "{\"status\":true,\"msg\":\"更新失败\"}";
				}
			}

		} catch (Exception e) {
			result = "{\"status\":true,\"msg\":\"更新失败\"}";
		}
		return result;
	}

}
