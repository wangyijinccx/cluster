package com.ipeaksoft.moneyday.core.util;

public class Constant {
    // 团博百众的加密KEY
    public static String KEY_TAO800 = "krqzorgswwxjvurd";
    // 勤诚互动的查询接口
    public static String QCHD_QUERY_URL = "http://aff.ihmedia.com.cn/channelinterface/filterIdfa";
    // 运维人员与推广人员的预留ID
    public static String ADMIN_LEVEL0 = "2";
    public static String ADMIN_LEVEL1 = "3";
    public static String ADMIN_LEVEL2 = "4";
    public static String ADMIN_LEVEL3 = "5";
    // 掌通的渠道
    public static String SOURCE_ZHANGTONG = "zhangtong";
    // 团博百众的渠道名称
    public static String SOURCE_TAO800 = "hulianzhe800";
//    // 软猎的的渠道
//    public static String SOURCE_RUANLIE = "RUANLIE";
//    // 行者天下的渠道
//    public static String SOURCE_XINGZHETIANXIA = "XINGZHETIANXIA";
//    // 指盟的渠道
//    public static String SOURCE_ZHIMENG = "ZHIMENG";
    
    // 平台的类型
    public static Integer CLIENTTYPE_HTML = 0;
    public static Integer CLIENTTYPE_WECHAT = 1;
    public static Integer CLIENTTYPE_APPOFFLINE = 3;
    public static Integer CLIENTTYPE_APPONLINE = 4;
    public static Integer CLIENTTYPE_OTHER = 5; // 第三方接入商
    public static Integer CLIENTTYPE_OTHERWECHAT = 6;// 第三方微信接入商
    // 新手任务的APPID
    public static String NEW_TASK_APPID = "1234";
    // 系统版本类型
    public static String VERSION_TYPE_WECHAT = "wechat";
    public static String VERSION_TYPE_ANDROID = "android";
    public static String VERSION_TYPE_IOS = "ios";
    // 任务类型
    public static int TYPE_FAST_TASK = 1;
    public static int TYPE_SEARCH_TASK = 2;
    public static int TYPE_AWARD_TASK = 3;
    
}
