package com.ipeaksoft.moneyday.core.util;

public class TestDeom {
	public static String getCall() {
		String call = "{\"devices\" : [{\"udid\" : \"udid1\", "
				+ "\"internalId\" : \"interid1\", "
				+ "\"platform\" : \"iOS\", " + "\"version\" : \"4.4.2\", "
				+ "\"model\" : \"iPhone4\", " + "\"state\" : \"BUSY\", "
				+ "\"name\" : \"name1\", " + "\"emulator\" : true ,"
				+ "\"vendor\" : \"Google\", " + "\"scriptId\" : \"scrname1\", "
				+ "\"hostIp\" : \"192.168.1.1\", "
				+ "\"scriptState\" : \"ERROR\","
				+ "\"scriptErrorCode\" : 1001 ,"
				
				+ "\"gameId\" : \"budd1\", "
				+ "\"username\" : \"account141\","
				+ "\"server\" : \"aly41\" ,"
								
				+ "\"scriptErrorMsg\" : \"异常\" " + "},"
				+ "{\"udid\" : \"udid2\", " + "\"internalId\" : \"interid2\", "
				+ "\"platform\" : \"iOS\", " + "\"version\" : \"4.4.2\", "
				+ "\"model\" : \"iPhone4\", " + "\"state\" : \"BUSY\", "
				+ "\"name\" : \"name2\", " + "\"emulator\" : true ,"
				+ "\"vendor\" : \"Google\", " + "\"scriptId\" : \"scrname2\", "
				+ "\"hostIp\" : \"192.168.1.1\", "
				+ "\"scriptState\" : \"RUNNING\"," + "\"scriptErrorCode\" : 1002 ,"
				
				+ "\"gameId\" : \"budd1\", "
				+ "\"username\" : \"account141\","
				+ "\"server\" : \"aly41\" ,"
				
				+ "\"scriptErrorMsg\" : \"正常\" " + "},"
				+ "{\"udid\" : \"udid3\", " + "\"internalId\" : \"interid3\", "
				+ "\"platform\" : \"iOS\", " + "\"version\" : \"4.4.2\", "
				+ "\"model\" : \"iPhone4\", " + "\"state\" : \"FREE\", "
				+ "\"name\" : \"name3\", " + "\"emulator\" : true ,"
				+ "\"vendor\" : \"Google\"," + "\"hostIp\" : \"192.168.1.1\", "

				/*
				  + "\"script\" : \"scrname\", " +
				  "\"scriptState\" : \"ERROR\"," +
				  "\"scriptErrorCode\" : 1001 ," +
				  "\"scriptErrorMsg\" : \"异常\" "
				
*/
				+ "}"

				+ "]" + "}";
		return call;
	}

	public static String getScr() {
		String call = "{" + "\"scripts\":[" + "{" + "	\"id\" : \"xxx\" ,"
				+ "\"name\" : \"xxx\" ," + "	\"desc\" : \"xxx\" ,"
				+ "\"language\" : \"python\"," + "\"version\" : \"1.0.0\","
				+ "\"games\" : [ " + "	{" + "\"id\" : \"xxx\" ,"
				+ "\"name\":\"xx\"," + "\"platform\":\"iOS\","
				+ "\"minVersion\" : \"xxx\" ," + "\"maxVersion\" : \"xxx\""
				+ "}" + "]" + "}" + "]" + "}";
		return call;
	}

	public static void main(String args[]) {
		System.out.println(TestDeom.getCall());
		System.out.println(TestDeom.getScr());
	}
}
