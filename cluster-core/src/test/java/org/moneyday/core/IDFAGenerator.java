package org.moneyday.core;

import java.util.Random;

public class IDFAGenerator {
	final static String[] a = {"0","1","2","3","4","5","6","7","8","9",
			"A","B","C","D","E","F"};
	static Random random = new Random();
	public static String gen(){
		String result = "";
		for (int i = 0;i < 8;i++){
			result += a[random.nextInt(16)];
		}
		result += "-";
		for (int i = 0;i < 4;i++){
			result += a[random.nextInt(16)];
		}
		result += "-";
		for (int i = 0;i < 4;i++){
			result += a[random.nextInt(16)];
		}
		result += "-";
		for (int i = 0;i < 4;i++){
			result += a[random.nextInt(16)];
		}
		result += "-";
		for (int i = 0;i < 12;i++){
			result += a[random.nextInt(16)];
		}
		return result;
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		for (int i = 0 ;i< 400000 ; i++){
			gen();
		}
		System.out.println(System.currentTimeMillis()-start);
	}
}
