package com.ipeaksoft.moneyday.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ipeaksoft.moneyday.core.entity.ClusterAccountUdsc;
import com.ipeaksoft.moneyday.core.entity.ClusterGame;
import com.ipeaksoft.moneyday.core.entity.ClusterGameAccount;
import com.ipeaksoft.moneyday.core.mapper.ClusterGameAccountMapper;
import com.ipeaksoft.moneyday.core.util.ClusterPool;
import com.ipeaksoft.moneyday.core.util.TestDeom;

@Service
public class ClusterGameAccountService extends BaseService {

	@Autowired
	private ClusterGameAccountMapper clusterGameAccountMapper;
	@Autowired
	private HttpService httpService;
	@Autowired
	private ClusterAccountUdscService clusterAccountUdscService;
	@Autowired
	private ClusterGameService clusterGameService;

	public int insertSelective(ClusterGameAccount record) {
		return clusterGameAccountMapper.insertSelective(record);
	}

	public List<Map<String, Object>> selectListGameAccont(Integer start,
			Integer length) {
		return clusterGameAccountMapper.selectListGameAccont(start, length);
	}

	public int selectNum() {
		return clusterGameAccountMapper.selectNum();
	}

	public List<ClusterGameAccount> selectByGameId(Integer id, Integer start,
			Integer length) {
		return clusterGameAccountMapper.selectByGameId(id, start, length);
	}

	public int selectByGameIdNum(Integer id) {
		return clusterGameAccountMapper.selectByGameIdNum(id);
	}

	public ClusterGameAccount selectByPrimaryKey(Integer id) {
		return clusterGameAccountMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ClusterGameAccount record) {
		return clusterGameAccountMapper.updateByPrimaryKeySelective(record);
	}

	public List<Map<String, Object>> selectAccount(Integer id) {
		return clusterGameAccountMapper.selectAccount(id);
	}

	public int insertGameAccount(List<ClusterGameAccount> list) {
		return clusterGameAccountMapper.insertGameAccount(list);
	}

