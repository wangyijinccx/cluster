package com.ipeaksoft.moneyday.core.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class HttpService extends BaseService {

    CloseableHttpClient httpclient;

    @PostConstruct
    void init() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //cm.setMaxTotal(15);
        cm.setMaxTotal(500);
        cm.setDefaultMaxPerRoute(300);
        RequestConfig config = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();
        httpclient = HttpClients.custom().setDefaultRequestConfig(config).setConnectionManager(cm).build();
        logger.info("Httpclient init...!");
    }

    @PreDestroy
    void destroy() {
        try {
            httpclient.close();
            logger.info("Httpclient destroy!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String postJson(String url, String json) {
    	long time = System.currentTimeMillis();
        CloseableHttpResponse response = null;
        String result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseStr = EntityUtils.toString(entity, "UTF-8");
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            	result = responseStr;
            }
        } catch (Exception e) {
            logger.error("ERROR:", e);
        } finally {
            try {
                if (response != null)
                    response.close();
            } catch (IOException e) {
            }
        }
        logger.info("POST to:{}, content:{}, result:{}, time:{}", url, json, result, (System.currentTimeMillis()-time));
        return result;
    }

    public String post(String url, Map<String, String> postParams) {
    	long time = System.currentTimeMillis();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Iterator<Map.Entry<String, String>> iter = postParams.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        CloseableHttpResponse response = null;
        String result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseStr = EntityUtils.toString(entity, "UTF-8");
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                result = responseStr;
                result = result.replaceAll("(?:\r\n|\n|\r)*$", "");
            }
        } catch (Exception e) {
            logger.error("ERROR:{}", url, e);
        } finally {
            try {
                if (response != null)
                    response.close();
            } catch (IOException e) {
            }
        }
        logger.info("POST to:{}, content:{}, result:{}, time:{}", url, postParams, result, (System.currentTimeMillis()-time));
        return result;
    }
    
    public String get(String url) {
    	long time = System.currentTimeMillis();
        CloseableHttpResponse response = null;
        String result = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseStr = EntityUtils.toString(entity, "UTF-8");
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                result = responseStr;
            }
        } catch (Exception e) {
            logger.error("ERROR:{}", url, e);
        } finally {
            try {
                if (response != null)
                    response.close();
            } catch (IOException e) {
            }
        }
        logger.info("GET to:{}, result:{}, time:{}", url, result, (System.currentTimeMillis()-time));
        return result;
    }
}
