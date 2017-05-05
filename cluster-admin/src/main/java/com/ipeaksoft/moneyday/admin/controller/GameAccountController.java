package com.ipeaksoft.moneyday.admin.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.ipeaksoft.moneyday.admin.util.CommonUtil;
import com.ipeaksoft.moneyday.admin.util.JsonTransfer;
import com.ipeaksoft.moneyday.core.entity.ClusterAccountUdsc;
import com.ipeaksoft.moneyday.core.entity.ClusterGame;
import com.ipeaksoft.moneyday.core.entity.ClusterGameAccount;
import com.ipeaksoft.moneyday.core.service.ClusterAccountUdscService;
import com.ipeaksoft.moneyday.core.service.ClusterGameAccountService;
import com.ipeaksoft.moneyday.core.service.ClusterGameService;
import com.ipeaksoft.moneyday.core.service.HttpService;
import com.ipeaksoft.moneyday.core.util.ClusterPool;

@Controller
@RequestMapping(value = "/game/account")
public class GameAccountController extends BaseController {
	@Autowired
	private ClusterGameService clusterGameService;
	@Autowired
	private ClusterGameAccountService clusterGameAccountService;
	@Autowired
	private ClusterAccountUdscService clusterAccountUdscService;
	@Autowired
	HttpService httpService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@RequestMapping(value = "/published")
	public ModelAndView published(ModelMap map, Principal principal,
			HttpServletRequest request) {
		String game_id = request.getParameter("id");
		ModelAndView mv = new ModelAndView();
		mv.getModelMap().put("game_id", game_id);
		mv.setViewName("/game_account/published");
		return mv;
	}

	@RequestMapping(value = "/manager")
	public String manager(ModelMap map, Principal principal,
			HttpServletRequest request) {
		return "/game_account/manager";
	}

	@RequestMapping(value = "/create")
	public ModelAndView create(ModelMap map, Principal principal,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<ClusterGame> games = clusterGameService.selectAll();
		mv.getModelMap().put("games", games);
		mv.setViewName("/game_account/create");
		return mv;
	}

