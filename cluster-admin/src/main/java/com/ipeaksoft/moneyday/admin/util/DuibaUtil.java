package com.ipeaksoft.moneyday.admin.util;

import java.util.Arrays;

import com.ipeaksoft.moneyday.core.sdk.duiba.Constant;
import com.ipeaksoft.moneyday.core.sdk.duiba.CreditAuditParams;
import com.ipeaksoft.moneyday.core.sdk.duiba.CreditTool;
import com.ipeaksoft.moneyday.core.util.HttpRequest;

public class DuibaUtil {

    /**
     * @author: sxy
     * 2015年1月19日 下午3:01:43
     * @param passOrders 成功的订单号，可以批量操作，以“|”隔开
     * @param rejectOrders 失败的订单号，可以批量操作，以“|”隔开
     * @return 
     * String
     * 
     */
    public static String check(String passOrders, String rejectOrders) {
        CreditTool tool = new CreditTool(Constant.APPKEY, Constant.APPSECRET);
        String[] passOrderArray = passOrders.split("\\|");
        String[] rejectOrderArray = rejectOrders.split("\\|");
        CreditAuditParams params = new CreditAuditParams();
        params.setPassOrderNums(Arrays.asList(passOrderArray));//此处的订单号为兑吧的订单号，而非开发者的订单号
        params.setRejectOrderNums(Arrays.asList(rejectOrderArray));//此处的订单号为兑吧的订单号，而非开发者的订单号
        String url = tool.buildCreditAuditRequest(params);
        String result = HttpRequest.sendHttpRequest(url, "GET", "utf-8");
        return result;
    }
    
    /**
     * @param passOrders 成功的订单号，可以批量操作，以“|”隔开
     * @param rejectOrders 失败的订单号，可以批量操作，以“|”隔开
     * @return 
     * String
     * 
     */
    public static String checkWechatOrder(String passOrders, String rejectOrders) {
        CreditTool tool = new CreditTool(Constant.WECHATKEY, Constant.WECHATSECRET);
        String[] passOrderArray = passOrders.split("\\|");
        String[] rejectOrderArray = rejectOrders.split("\\|");
        CreditAuditParams params = new CreditAuditParams();
        params.setPassOrderNums(Arrays.asList(passOrderArray));//此处的订单号为兑吧的订单号，而非开发者的订单号
        params.setRejectOrderNums(Arrays.asList(rejectOrderArray));//此处的订单号为兑吧的订单号，而非开发者的订单号
        String url = tool.buildCreditAuditRequest(params);
        String result = HttpRequest.sendHttpRequest(url, "GET", "utf-8");
        return result;
    }

}