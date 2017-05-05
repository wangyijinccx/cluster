package com.ipeaksoft.moneyday.api.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ipeaksoft.moneyday.api.controller.BaseController;

@Aspect
@Component
public class LogAdvice {
	Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Pointcut("execution(public * com.ipeaksoft.moneyday.api.controller.*.*(..))")
	public void log() {
	}

	@Around("log()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		Object target = joinPoint.getTarget();
		String requestUrl = null;
		String params = null;
		if (target instanceof BaseController){
			BaseController controller = (BaseController) target;
			requestUrl = controller.requestUrl();
			params = controller.params();
		}
		Object result = joinPoint.proceed();
		logger.info("request:{}, param:{}, result:{}", requestUrl, params, result);
		logger.info("request:{}, time:{}", requestUrl, System.currentTimeMillis() - start);
		return result;
	}

	@Before("log()")
	public void before(JoinPoint joinPoint) {
	}

	@After("log()")
	public void after(JoinPoint joinPoint) {
	}

//	@AfterThrowing("log()")
//	public void LogThrowing(JoinPoint joinPoint) {
//		 System.out.println("xxxxxxxxxxxx");
//	}
}