	@SuppressWarnings("unused")
	public void daTask() {
		Integer taskId;
		String udid = "";
		String script_id = "";
		String username;
		String password;
		String server;
		Integer time;
		String internal_id = "";
		ClusterPool clusterPool = ClusterPool.getInstance();
		List<ClusterGameAccount> list = clusterPool.getBattchList();
		logger.info("adcluster-list:{}", list.toString());
		if (list != null && list.size() > 0) {
			for (ClusterGameAccount clusterGameAccount : list) {
				taskId = clusterGameAccount.getId();
				username = clusterGameAccount.getAccount();
				password = clusterGameAccount.getPasswd();
				server = clusterGameAccount.getGameServer();
				time = (clusterGameAccount.getRunTime()) * 60;

				// 匹配设备
				String url = devices;
				String callback = httpService.get(url);

				// callback = TestDeom.getCall();
				JSONObject json = JSONObject.parseObject(callback);

				if (null == json
						|| (null != json.getString("errCode") && !"0"
								.equals(json.getString("errCode")))) {
					// 接口异常
					clusterPool.add(clusterGameAccount);
					continue;
				} else {

					JSONArray devices = json.getJSONArray("devices");
					for (int i = 0; i < devices.size(); i++) {
						JSONObject item = devices.getJSONObject(i);
						String state = item.getString("state");
						if (null != state && "FREE".equals(state)) {
							udid = item.getString("udid");
							internal_id = item.getString("internalId");
							break;
						}
					}
				}

				// 如果没有空闲设备
				if (StringUtils.isBlank(udid)) {
					clusterPool.add(clusterGameAccount);
					continue;
				}

				// 匹配脚本
				// 获取bundleId gameid
				Integer gameid = clusterGameAccount.getGameId();
				ClusterGame clusterGame = clusterGameService
						.selectByPrimaryKey(gameid);

				String url_scr = String.format(game_scripts,
						clusterGame.getBundleid(), clusterGame.getVersion(),
						clusterGame.getPlatform());

				logger.info("adcluster-url_scr:{}", url_scr);
				String callback_scr = httpService.get(url_scr);

				//callback_scr = TestDeom.getScr();

				JSONObject json_scr = JSONObject.parseObject(callback_scr);
				if (null == json_scr
						|| (null != json_scr.getString("errCode") && !"0"
								.equals(json_scr.getString("errCode")))) {
					// 接口异常
					clusterPool.add(clusterGameAccount);
					continue;
				} else {
					JSONArray scrs = json_scr.getJSONArray("scripts");
					for (int i = 0; i < scrs.size(); i++) {
						// 现在只有一个脚本
						JSONObject item = scrs.getJSONObject(i);
						script_id = item.getString("id");
						break;
					}
				}

				String url_do = String.format(run_script, udid, internal_id,
						script_id, clusterGame.getBundleid(), username,
						password, server, time);
				// 执行任务

				logger.info("adcluster-url_do:{}", url_do);
				String doback = httpService.get(url_do);

				//doback = "{\"errCode\" : 0 ,\"errMsg\" : \"xxx\" }";

				JSONObject json_doback = JSONObject.parseObject(doback);
				if (null == json_doback
						|| (null != json_doback.getString("errCode") && !"0"
								.equals(json_doback.getString("errCode")))) {
					// 接口异常
					clusterPool.add(clusterGameAccount);
					continue;
				}

				// 脚本执行成功，再做记录
				// 保存taskid udid scrid ，如果taskid已存在，则更新 ，每个taskdi只有一条记录
				List<ClusterAccountUdsc> clusterAccountUdscs = clusterAccountUdscService
						.selectByTaskId(taskId);
				if (clusterAccountUdscs.size() > 0) {
					ClusterAccountUdsc clusterAccountUdsc = clusterAccountUdscs
							.get(0);
					clusterAccountUdsc.setTaskid(taskId);
					clusterAccountUdsc.setUdid(udid);
					clusterAccountUdsc.setInternalId(internal_id);
					clusterAccountUdsc.setScriptsId(script_id);
					clusterAccountUdsc.setCreateTime(new Date());
					clusterAccountUdsc.setModifyTime(new Date());
					if (clusterAccountUdscService
							.updateByPrimaryKeySelective(clusterAccountUdsc) < 1) {
						// clusterPool.add(clusterGameAccount);
						// continue;
					}
				} else {
					ClusterAccountUdsc clusterAccountUdsc = new ClusterAccountUdsc();
					clusterAccountUdsc.setTaskid(taskId);
					clusterAccountUdsc.setUdid(udid);
					clusterAccountUdsc.setInternalId(internal_id);
					clusterAccountUdsc.setScriptsId(script_id);
					clusterAccountUdsc.setCreateTime(new Date());
					clusterAccountUdsc.setModifyTime(new Date());
					if (clusterAccountUdscService
							.insertSelective(clusterAccountUdsc) < 1) {
						// clusterPool.add(clusterGameAccount);
						// continue;
					}
				}

				// 更改状态
				ClusterGameAccount model = new ClusterGameAccount();
				model.setId(taskId);
				model.setStatus("2");
				if (this.updateByPrimaryKeySelective(model) < 1) {
					// clusterPool.add(clusterGameAccount);
					// continue;
				}
			}

		}
	}

	public int updateStatus() {
		return clusterGameAccountMapper.updateStatus();
	}

	public List<ClusterGameAccount> selectByIds(List<Integer> ids) {
		return clusterGameAccountMapper.selectByIds(ids);
	}

	public Map<String, Object> selectGames(String gameid, String account,
			String server) {
		return clusterGameAccountMapper.selectGames(gameid, account, server);
	}

	public List<ClusterGameAccount> checkGames(Integer gameid, String account,
			String server) {
		return clusterGameAccountMapper.checkGames(gameid, account, server);
	}
}
