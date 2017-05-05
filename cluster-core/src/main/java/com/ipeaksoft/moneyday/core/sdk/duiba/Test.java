package com.ipeaksoft.moneyday.core.sdk.duiba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

        public static void main(String[] args) {
                CreditTool tool=new CreditTool(Constant.APPKEY, Constant.APPSECRET);
                String url=tool.buildCreditAutoLoginRequest("1", 100);
                //此url即为免登录url
            System.out.println(url);
//            String url = "http://192.168.199.159:8080/moneyday-api/duiba/geturl?uid=sxy&credits=100&appkey=vGETtKDMs7T2mibZZ762Tke69jS";
//            String url = "http://192.168.199.159:8080/moneyday-api/duiba/geturl";
//            String url = "http://www.baidu.com";
//            String url = "http://123.56.109.73:8081/api/duiba/geturl?uid=1&credits=98287800&appkey=vGETtKDMs7T2mibZZ762Tke69jS";
            HashMap<String, String> map = new HashMap<String, String>();
//            map.put("uid", "sxy");
//            map.put("credits", "100");
//            map.put("appkey", "vGETtKDMs7T2mibZZ762Tke69jS");
//            String content = Test.getResponseByPostMethod(url,"utf-8",map);
            String content = Test.getResponseByGetMethod(url);
            System.out.println("content = " + content); 
            
        }

    private static MultiThreadedHttpConnectionManager connectionManager    = new MultiThreadedHttpConnectionManager();
    private static final Logger                       log                  = LoggerFactory.getLogger(Test.class);
    //连接超时时间
    private static int                                connectionTimeOut    = 15000;
    private static int                                socketTimeOut        = 15000;
    private static int                                readTimeOut          = 20000;
    private static int                                maxConnectionPerHost = 5;
    private static int                                maxTotalConnections  = 40;

    // 标志初始化是否完成的flag
    private static boolean                            initialed            = false;

    // 初始化ConnectionManger的方法
    public static void SetPara() {
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
        //        connectionManager.get
        initialed = true;
    }

    public static String getResponseByGetMethod(String url) {
        return getResponseByGetMethod(url, "GB2312");
    }

    /**
     * 根据GET方法得到页面的返回值
     *
     * @param url 目的地址
     * @param charSet   编码格式
     * @return String   内容
     */
    public static String getResponseByGetMethod(String url, String charSet) {
        HttpClient client = new HttpClient(connectionManager);
        if (!initialed) {
            SetPara();
        }
        GetMethod getMethod = new GetMethod(url);
        getMethod.getParams().setSoTimeout(readTimeOut);
        //        System.out.println("timeout = " + client.getHttpConnectionManager().getParams().getConnectionTimeout());
        StringBuffer contentBuffer = new StringBuffer();
        try {
            int statusCode = client.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                InputStream in = getMethod.getResponseBodyAsStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, getMethod.getResponseCharSet()));
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    contentBuffer.append(inputLine);
                    contentBuffer.append("/n");
                }
                in.close();
                return convertStringCode(contentBuffer.toString(), getMethod.getResponseCharSet(), charSet);
            } else {
                log.error("访问页面出错 返回:  " + getMethod.getStatusLine());
            }

        } catch (IOException e) {
            //            System.out.println("e.getMessage() = " + e.getMessage());
            log.error("请求该页面出现异常:" + e.getMessage());
        } finally {
            getMethod.releaseConnection();
        }
        return "";
    }

    /**
     * 设置POST提交的参数
     * @param method    POST方法
     * @param parmMap   参数映射
     */
    private static void setRequestBody(PostMethod method, HashMap parmMap) {
        Set keySet = parmMap.keySet();
        Iterator it = keySet.iterator();
        List parmList = new ArrayList();
        while (it.hasNext()) {
            String key = (String) it.next();
            String value = (String) parmMap.get(key);
            //设置参数
            NameValuePair nameValuePair = new NameValuePair(key, value);
            parmList.add(nameValuePair);
        }
        method.setRequestBody((NameValuePair[]) parmList.toArray(new NameValuePair[parmList.size()]));
    }

    public static String getgetResponseByPostMethod(String url, HashMap parmMap) {
        return getResponseByPostMethod(url, "gb2312", parmMap);
    }

    /**
     * 以POST方法得到网页内容
     * @param url       目的地址
     * @param charSet   编码格式
     * @param parmMap   post 提交的参数，key 参数名称,velue 参数名,均为String类型
     * @return String   返回内容
     */
    public static String getResponseByPostMethod(String url, String charSet, HashMap parmMap) {
        HttpClient client = new HttpClient(connectionManager);
        if (!initialed) {
            SetPara();
        }
        PostMethod postMethod = new PostMethod(url);
        if (parmMap != null) {
            setRequestBody(postMethod, parmMap);
        }
        postMethod.getParams().setSoTimeout(readTimeOut);
        StringBuffer contentBuffer = new StringBuffer();
        try {
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
                InputStream in = postMethod.getResponseBodyAsStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, postMethod.getResponseCharSet()));
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    contentBuffer.append(inputLine);
                    contentBuffer.append("/n");
                }
                in.close();
                return convertStringCode(contentBuffer.toString(), postMethod.getResponseCharSet(), charSet);
            } else {
                log.error("访问页面出错 返回:  " + postMethod.getStatusLine());
            }

        } catch (IOException e) {
            log.error("请求该页面出现异常:" + e.getMessage());
        } finally {
            postMethod.releaseConnection();
        }
        return "";
    }

    /**
     * 转换编码格式
     * @param source        源字符串
     * @param srcEncode     源字符串编码格式
     * @param destEncode    需要转换的编码格式
     * @return String
     */
    private static String convertStringCode(String source, String srcEncode, String destEncode) {
        if (source != null && !"".equals(source)) {
            try {
                return new String(source.getBytes(srcEncode), destEncode);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        } else {
            return "";
        }
    }

}
