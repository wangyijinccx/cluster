package com.ipeaksoft.moneyday.core.util;

import org.apache.commons.lang.StringUtils;

public class IPUtils {

	/**
	 * 私有IP：
	 * A类 10.0.0.0-10.255.255.255 
	 * B类 172.16.0.0-172.31.255.255 
	 * C类 192.168.0.0-192.168.255.255 
	 * 当然，还有127这个网段是环回地址
	 **/
	private static final long aBegin = getIpNum("10.0.0.0");
	private static final long aEnd = getIpNum("10.255.255.255");
	private static final long bBegin = getIpNum("172.16.0.0");
	private static final long bEnd = getIpNum("172.31.255.255");
	private static final long cBegin = getIpNum("192.168.0.0");
	private static final long cEnd = getIpNum("192.168.255.255");

	public static boolean isInnerIP(String ipAddress) {
		if (StringUtils.isBlank(ipAddress)){
			return true;
		}
		boolean isInnerIp = false;
		long ipNum = getIpNum(ipAddress);
		isInnerIp = isInner(ipNum, aBegin, aEnd)
				|| isInner(ipNum, bBegin, bEnd) 
				|| isInner(ipNum, cBegin, cEnd)
				|| ipAddress.equals("127.0.0.1");
		return isInnerIp;
	}

	private static long getIpNum(String ipAddress) {
		String[] ip = ipAddress.split("\\.");
		long a = Integer.parseInt(ip[0]);
		long b = Integer.parseInt(ip[1]);
		long c = Integer.parseInt(ip[2]);
		long d = Integer.parseInt(ip[3]);
		long ipNum = a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
		return ipNum;
	}

	private static boolean isInner(long userIp, long begin, long end) {
		return (userIp >= begin) && (userIp <= end);
	}
}
