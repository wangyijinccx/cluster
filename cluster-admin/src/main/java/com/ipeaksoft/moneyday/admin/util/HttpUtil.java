package com.ipeaksoft.moneyday.admin.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	
	@SuppressWarnings("unused")
	public static long get(String url) {
		long time = System.currentTimeMillis();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String result = null;
		CloseableHttpResponse response = null;
		try {
			HttpGet httpGet = new HttpGet(url);
			response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String responseStr = EntityUtils.toString(entity, "UTF-8");
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = responseStr;
			}
		} catch (Exception e) {
		} finally {
			try {
				if (response != null)
					response.close();
			} catch (IOException e) {
			}
		}
		return System.currentTimeMillis() - time;
	}
	
}
