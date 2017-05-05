package com.ipeaksoft.moneyday.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnalysisIpUtil {
	private static Logger logger = LoggerFactory.getLogger(AnalysisIpUtil.class);

	/**
	 * 根据Ip获取地址
	 * @param ip
	 * @return country（国家）、area（地区）、province（省份）、city（城市）、county（县城）、isp（网络服务提供商）
	 * @throws IOException
	 */
	@SuppressWarnings("finally")
	public static Map<String, String> getAddress(String ip) throws IOException {

		Map<String, String> map = new HashMap<String, String>();
		String url = "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip;
		logger.debug("get: "+url);
		StringBuffer str = new StringBuffer();
		long time = System.currentTimeMillis();
		try {
			URL u = new URL(url);// 远程url
			URLConnection conn = u.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				str.append(line);
			}
			//获取到json字符串
			String addRessJsonResult = str.toString();
			logger.debug("return: "+addRessJsonResult+", time: "+(System.currentTimeMillis() - time));
			//获取国家
			int start = addRessJsonResult.indexOf("\"country\":\"");
			int end = addRessJsonResult.indexOf("\",\"country_id");
			String country = addRessJsonResult.substring(start, end).replace("\"country\":\"", "")
					.replace("\",\"country_id", "");
			country = decodeUnicode(country);
			//获取地区
			start = addRessJsonResult.indexOf("\"area\":\"");
			end = addRessJsonResult.indexOf("\",\"area_id");
			String area = addRessJsonResult.substring(start, end).replace("\"area\":\"", "")
					.replace("\",\"area_id", "");
			area = decodeUnicode(area);
			//获取省份
			start = addRessJsonResult.indexOf("\"region\":\"");
			end = addRessJsonResult.indexOf("\",\"region_id");
			String region = addRessJsonResult.substring(start, end).replace("\"region\":\"", "")
					.replace("\",\"region_id", "");
			region = decodeUnicode(region);
			//获取城市
			start = addRessJsonResult.indexOf("\"city\":\"");
			end = addRessJsonResult.indexOf("\",\"city_id");
			String city = addRessJsonResult.substring(start, end).replace("\"city\":\"", "")
					.replace("\",\"city_id", "");
			city = decodeUnicode(city);
			//获取县城
			start = addRessJsonResult.indexOf("\"county\":\"");
			end = addRessJsonResult.indexOf("\",\"county_id");
			String county = addRessJsonResult.substring(start, end).replace("\"county\":\"", "")
					.replace("\",\"county_id", "");
			county = decodeUnicode(county);
			//获取isp（网络提供商）
			start = addRessJsonResult.indexOf("\"isp\":\"");
			end = addRessJsonResult.indexOf("\",\"isp_id");
			String isp = addRessJsonResult.substring(start, end).replace("\"isp\":\"", "")
					.replace("\",\"isp_id", "");
			isp = decodeUnicode(isp);
			map.put("country", country);
			map.put("area", area);
			map.put("province", region);
			map.put("city", city);
			map.put("county", county);
			map.put("isp", isp);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			return map;
		}
		
	}

	private static String decodeUnicode(String theString) {

		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}

}
