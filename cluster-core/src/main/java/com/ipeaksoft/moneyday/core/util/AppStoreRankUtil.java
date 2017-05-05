package com.ipeaksoft.moneyday.core.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ipeaksoft.moneyday.core.appstore.entity.AppInfo;
import com.ipeaksoft.moneyday.core.appstore.entity.Ranking;

/**
 * 备注，榜单分两部分：榜单分类+收费类型(收费，免费，畅销) 榜单分类中36代表总榜， 收费类型中0代表付费，1代表免费， 2代表畅销， 如果36.1代表总榜单中免费榜
 * 
 * @author Administrator
 *
 */
@Service
public class AppStoreRankUtil {
	private Logger logger = LoggerFactory.getLogger(AppStoreRankUtil.class);
	
	//根据appid查询appinfo
	private final static String APPINFO_BYAPPID = "http://rank.appstore.i43.com/appinfo?appid=${appid}";
//	//根据分类和排名查询appinfo
//	private final static String APPINFO_BYRANK = "http://rank.appstore.i43.com/appinfobyrank?cat=${cat}&rank=${rank}";
	//根据appid查询排名
	private final static String APPRANK_BYAPPID = "http://rank.appstore.i43.com/rankbycat?appid=${appid}";

	private final static String global_appstore_assign_url = "http://rank.appstore.i43.com/assign?source=moneyday-weixin";
	private final static String global_appstore_assign_del_url = "http://rank.appstore.i43.com/delassign?source=moneyday-weixin";

	public AppRank assign() {
		AppRank appRank = null;
		try {
			String json = HttpRequest.sendHttpRequest(global_appstore_assign_url, "GET", "utf-8");
			if (StringUtils.isNotBlank(json)){
				appRank = JSONObject.parseObject(json, AppRank.class);
			}
		} catch (Exception e) {
			logger.error("ERROR:", e);
			return null;
		}

		return appRank;
	}

	public void assignDel(String appid) {
		HttpRequest.sendHttpRequest(global_appstore_assign_del_url+"&appid="+appid, "GET", "utf-8");
	}

	/**
	 * 通过指定appid，获取当前app排名
	 * @param appid
	 * @return
	 */
	public int queryRankByApp(String appid, String cat) {
		int rank = 0;
		String url = APPRANK_BYAPPID.replace("${appid}", appid);
		String json = HttpRequest.sendHttpRequest(url, "GET", "utf-8");
		JSONObject obj = JSONObject.parseObject(json);
		if (obj != null){
			rank = obj.getInteger("rank");
		}
		return rank;
	}
//
//	private AppRank queryAppInfo(String cat, int rank) {
//		String url = APPINFO_BYRANK.replace("${cat}", cat).replace("${rank}", "" + rank);
//		String json = HttpRequest.sendHttpRequest(url, "GET", "utf-8");
//		if (StringUtils.isNotBlank(json)){
//			AppRank app = JSONObject.parseObject(json, AppRank.class);
//			return app;
//		}
//		return null;
//	}
	
	public AppInfo queryAppInfo(String appid) {
		String url = APPINFO_BYAPPID.replace("${appid}", appid);
		String json = HttpRequest.sendHttpRequest(url, "GET", "utf-8");
		if (StringUtils.isNotBlank(json)){
			AppInfo app = JSONObject.parseObject(json, AppInfo.class);
			return app;
		}
		return null;
	}


//	private AppRank convert(AppInfo appInfo, RankParam param){
//		if (appInfo == null){
//			return null;
//		}
//		AppRank rank = new AppRank();
//		rank.setCat(param.getCat());
//		rank.setPos(param.getRank());
//		rank.setTab(1);
//		rank.setAppid(appInfo.getAppid().intValue());
//		rank.setName(appInfo.getName());
//		rank.setPrice(appInfo.getPrice().intValue());
//		rank.setSize(appInfo.getSize().intValue());
//		rank.setUrl(appInfo.getUrl());
//		rank.setIcons(appInfo.getIcons().split("\\|"));
//		Date date = new Date();
//		rank.setCreateTime(date);
//		rank.setModifyTime(date);
//		return rank;
//	}
	
	public static void main(String[] args){
		String appid = "333206289";
		String url = APPRANK_BYAPPID.replace("${appid}", appid);
		String json = HttpRequest.sendHttpRequest(url, "GET", "utf-8");
		List<Ranking> list = JSONObject.parseArray(json, Ranking.class);
		System.out.println(JSONObject.toJSONString(list));

	}
}
