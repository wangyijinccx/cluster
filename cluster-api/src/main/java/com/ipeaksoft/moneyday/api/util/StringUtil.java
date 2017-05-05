package com.ipeaksoft.moneyday.api.util;

public class StringUtil {

    public static int compareStr(String str,String x[]){
        int suffix=-1;//记录字符串数组的下标
        for(int i=0;i<x.length;i++){
            if(str.equals(x[i]))
                suffix=i;
        }
        return suffix;
    }
}
