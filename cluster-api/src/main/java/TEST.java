import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ipeaksoft.moneyday.core.entity.TaskAuto;
import com.ipeaksoft.moneyday.core.util.HttpRequest;


public class TEST {

	public static void main(String[] args) throws IOException {
		HashMap<String, Object> form = new HashMap<>();
		form.put("appId", "708985992");
		form.put("channel", "79");
		form.put("idfa", "00192E92-9F4F-490B-8E8C-EDCDF632D858");
		String url = "http://aff.ihmedia.com.cn/channelinterface/filterIdfa";
		String result = HttpRequest.postForm(url, form);
		System.out.println(result);
	}
	
	public static void testQueryIdfaBatch()throws IOException{
		String url = "http://ads.i43.com/api/queryidfabatch";
//		String url = "http://localhost:8080/moneyday-api/queryidfa";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("appid", "1052978978");
		params.put("partner", "qianlu");
		params.put("idfa", "043C6ED4-D24B-405A-8FDD-8080CE8F5533,E0116DF6-1706-4F52-8CF9-CAAB6611439D,A22FBF6B-4CC2-4CD1-8705-8B9F5CA7EF49,C6A4C099-090C-4AA2-9466-AA2A38D0CDF6,67BC27EA-17B0-4817-B5CC-612827FAB48B,D2FDADA5-6AAE-44B9-8CAE-3E325FD20AFC,E6C81761-5930-49CE-857C-FCD9CA43C9E0,AE9BC741-FEDA-4900-9BE6-015499F66F81,0841C709-043F-45CA-8870-73EFA3A82C15,3B6FEB44-D5B4-4B14-B882-2BD4E2B43F2A,62838BD2-086C-4A19-BAF8-93F7D737A34D,FC255568-C27F-4778-BC1B-404AE350176E,BD40B7D2-26F2-491C-8559-4CD6C311D8BC");
		String result = HttpRequest.postForm(url, params);
		System.out.println(result);
	}
	
	public static void testQueryIdfa()throws IOException{
		String url = "http://ads.i43.com:8082/api/queryidfa";
//		String url = "http://localhost:8080/moneyday-api/queryidfa";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("appid", "1234");
		params.put("partner", "test");
		params.put("idfa", "abcd");
		String result = HttpRequest.postForm(url, params);
		System.out.println(result);
		result = HttpRequest.postForm(url, params);
		System.out.println(result);
	}

	public static void testSyncIdfa(){
		String url = "http://localhost:8080/moneyday-api/syncIdfa?appid=1234&idfa=abcd";
		String result = HttpRequest.sendHttpRequest(url, "GET", "utf-8");
		System.out.println(result);
	}
	
	public static void testBaidu()throws IOException{
		String url = "http://baitongsdk.baidu.com/baitong/index.php?r=InterfaceBTAction&m=get_api";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("timestamp", System.currentTimeMillis()/1000);
		params.put("host_app_name", "xiguashop");
		params.put("action_type", "1");
		
		params.put("action", "show_list");
		params.put("product_version", "1");
		params.put("imei", "043C6ED4-D24B-405A-8FDD-8080CE8F5533,E0116DF6-1706-4F52-8CF9-CAAB6611439D,A22FBF6B-4CC2-4CD1-8705-8B9F5CA7EF49,C6A4C099-090C-4AA2-9466-AA2A38D0CDF6,67BC27EA-17B0-4817-B5CC-612827FAB48B,D2FDADA5-6AAE-44B9-8CAE-3E325FD20AFC,E6C81761-5930-49CE-857C-FCD9CA43C9E0,AE9BC741-FEDA-4900-9BE6-015499F66F81,0841C709-043F-45CA-8870-73EFA3A82C15,3B6FEB44-D5B4-4B14-B882-2BD4E2B43F2A,62838BD2-086C-4A19-BAF8-93F7D737A34D,FC255568-C27F-4778-BC1B-404AE350176E,BD40B7D2-26F2-491C-8559-4CD6C311D8BC");
		params.put("os_version", "9.1");
		params.put("brand", "iphone");
		params.put("model", "6S");
		params.put("resolution", "1334 x 750");		
		params.put("running_app_list", "6S");
		
		params.put("secret", "");
		params.put("package_name", "");
		params.put("api_key", "110022d");
		params.put("clienttype", "api");
		
		params.put("ad_type", "1");
		params.put("platform", "ios");
		params.put("api_version", "20");
		params.put("page", "1");
		params.put("page_size", "20");
		params.put("user_ip", "221.220.249.80");
		
		
		String result = HttpRequest.postForm(url, params);
		System.out.println(result);

	}

