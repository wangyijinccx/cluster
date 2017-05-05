package com.ipeaksoft.moneyday.api.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;




/**
 * <p>
 * Title: 时间和日期的工具类
 * </p>
 * <p>
 * Description: DateUtil类包含了标准的时间和日期格式，以及这些格式在字符串及日期之间转换的方法
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014 advance,Ince. All Rights Reserved
 * </p>
 * <p>
 * Company: advance,Inc.
 * </p>
 * 
 * @author advance
 * @version 1.0
 */

public class DateUtil {
	// ~ Static fields/initializers
	// =============================================

	private static String datePattern = "yyyy-dd-MM";

	private static String timePattern = datePattern + " HH:MM";

	// ~ Methods
	// ================================================================

	/**
	 * Return default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static final String date2Str(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static final String date2Str(String pattern, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(pattern);
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			return null;
		}

		return (date);
	}

	public static final Date str2Date(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			return null;
		}

		return (date);
	}

	/**
	 * This method returns the current date 
 in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(datePattern);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			System.out.print("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(datePattern, aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   ParsePosition pos = new ParsePosition(0);
		   Date strtodate = formatter.parse(strDate, pos);
		   return strtodate;
	}

	// 日期格式转换成时间戳
	public static long getTimeStamp(String pattern, String strDate) {
		long returnTimeStamp = 0;
		Date aDate = null;
		try {
			aDate = convertStringToDate(pattern, strDate);
		} catch (ParseException pe) {
			aDate = null;
		}
		if (aDate == null) {
			returnTimeStamp = 0;
		} else {
			returnTimeStamp = aDate.getTime();
		}
		return returnTimeStamp;
	}

	// 获取当前日期的邮戳
	public static long getNowTimeStamp() {
		long returnTimeStamp = 0;
		Date aDate = null;
		try {
			aDate = convertStringToDate("yyyy-MM-dd HH:mm:ss", getNowDateTime());
		} catch (ParseException pe) {
			aDate = null;
		}
		if (aDate == null) {
			returnTimeStamp = 0;
		} else {
			returnTimeStamp = aDate.getTime();
		}
		return returnTimeStamp;
	}

	/**
	 * 得到格式化后的系统当前日期
	 * 
	 * @param strScheme
	 *            格式模式字符串
	 * @return 格式化后的系统当前时间，如果有异常产生，返回空串""
	 * @see java.util.SimpleDateFormat
	 */
	public static final String getNowDateTime(String strScheme) {
		String strReturn = null;
		Date now = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(strScheme);
			strReturn = sdf.format(now);
		} catch (Exception e) {
			strReturn = "";
		}
		return strReturn;
	}

	public static final String getNowDateTime() {
		String strReturn = null;
		Date now = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			strReturn = sdf.format(now);
		} catch (Exception e) {
			strReturn = "";
		}
		return strReturn;
	}

	/**
	 * 转化日期格式"MM/dd/YY、MM.dd.YY、MM-dd-YY、MM/dd/YY"，并输出为正常的格式yyyy-MM-dd
	 * 
	 * @param strDate
	 *            待转换的日期格式
	 * @return 格式化后的日期，如果有异常产生，返回空串""
	 * @see java.util.SimpleDateFormat
	 */
	public static final String convertNormalDate(String strDate) {
		String strReturn = null;
		// 先把传入参数分格符转换成java认识的分格符
		String[] date_arr = strDate.split("\\.|\\/|\\-");
		try {
			if (date_arr.length == 3) {
				if (date_arr[2].length() != 4) {
					String nowYear = getNowDateTime("yyyy");
					date_arr[2] = nowYear.substring(0, 2) + date_arr[2];
				}
				strReturn = DateUtil.getDateTime("yyyy-MM-dd",
						convertStringToDate(combineStringArray(date_arr, "/")));
			}

		} catch (Exception e) {
			return strReturn;
		}
		return strReturn;
	}

	/**
	 * 将字符串数组使用指定的分隔符合并成一个字符串。
	 * 
	 * @param array
	 *            字符串数组
	 * @param delim
	 *            分隔符，为null的时候使用""作为分隔符（即没有分隔符）
	 * @return 合并后的字符串
	 * @since 0.4
	 */
	public static final String combineStringArray(String[] array, String delim) {
		int length = array.length - 1;
		if (delim == null) {
			delim = "";
		}
		StringBuffer result = new StringBuffer(length * 8);
		for (int i = 0; i < length; i++) {
			result.append(array[i]);
			result.append(delim);
		}
		result.append(array[length]);
		return result.toString();
	}

	public static final int getWeekNum(String strWeek) {
		int returnValue = 0;
		if (strWeek.equals("Mon")) {
			returnValue = 1;
		} else if (strWeek.equals("Tue")) {
			returnValue = 2;
		} else if (strWeek.equals("Wed")) {
			returnValue = 3;
		} else if (strWeek.equals("Thu")) {
			returnValue = 4;
		} else if (strWeek.equals("Fri")) {
			returnValue = 5;
		} else if (strWeek.equals("Sat")) {
			returnValue = 6;
		} else if (strWeek.equals("Sun")) {
			returnValue = 0;
		} else if (strWeek == null) {
			returnValue = 0;
		}

		return returnValue;
	}

	/**
	 * 得到格式化后的指定日期
	 * 
	 * @param strScheme
	 *            格式模式字符串
	 * @param date
	 *            指定的日期值
	 * @return 格式化后的指定日期，如果有异常产生，返回空串""
	 * @see java.util.SimpleDateFormat
	 */
	public static final String getDateTime(Date date, String strScheme) {
		String strReturn = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(strScheme);
			strReturn = sdf.format(date);
		} catch (Exception e) {
			strReturn = "";
		}

		return strReturn;
	}

	/**
	 * 获取日期
	 * 
	 * @param timeType
	 *            时间类型，譬如：Calendar.DAY_OF_YEAR
	 * @param timenum
	 *            时间数字，譬如：-1 昨天，0 今天，1 明天
	 * @return 日期
	 */
	public static final Date getDateFromNow(int timeType, int timenum) {
		Calendar cld = Calendar.getInstance();
		cld.set(timeType, cld.get(timeType) + timenum);
		return cld.getTime();
	}

	/**
	 * 获取日期
	 * 
	 * @param timeType
	 *            时间类型，譬如：Calendar.DAY_OF_YEAR
	 * @param timenum
	 *            时间数字，譬如：-1 昨天，0 今天，1 明天
	 * @param format_string
	 *            时间格式，譬如："yyyy-MM-dd HH:mm:ss"
	 * @return 字符串
	 */
	public static final String getDateFromNow(int timeType, int timenum,
			String format_string) {
		if ((format_string == null) || (format_string.equals("")))
			format_string = "yyyy-MM-dd HH:mm:ss";
		Calendar cld = Calendar.getInstance();
		Date date = null;
		DateFormat df = new SimpleDateFormat(format_string);
		cld.set(timeType, cld.get(timeType) + timenum);
		date = cld.getTime();
		return df.format(date);
	}

	/**
	 * 获取当前日期的字符串
	 * 
	 * @param format_string
	 *            时间格式，譬如："yyyy-MM-dd HH:mm:ss"
	 * @return 字符串
	 */
	public static final String getDateNow(String format_string) {
		if ((format_string == null) || (format_string.equals("")))
			format_string = "yyyy-MM-dd HH:mm:ss";
		Calendar cld = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format_string);
		return df.format(cld.getTime());
	}

	/**
	 * 比较两个日期的大小
	 * 
	 * @param begingDate
	 * @param endDate
	 * @return
	 */
	public static boolean compareDate(String begingDate, String endDate) {
		boolean boo = true;
		Date begin = null;
		Date end = null;
		String format = "yyyy/MM/dd";
//		if(begingDate.indexOf("-") != -1) {
//			format = "yyyy-MM-dd";
//		}
//		if(endDate.indexOf("-") != -1) {
//			format = "yyyy-MM-dd";
//		}
		DateFormat df = new SimpleDateFormat(format);
		if (null == begingDate || "".equals(begingDate)) {
			boo = false;
			return boo;
		}
		if (null == endDate || "".equals(endDate)) {
			boo = false;
			return boo;
		}
		try {
			begin = df.parse(begingDate);
			end = df.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (begin.compareTo(end) >= 0) {
			boo = false;
		}
		return boo;
	}
	
	public static boolean compareDate(String begingDate, String endDate, String format) {
		boolean boo = true;
		Date begin = null;
		Date end = null;
		if(format.isEmpty()){
			format = format = "yyyy/MM/dd";
		}
//		if(begingDate.indexOf("-") != -1) {
//			format = "yyyy-MM-dd";
//		}
//		if(endDate.indexOf("-") != -1) {
//			format = "yyyy-MM-dd";
//		}
		DateFormat df = new SimpleDateFormat(format);
		if (null == begingDate || "".equals(begingDate)) {
			boo = false;
			return boo;
		}
		if (null == endDate || "".equals(endDate)) {
			boo = false;
			return boo;
		}
		try {
			begin = df.parse(begingDate);
			end = df.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (begin.compareTo(end) >=0) {
			boo = false;
		}
		return boo;
	}
	//考虑到本金最后一天全部还的情况
	public static boolean compareDate2(String begingDate, String endDate, String format) {
		boolean boo = true;
		Date begin = null;
		Date end = null;
		if(format.isEmpty()){
			format = format = "yyyy/MM/dd";
		}
//		if(begingDate.indexOf("-") != -1) {
//			format = "yyyy-MM-dd";
//		}
//		if(endDate.indexOf("-") != -1) {
//			format = "yyyy-MM-dd";
//		}
		DateFormat df = new SimpleDateFormat(format);
		if (null == begingDate || "".equals(begingDate)) {
			boo = false;
			return boo;
		}
		if (null == endDate || "".equals(endDate)) {
			boo = false;
			return boo;
		}
		try {
			begin = df.parse(begingDate);
			end = df.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (begin.compareTo(end) >0) {
			boo = false;
		}
		return boo;
	}
	
	public static boolean nowBeincluded(String now,String start,String end, String format){
		if (StringUtils.isBlank(format)) {
			format = "yyyy/MM/dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date nowTime = null;
		Date dataBegin = null;
		Date dataEnd = null;
		try {
			nowTime = sdf.parse(now);
			dataBegin = sdf.parse(start);
			dataEnd = sdf.parse(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (nowTime.getTime() > dataBegin.getTime() && nowTime.getTime() < dataEnd.getTime()) {
			return true;
		}
		return false;
	}
	/**
	 * 一个日期是否包含在另一个日期范围之中
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean date1IsContainDate2(String startDate, String endDate) {
		startDate = startDate.replaceAll("-", "/");
		endDate = endDate.replaceAll("-", "/");
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		if (null == startDate || "".equals(startDate)) {
			return false;
		}
		if (null == endDate || "".equals(endDate)) {
			return false;
		}
		Date begin = null;
		Date end = null;
		try {
			begin = df.parse(startDate);
			end = df.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (begin.after(end)) {
			return false;
		}
		return true;
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @param aDate
	 * @return
	 */
	public static final String getCurrentTimeMillis(Date aDate) {
		String returnValue = String.valueOf(System.currentTimeMillis());
		return returnValue;
	}

	/**
	 * 根据系统当前年获得年度列表
	 * @return
	 */
	public static List<String> getAnnualList () { 
		List<String> list =  new ArrayList<String>();
		Date date = Calendar.getInstance().getTime();
		String strDate =  new SimpleDateFormat("yyyy").format(date);
		int year = Integer.parseInt(strDate);
		list.add(String.valueOf(year+1));
		for (int i = year-6; i<year+1;i++ ) {
			list.add(String.valueOf(year));
			year--;
		}
		return list;
	}
	/**
	 * 根据系统当前年获得年度列表
	 * @return
	 */
	public static List<Map<String,String>> getReverseAnnual() { 
		List<Map<String,String>> list =  new ArrayList<Map<String,String>>();
		Date date = Calendar.getInstance().getTime();
		String strDate =  new SimpleDateFormat("yyyy").format(date);
		int year = Integer.parseInt(strDate);
		for (int i = year-5; i<year+1;i++ ) {
			Map<String,String> yearMap= new HashMap<String,String>();
			yearMap.put("code", String.valueOf(year));
			yearMap.put("name", String.valueOf(year));
			list.add(yearMap);
			year--;
		}
		//Collections.sort(list);
		//Collections.reverse(list);
		return list;
	}
	
	/**
	 * 获取系统当前时间的timestamp
	 * @return
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	/**
	 * 比较两个日期的是否一致
	 * 
	 * @param begingDate
	 * @param endDate
	 * @return
	 */
	public static boolean compareYear(String begingDate, String endDate) {
		boolean boo = true;
		Date begin = null;
		Date end = null;
		DateFormat df = new SimpleDateFormat("yyyy");
		if (null == begingDate || "".equals(begingDate)) {
			boo = false;
			return boo;
		}
		if (null == endDate || "".equals(endDate)) {
			boo = false;
			return boo;
		}
		try {
			begin = df.parse(begingDate);
			end = df.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (begin.compareTo(end) != 0) {
			boo = false;
		}
		return boo;
	}
	public static String parse(Date d){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		String dateStr = sdf.format(d);
		return dateStr;
	}
	/**
	 * 判断一个日期是否在指定日期范围之内
	 * @param now
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean nowBeincluded(String now,String start,String end){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	      Date nowTime=null;
	      Date dataBegin=null;
	      Date dataEnd=null;
		try {
			nowTime = sdf.parse(now);
			dataBegin = sdf.parse(start); 
			dataEnd = sdf.parse(end); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (nowTime.getTime() >= dataBegin.getTime() &&
			nowTime.getTime()<=dataEnd.getTime()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断某一天是否是否假日
	 * @param holiday
	 * @param day
	 * @return
	 */
	public static boolean holidayIsContiansDay (List<String> holiday,String day) {
		if (holiday.contains(day)) {
			return true;
		}
		return false;
	} 
	
	/**
	 * 此方法被checkDate()调用，比较两个日期的大小
	 * @param begingDate
	 * @param endDate
	 * @return
	 */
	public static boolean checkDate(String begingDate, String endDate) {
		boolean boo = true;
		Date begin = null;
		Date end = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (null == begingDate || "".equals(begingDate)) {
			boo = false;
			return boo;
		}
		if (null == endDate || "".equals(endDate)) {
			boo = false;
			return boo;
		}
		try {
			begin = df.parse(begingDate);
			end = df.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (begin.compareTo(end) >= 0) {
			boo = false;
		}
		return boo;
	}

	/**
	 * 获取系统当前日期
	 * @return
	 */
	public static String getTodayStr() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String todayAsString = df.format(new Date());
		return todayAsString;
	}
	
	/**
	 * 获取系统当前当前年的第一天
	 * @return
	 */
	public static String getFirstDay4CurrentYear() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String todayAsString = df.format(new Date());
		todayAsString =  todayAsString+"-01-01";
		return todayAsString;
	}
	
	/**
	 * 
	 * @param intDayOfWeek
	 * @return
	 */
	public static String intMatchWeek(int intDayOfWeek) {
		String strDayOfWeek="";
		switch(intDayOfWeek) {
			case 1:strDayOfWeek="周一";
			break;
			case 2:strDayOfWeek="周二";
			break;
			case 3:strDayOfWeek="周三";
			break;
			case 4:strDayOfWeek="周四";
			break;
			case 5:strDayOfWeek="周五";
			break;
		}
		return strDayOfWeek;
	}
	
	/**
	 * 
	 * @param strDayOfWeek
	 * @return
	 */
	public static String strMatchWeek(String strDayOfWeek){
		String []strWeek= {"mon","tues","wed","thur","fri"};
		String []strWeek1= {"周一","周二","周三","周四","周五"};
		String []intWeek= {"1","2","3","4","5"};
		String returnWeek="";
		for (int i=0;i<strWeek.length;i++) {
			if (strDayOfWeek.equals(strWeek[i]) || strDayOfWeek.equals(strWeek1[i])) {
				returnWeek = intWeek[i];
				break;
			}
		}
		return returnWeek;
	}
	
	
	/**
	 * <p>
	 * Description:取得当下时戳的字符串格式，"yyyy-MM-dd HH:mm:ss.SSS"
	 * </p>
	 * 
	 * @author zlh
	 * @date 2014年8月18日 
	 * @return
	 * @throws ParseException 
	 */
	public static Timestamp getNowTimestamp(){
		String stampStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
				.format(System.currentTimeMillis());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Timestamp ts=null;
		try {
			ts = new Timestamp(format.parse(stampStr).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}
	
	public static int getDays(String start, String end) throws Exception{
		int days = 0;
		if(start.isEmpty() || end.isEmpty()){
			throw new  Exception("开始或结束时间为空。");
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long to = df.parse(end).getTime();
		long from = df.parse(start).getTime();
		
		days = (int) ((to - from) / (1000 * 60 * 60 * 24));
		return days;
	}
	
	public static String getOnlyTime(Date date){
		String dateStr=getDateTime(date,timePattern);
		return dateStr.substring(11, 16);
	}
	
	public static void main(String[] str){
		Date now = new Date();
		System.out.print(getOnlyTime(now));
	}
	
}