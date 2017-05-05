package com.ipeaksoft.moneyday.api.interceptor;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

public class CommonExceptionResolver implements HandlerExceptionResolver {

    protected static Logger logger = null;

    public CommonExceptionResolver() {
        logger = LoggerFactory.getLogger(getClass().getName());
    }
    
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
		long start = System.currentTimeMillis();
        logger.error("Exception SimpleName: {}, message:{}", ex.getClass().getSimpleName(), ex.getMessage());
        logger.error("ERROR:", ex);
        ex.printStackTrace();

        ModelAndView mv = new ModelAndView();  
        //设置响应头  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");
		JSONObject result = new JSONObject();
		result.put("result", 0);
		result.put("msg", "error");
        try {
			response.getWriter().write(result.toString());
		} catch (IOException e) {
		}
		logger.info("request:{}, param:{}, result:{}", request.getRequestURI(), params(request), result);
		logger.info("request:{}, time:{}", request.getRequestURI(), System.currentTimeMillis() - start);
        return mv;
	}
    
	public String params(HttpServletRequest request) {
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

}