	@RequestMapping(value = "/update")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("id");
		String gameId = request.getParameter("game_id");
		mv.addObject("id", Long.parseLong(request.getParameter("id")));
		mv.addObject("gameId", Long.parseLong(gameId));
		ClusterGame game = clusterGameService.selectByPrimaryKey(Integer
				.parseInt(gameId));
		ClusterGameAccount clusterGameAccount = clusterGameAccountService
				.selectByPrimaryKey(Integer.parseInt(id));
		mv.getModelMap().put("game", game);
		mv.getModelMap().put("account", clusterGameAccount);
		mv.setViewName("/game_account/update");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/data_load")
	public String data_load(HttpServletRequest request) throws Exception {
		try {
			int start = Integer.parseInt(request.getParameter("start"));// 开始记录数
			int pageSize = Integer.parseInt(request.getParameter("length"));// 每页记录数
			String sEcho = request.getParameter("draw");// 搜索内容
			List<Map<String, Object>> list = clusterGameAccountService
					.selectListGameAccont(start, pageSize);
			int total = clusterGameAccountService.selectNum();
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
	@RequestMapping(value = "/data_publish")
	public String data_publish(HttpServletRequest request) throws Exception {
		try {
			int start = Integer.parseInt(request.getParameter("start"));// 开始记录数
			int pageSize = Integer.parseInt(request.getParameter("length"));// 每页记录数
			String sEcho = request.getParameter("draw");// 搜索内容
			int gameId = Integer.parseInt(request.getParameter("game_id"));
			List<ClusterGameAccount> list = clusterGameAccountService
					.selectByGameId(gameId, start, pageSize);
			int total = clusterGameAccountService.selectByGameIdNum(gameId);
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
	public String add(ClusterGameAccount clusterGameAccount,
			HttpServletRequest request) {
		String result = "{\"status\":true,\"msg\":\"添加成功\"}";
		try {
			List<ClusterGameAccount> lists = clusterGameAccountService
					.checkGames(clusterGameAccount.getGameId(),
							clusterGameAccount.getAccount(),
							clusterGameAccount.getGameServer());
			if (lists.size() > 0) {
				result = "{\"status\":false,\"msg\":\"账号已存在\"}";
			} else {
				clusterGameAccount.setCreateTime(new Date());
				clusterGameAccount.setModifyTime(new Date());
				if (clusterGameAccountService
						.insertSelective(clusterGameAccount) < 1) {
					result = "{\"status\":false,\"msg\":\"添加失败\"}";
				}
			}
		} catch (Exception e) {
			result = "{\"status\":true,\"msg\":\"添加失败\"}";
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/updateInfo")
	public String updateInfo(ClusterGameAccount clusterGameAccount,
			HttpServletRequest request) {
		String result = "{\"status\":true,\"msg\":\"更新成功\"}";
		try {
			// 进行更新操作
			ClusterGameAccount model = clusterGameAccountService
					.selectByPrimaryKey(clusterGameAccount.getId());
			if (model == null) {
				result = "{\"status\":true,\"msg\":\"不存在该对象\"}";
			} else {
				model.setAccount(clusterGameAccount.getAccount());
				model.setPasswd(clusterGameAccount.getPasswd());
				model.setGameServer(clusterGameAccount.getGameServer());
				model.setRunTime(clusterGameAccount.getRunTime());
				model.setModifyTime(new Date());
				List<ClusterGameAccount> lists = clusterGameAccountService
						.checkGames(model.getGameId(), model.getAccount(),
								model.getGameServer());
				if (lists.size() > 0) {
					result = "{\"status\":false,\"msg\":\"账号已存在\"}";
				} else {
					if (clusterGameAccountService
							.updateByPrimaryKeySelective(model) < 1) {
						result = "{\"status\":true,\"msg\":\"更新失败\"}";
					}
				}
			}

		} catch (Exception e) {
			result = "{\"status\":true,\"msg\":\"更新失败\"}";
		}
		return result;
	}

	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/uploadfile")
	public String uploadfile(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model) {
		String filename = file.getOriginalFilename();
		String gameId = request.getParameter("gameId");
		String result = "{\"status\":\"上传成功\",\"msg\":\"" + filename + "\"}";
		try {
			InputStream inp = file.getInputStream();
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);
			int columnAmount = sheet.getRow(0).getPhysicalNumberOfCells();
			List<ClusterGameAccount> clusterGameAccounts = new ArrayList<ClusterGameAccount>();

			if (5 != columnAmount) {
				return "{\"status\":\"上传失败，数据异常\",\"msg\":\"" + filename
						+ "\"}";
			}
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row tempRow = sheet.getRow(i);
				ClusterGameAccount clusterGameAccount = new ClusterGameAccount();
				clusterGameAccount.setGameId(Integer.parseInt(gameId));
				clusterGameAccount.setCreateTime(new Date());
				clusterGameAccount.setModifyTime(new Date());
				clusterGameAccount.setAccount(tempRow.getCell(1)
						.getStringCellValue());
				tempRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				clusterGameAccount.setPasswd(tempRow.getCell(2)
						.getStringCellValue());
				clusterGameAccount.setGameServer(tempRow.getCell(3)
						.getStringCellValue());
				tempRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				clusterGameAccount.setRunTime(Integer.parseInt(tempRow.getCell(
						4).getStringCellValue()));
				clusterGameAccounts.add(clusterGameAccount);
			}
			int num = clusterGameAccountService
					.insertGameAccount(clusterGameAccounts);
			if (num < 1) {
				result = "{\"status\":\"上传失败,检查文件内容\",\"msg\":\"" + filename
						+ "\"}";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			result = "{\"status\":\"上传失败,检查文件内容\",\"msg\":\"" + filename
					+ "\"}";
		} finally {
			return result;
		}

	}

	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public void export(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("game_id");
		List<Map<String, Object>> data = clusterGameAccountService
				.selectAccount(Integer.parseInt(id));
		String gameName = (String) data.get(0).get("name");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(gameName + "账号");
		//CellStyle cellStyle = null; // 小数样式
		// 列头
		XSSFRow row = sheet.createRow(0);
		row.setHeight((short) 300);
		row.createCell(0).setCellValue("游戏名称");
		row.createCell(1).setCellValue("用户名");
		row.createCell(2).setCellValue("密码");
		row.createCell(3).setCellValue("所在服务器");
		row.createCell(4).setCellValue("脚本运行时间");
		//XSSFCell cell = null;
		for (int i = 0; i < data.size(); i++) {
			row = sheet.createRow(i + 1);
			row.setHeight((short) 300);
			row.createCell(0).setCellValue(gameName);
			row.createCell(1).setCellValue((String) data.get(i).get("account"));
			row.createCell(2).setCellValue((String) data.get(i).get("passwd"));
			row.createCell(3).setCellValue(
					(String) data.get(i).get("game_server"));
			row.createCell(4).setCellValue(
					(data.get(i).get("run_time")).toString());
		}
		String filename = gameName + "账号_" + System.currentTimeMillis()
				+ ".xls";// 设置下载时客户端Excel的名称
		filename = CommonUtil.encodeFilename(filename, request);// 处理中文文件名
		// 表示以附件的形式把文件发送到客户端
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);// 设定输出文件头
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
		OutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
		} catch (Exception e) {
		} finally {
			try {
				workbook.close();
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {

			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "/begain")
	public Long begain(HttpServletRequest request) {
		long result = 1001;
		try {
			String id = request.getParameter("id");
			// 添加带执行账号到队列
			ClusterPool clusterPool = ClusterPool.getInstance();
			ClusterGameAccount clusterGameAccount = clusterGameAccountService
					.selectByPrimaryKey(Integer.parseInt(id));
			clusterPool.add(clusterGameAccount);

			ClusterGameAccount model = new ClusterGameAccount();
			model.setId(Integer.parseInt(id));
			model.setStatus("5");
			clusterGameAccountService.updateByPrimaryKeySelective(model);
		} catch (Exception e) {
			result = 1002;
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/stop")
	public Long stop(HttpServletRequest request) {
		long result = 1001;
		try {
			String taskId = request.getParameter("id");
			List<ClusterAccountUdsc> clusterAccountUdsc = clusterAccountUdscService
					.selectByTaskId(Integer.parseInt(taskId));
			String udid = clusterAccountUdsc.get(0).getUdid();
			String url = String.format(stop_script, udid);
			String content = httpService.get(url);

			// content = "{\"errCode\" : 0 ,\"errMsg\" : \"xxx\" }";

			JSONObject json = JSONObject.parseObject(content);
			if (null == json
					|| (null != json.getString("errCode") && !"0".equals(json
							.getString("errCode")))) {
				// 有值就为失败 暂定
				result = 1002;
			} else {
				// 更改状态
				ClusterGameAccount model = new ClusterGameAccount();
				model.setId(Integer.parseInt(taskId));
				model.setStatus("1");
				clusterGameAccountService.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			result = 1002;
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/pause")
	public Long pause(HttpServletRequest request) {
		long result = 1001;
		try {
			String taskId = request.getParameter("id");
			List<ClusterAccountUdsc> clusterAccountUdsc = clusterAccountUdscService
					.selectByTaskId(Integer.parseInt(taskId));
			String udid = clusterAccountUdsc.get(0).getUdid();
			String url = String.format(pause_script, udid);
			String content = httpService.get(url);

			// content = "{\"errCode\" : 0 ,\"errMsg\" : \"xxx\" }";

			JSONObject json = JSONObject.parseObject(content);
			if (null == json
					|| (null != json.getString("errCode") && !"0".equals(json
							.getString("errCode")))) {
				result = 1002;
			} else {
				// 更改状态
				ClusterGameAccount model = new ClusterGameAccount();
				model.setId(Integer.parseInt(taskId));
				model.setStatus("4");
				clusterGameAccountService.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			result = 1002;
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/resume")
	public Long resume(HttpServletRequest request) {
		long result = 1001;
		try {
			String taskId = request.getParameter("id");
			List<ClusterAccountUdsc> clusterAccountUdsc = clusterAccountUdscService
					.selectByTaskId(Integer.parseInt(taskId));
			String udid = clusterAccountUdsc.get(0).getUdid();
			String url = String.format(resume_script, udid);
			String content = httpService.get(url);

			// content = "{\"errCode\" : 0 ,\"errMsg\" : \"xxx\" }";

			JSONObject json = JSONObject.parseObject(content);
			if (null == json
					|| (null != json.getString("errCode") && !"0".equals(json
							.getString("errCode")))) {
				result = 1002;
			} else {
				// 更改状态
				ClusterGameAccount model = new ClusterGameAccount();
				model.setId(Integer.parseInt(taskId));
				model.setStatus("2");
				clusterGameAccountService.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			result = 1002;
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/allbegain")
	public Long allbegain(HttpServletRequest request) {
		long result = 1001;
		try {
			String uwcids = request.getParameter("uwcids");
			String[] uwcid_arry = uwcids.split(":");
			List<Integer> ids = new ArrayList<Integer>();
			for (int i = 0; i < uwcid_arry.length; i++) {
				String id = uwcid_arry[i];
				ids.add(Integer.parseInt(id));
			}
			// 添加带执行账号到队列
			ClusterPool clusterPool = ClusterPool.getInstance();
			List<ClusterGameAccount> models = clusterGameAccountService
					.selectByIds(ids);
			for (ClusterGameAccount model : models) {
				clusterPool.add(model);
				ClusterGameAccount update = new ClusterGameAccount();
				update.setId(model.getId());
				update.setStatus("5");
				clusterGameAccountService.updateByPrimaryKeySelective(update);
			}
		} catch (Exception e) {
			result = 1002;
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/allstop")
	public Long allstop(HttpServletRequest request) {
		long result = 1001;
		try {
			String url = stop_all_scripts;
			String content = httpService.get(url);

			// content = "{\"errCode\" : 0 ,\"errMsg\" : \"xxx\" }";

			JSONObject json = JSONObject.parseObject(content);
			if (null == json
					|| (null != json.getString("errCode") && !"0".equals(json
							.getString("errCode")))) {
				// 有值就为失败 暂定
				result = 1002;
			} else {
				// 更改状态 这个基本不出错就不判断了
				clusterGameAccountService.updateStatus();
			}
		} catch (Exception e) {
			result = 1002;
		}
		return result;
	}

}
