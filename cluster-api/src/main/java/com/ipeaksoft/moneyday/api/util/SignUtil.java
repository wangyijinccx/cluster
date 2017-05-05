package com.ipeaksoft.moneyday.api.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class SignUtil {
	private static final String KEY_YOUMI = "837e97f9ef5b509a";
	private static final String KEY_DOMOB = "8f861029";
	private static final String KEY_LIMEI = "8c120b743f5079d2aa81966255c018b3";

	public static boolean verifySignYouMi(String query){
		return verifySign(query, KEY_YOUMI);
	}
	public static boolean verifySignDomob(String query){
		return verifySign(query, KEY_DOMOB);
	}
	public static boolean verifySignLIMEI(String query){
		return verifySign(query);
	}

	private static boolean verifySign(String query, String key){
		String urlSign = "";
        try {
            String[] params = query.split("&");
            Map<String, String> map = new HashMap<String, String>();
            for (String each : params) {
                String name = each.split("=")[0];
                String value;
                try {
                    value = URLDecoder.decode(each.split("=")[1], "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    value = "";
                }
                if ("sign".equals(name)) {
                    urlSign = value;
                } else {
                    map.put(name, value);
                }
            }
            if ("".equals(urlSign)) {
                return false;
            } else {
                String signature = getSignature((HashMap<String, String>) map, key);
                return urlSign.equals(signature);
            }
        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
	}
	
	public static String getSignature(HashMap<String, String> params, String key) throws IOException {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<String, String>(params);
 
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            basestring.append(param.getKey()).append("=").append(param.getValue());
        }
        basestring.append(key);
        //System.out.println(basestring.toString());
        // 使用MD5对待签名串求签
        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(basestring.toString().getBytes("UTF-8"));
        } catch (GeneralSecurityException ex) {
            throw new IOException(ex);
        }
        // 将MD5输出的二进制结果转换为小写的十六进制
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        return sign.toString();
    }
	
	private static boolean verifySign(String query){
		String urlSign = "";
        try {
            String[] params = query.split("&");
            Map<String, String> map = new HashMap<String, String>();
            for (String each : params) {
                String name = each.split("=")[0];
                String value = each.split("=")[1];
//                try {
//                    value 
//                } catch (UnsupportedEncodingException e) {
//                    value = "";
//                }
                if ("sign".equals(name)) {
                    urlSign = URLDecoder.decode(value, "UTF-8");;
                } else {
                    map.put(name, value);
                }
            }
            if ("".equals(urlSign)) {
                return false;
            } else {
                String signature = getSignatureLIMEI((HashMap<String, String>) map);
                return urlSign.equals(signature);
            }
        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
	}
	
	public static String getSignatureLIMEI(HashMap<String, String> params) throws IOException {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<String, String>(params);
 
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            basestring.append(param.getKey()).append(param.getValue());
        }
        return HMACSHA1(basestring.toString());
    }
	private static String HMACSHA1(String data) {
		byte[] byteHMAC = null;
		try {
			Mac mac = Mac.getInstance("HmacSHA1");
			SecretKeySpec spec = new SecretKeySpec(KEY_LIMEI.getBytes(), "HmacSHA1");
			mac.init(spec);
			byteHMAC = mac.doFinal(data.getBytes());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException ignore) {
		}
		String oauth = new BASE64Encoder().encode(byteHMAC);
		return oauth;
	}

}
