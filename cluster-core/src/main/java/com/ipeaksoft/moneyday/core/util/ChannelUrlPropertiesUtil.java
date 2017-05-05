package com.ipeaksoft.moneyday.core.util;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class ChannelUrlPropertiesUtil {
	private static Properties props;
	static {
		try {
			props = new Properties();
			InputStream fis = ChannelUrlPropertiesUtil.class.getClassLoader()
					.getResourceAsStream("channel-url.properties");
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}
	
	public static String[] getAllKey(){
	    String [] result = new String[props.size()];
	    int i = 0;
	    Enumeration<String> enu = (Enumeration<String>) props.propertyNames();
	    while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            result[i++] = key;
        }
	    return result;
	}

	public static Map<String, String> getAllProperty() {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> enu = (Enumeration<String>) props.propertyNames();
		while (enu.hasMoreElements()) {
			String key = (String) enu.nextElement();
			String value = props.getProperty(key);
			map.put(key, value);
		}
		return map;
	}

	public static void main(String[] args) {
		String [] keys = getAllKey();
		for (String string : keys) {
            System.out.println(string);
        }
	}
}
