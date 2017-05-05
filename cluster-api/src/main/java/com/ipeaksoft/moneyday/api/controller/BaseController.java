package com.ipeaksoft.moneyday.api.controller;

import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    protected Logger logger = null;
    protected String className = "";

    public BaseController(){
        className = getClass().getName();
        logger = LoggerFactory.getLogger(className);
    }
    
	public String requestUrl(){
		return request.getRequestURI();
	}
	
	public String params() {
		StringBuffer buffer = new StringBuffer();
		Enumeration<String> names = request.getParameterNames();

		while (names.hasMoreElements()) {
			String name = names.nextElement();
			if ("currentProcess".equals(name)){
				continue;
			}
			buffer.append(name + "=");
			String[] values = request.getParameterValues(name);
			String value = null;
			if (values.length == 1) {
				value = values[0];
			}
			else{
				for (String v: values){
					value = value + ","+v;
				}
			}
			buffer.append(value);
			if (names.hasMoreElements()){
				buffer.append("&");
			}
		}
		return buffer.toString();
	}
	
    String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    protected String getIP() {
       Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
       String IP = request.getRemoteAddr();
       String forwarded = request.getHeader("x-forwarded-for");

       if (forwarded != null) {
           forwarded = forwarded.split(",", 2)[0];
           if (pattern.matcher(forwarded).matches()) {
               return forwarded;
           }
       }
       if (pattern.matcher(IP).matches()) {
           return IP;
       } else {
           logger.warn("IP is not valid.[IP=" + IP + "]");
           return "";
       }
   }
}