	public static void testYeahMobi(){
		
		String a = 
				"{"+
		    "\"pkgname\": \"id668876977\","+
		    "\"name\": \"App Download - 三剑豪- iOS(CN) -Non-incentive-Private\","+
		    "\"preview_url\": \"https://itunes.apple.com/cn/app/san-jian-hao-dong-zuo-wu-xia3d/id668876977?mt=8\","+
		    "\"type\": \"ios\","+
		    "\"title\": \"三剑豪 - 动作武侠3D网游神作\","+
		    "\"description\": \"风际游戏荣誉出品，2015非玩不可的3D-ARPG武侠手游。陈妍希倾情代言，鼎力推荐；和国民女侠一起拯救你手中的江湖！ 瓦剌不灭，何以为家？年度唯一3D武侠大作《三剑豪》3.0版本“逐鹿天下”震撼上线。全新侠客“绝”正式登场，身怀旷世绝技，势必颠覆江湖格局；新开跨服联盟战一触即发，跨越全区全服，让你率领战队问鼎荣耀之巅！更有家园系统、婚姻、拍卖行、泡温泉等特色交互式玩法让快意恩仇的江湖在这个冬天更加激情！【游戏特色】「诗韵国风 醉美视觉盛宴」Unity官方推荐标杆产品，端游级美术品质。精致还原气势磅礴的燧峰营，小桥流水的百花谷，给你最真实的江湖！ 「三侠一体 群侠自由玩转」独创三侠一体系统，百位绝世大侠陪你浪迹江湖。侠客可帮你冲锋陷阵，也能赋予你绝世技能。百种侠客组合，千种技能搭配随性创造，充分满足你的探索欲望！ 更有史诗级神秘侠客，静待有缘人！ 「深度社交 打造“真”网游」 游戏采用先进实时演算技术，真正实现玩家间即时互动。各门派相互配合、侠客鼎力相助，实时组队副本、即时比武切磋等深度交互玩法，让流畅打斗贯穿始终，战斗永不停歇！「百人同屏 血战华山之巅」游戏引入30V30阵营对决玩法，正邪势力上演殊死较量。运筹帷幄，冲锋陷阵，在华山群峰寸间体验横扫千军、破阵杀敌，畅享团队策略竞技带来的激情！问鼎巅峰还可获得至尊豪华道具奖励，为你铭记荣光！「原创剧情 还原大明江湖」 东方武侠原创剧情，经典侠客穿越时空与玩家共谋“圣武天宝”。从“土木堡之变”到“京城保卫战”，在国仇家恨中诠释“侠之大者”。「极致震撼 爆破式打击感」 拳拳到肉，真正爆破式打击感；刀刀见血，暴力美学激情迸发。让你一秒爱上战斗，爽快无法停手！ 官方论坛：http://bbs.3jianhao.com 官方微信：sanjianhaoledou官方唯一客服QQ：800032124官方QQ群：183936065\","+
		    "\"offer_description\": \"<p>无标题文档</p>\n\n<p><strong>Conversion User Flow:</strong></p>\n\n<p>1. User is redirected on app&nbsp;store to download the application</p>\n\n<p>2. User has to open the application</p>\n\n<p><strong>GEO</strong>:CN</p>\n\n<p><strong>Device</strong>:iOS</p>\n\n<p><strong>Carriers</strong>:&nbsp;All carrier</p>\n\n<p><strong>Daily Cap: 100</strong></p>\n\n<p><strong>Push Notification traffic allowed</strong>:No</p>\n\n<p><strong>Incentivized Traffic allowed</strong>:NO</p>\n\n<p><strong>Email Traffic allowed</strong>:&nbsp;No</p>\n\n<p><strong>Adult traffic allowed</strong>:&nbsp;No</p>\n\n<p><strong>Search traffic allowed</strong>:&nbsp;Yes</p>\n\n<p><strong>SMS Traffic allowed</strong>:&nbsp;No</p>\n\n<p><strong>Wifi traffic allowed</strong>:&nbsp;Yes</p>\n\n<p>Display traffic allowed: Yes</p>\n\n<p>Facebook traffic allowed: Yes</p>\n\n<p>KPI: D2 retention rate reaches 25% +, and has user&nbsp;Acquisition</p>\n\n<p>For RR&gt;=25%,&nbsp;user&nbsp;Acquisition is not 0， full payment.</p>\n\n<p>For 25% &lt;RR&lt;10%, 50% payment</p>\n\n<p>For RR&lt;10%, no payment.</p>\n\n<p>&nbsp;</p>\","+
		    "\"category\": ["+
		    "    \"App Download-iOS\","+
		    "    \"App Download-Game\""+
		    "],"+
		    "\"tracklink\": \"http://global.ymtracking.com/trace?offer_id=112848&aff_id=102460\","+
		    "\"countries\": ["+
		    "    \"CN\""+
		    "],"+
		    "\"payout\": \"2.970\","+
		    "\"platform\": ["+
		    "    \"iOS\""+
		    "],"+
		    "\"traffic\": ["+
		    "    \"Search traffic allowed\","+
		    "    \"Wifi traffic allowed\","+
		    "    \"Display traffic allowed\","+
		    "    \"In - App Display traffic allowed\","+
		    "    \"Facebook traffic allowed\""+
		    "],"+
		    "\"creative_link\": ["+
		    "    \"http://uploads.yeahmobi.com/offer_file/thumb_7d74df900ae74a0b8667516b962b3bfa.zip\""+
		    "],"+
		    "\"remaining_daily_cap\": 50"+
		"}";
		JSONObject item = JSONObject.parseObject(a);
		String type = item.getString("type");
		String payout = item.getString("payout");
		JSONArray array = item.getJSONArray("platform");
		if ("ios".equals(type)&&array.toJSONString().toLowerCase().indexOf("ios")>=0){
			if (payout!=null && !payout.toLowerCase().equals("dynamic")){
				System.out.println("ddd");
			}
		}
	}

	public static void testAvazu(){
		String url = "http://api.c.avazunativeads.com/s2s?sourceid=18639&incent=2&os=ios&country=CN&pagenum=100&market=apple";
		String result = HttpRequest.sendHttpRequest(url, "GET", "utf-8");
		System.out.println(result);
	}

}
