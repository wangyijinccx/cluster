package com.ipeaksoft.moneyday.admin.util;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.ipeaksoft.moneyday.admin.util.security.SpringSecurityUtils;
import com.ipeaksoft.moneyday.core.entity.AdminUser;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

public class CommonUtil {
	public final static String USER_SESSION_KEY = "user_session_key";
	
    /**
     * @param before 
     * @param after
     * @return after-befroe 的日期差，无关时间。如今天-昨天=1，今天-明天=-1，今天-今天=0
     * int
     */
    public static int compareDay(Date before, Date after) {
        if (null == before || null == after) {
            return -1;
        }
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(before);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(after);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        return day2 - day1;

    }
    //取得登录用户
    public static AdminUser getSessionUser(HttpServletRequest request){
    	SpringSecurityUtils.getCurrentUserName();
    	AdminUser user=(AdminUser)request.getSession().getAttribute(USER_SESSION_KEY);
    	return user;
    }
    /** 
     * 设置下载文件中文件的名称 
     *  
     * @param filename 
     * @param request 
     * @return 
     */  
    public static String encodeFilename(String filename, HttpServletRequest request) {  
      /** 
       * 获取客户端浏览器和操作系统信息 
       * 在IE浏览器中得到的是：User-Agent=Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; Alexa Toolbar) 
       * 在Firefox中得到的是：User-Agent=Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.7.10) Gecko/20050717 Firefox/1.0.6 
       */  
      String agent = request.getHeader("USER-AGENT");  
      try {  
        if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {  
          String newFileName = URLEncoder.encode(filename, "UTF-8");  
          newFileName = StringUtils.replace(newFileName, "+", "%20");  
          if (newFileName.length() > 150) {  
            newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");  
            newFileName = StringUtils.replace(newFileName, " ", "%20");  
          }  
          return newFileName;  
        }  
        if ((agent != null) && (-1 != agent.indexOf("Mozilla")))  
          return MimeUtility.encodeText(filename, "UTF-8", "B");  
    
        return filename;  
      } catch (Exception ex) {  
        return filename;  
      }  
    } 

}
