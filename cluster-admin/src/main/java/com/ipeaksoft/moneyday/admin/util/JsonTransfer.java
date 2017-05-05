/**Title: Ext Transfer
*Description: Data Format
*Copyright: Copyright (c) 2009-2011 by 滕济可
*Company:tengjk
*
* @author tengjike
* @version 1.0
*/
package com.ipeaksoft.moneyday.admin.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class JsonTransfer 
{
	/**
	 * 通过List生成XML数据
	 * @param recordTotal 记录总数，不一定与beanList中的记录数相等
	 * @param beanList 包含bean对象的集合
	 * @return 生成的XML数据
	 */
	public static String getXmlFromList(long recordTotal , List beanList) {
		Total total = new Total();
		total.setResults(recordTotal);
		List results = new ArrayList();
		results.add(total);
		results.addAll(beanList);
		XStream sm = new XStream(new DomDriver());
		for (int i = 0; i < results.size(); i++) {
			Class c = results.get(i).getClass();
			String b = c.getName();
			String[] temp = b.split("\\.");
			sm.alias(temp[temp.length - 1], c);
		}
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"	+ sm.toXML(results);
		return xml;
	}
	/**
	 * 通过List生成XML数据
	 * @param beanList 包含bean对象的集合
	 * @return 生成的XML数据
	 */
	public static String getXmlFromList(List beanList){
		return getXmlFromList(beanList.size(),beanList);
	}
	/**
	 * 通过List生成JSON数据
	 * @param recordTotal 记录总数，不一定与beanList中的记录数相等
	 * @param beanList 包含bean对象的集合
	 * @return 生成的JSON数据
	 */
	public static String getJsonFromList(String draw,long recordTotal , List beanList){
		TotalJson total = new TotalJson();
		total.setDraw(draw);
		total.setRecordsFiltered(recordTotal);
		total.setData(beanList);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());
		//jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"data"});  
		String json=JSONArray.fromObject(beanList,jsonConfig).toString();
		return json; 
	}
	
	/**
	 * 通过List生成JSON数据
	 * @param recordTotal 记录总数，不一定与beanList中的记录数相等
	 * @param beanList 包含bean对象的集合
	 * @return 生成的JSON数据
	 */
	public static String getJsonFromList1(long recordTotal , List beanList){
		TotalJson total = new TotalJson();
		total.setData(beanList);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		//jsonConfig.setExcludes(new String[]{"items"});  
		JSONObject JsonObject = JSONObject.fromObject(total,jsonConfig);
		return JsonObject.toString(); 
	}
	/**
	 * 通过List生成JSON数据
	 * @param beanList 包含bean对象的集合
	 * @return 生成的JSON数据
	 */
	public static String getJsonFromList(String draw,List beanList){
		return getJsonFromList(draw,beanList.size(),beanList);
	}
	/**
	 * 通过bean生成JSON数据
	 * @param bean bean对象
	 * @return 生成的JSON数据
	 */
	public static String getJsonFromBean(Object bean){
		JSONObject JsonObject = JSONObject.fromObject(bean);
		return JsonObject.toString();
	}
	
	/**
     * 通过JSON生成bean数据
     * @param Object jason, Class<T> clazz
     * @return List<T>生成的bean数据
     */
	public static <T extends Object> List<T> getBeanFromJason(Object jason, Class<T> clazz)
	{
	    List<T> reList = new ArrayList<T>();
        JSONArray jsonArr = JSONArray.fromObject(jason);
        for(int i=0; i<jsonArr.size(); i++)
        {
            JSONObject jsonObj = jsonArr.getJSONObject(i); 
            T to = (T)JSONObject.toBean(jsonObj, clazz);
            reList.add(to);
        }
        return reList;
	}
}
