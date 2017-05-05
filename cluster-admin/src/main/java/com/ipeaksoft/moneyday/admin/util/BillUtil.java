package com.ipeaksoft.moneyday.admin.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ipeaksoft.moneyday.core.entity.UserCash;
import com.ipeaksoft.moneyday.core.service.UserAdsService;
import com.ipeaksoft.moneyday.core.service.UserFastService;

public class BillUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    // 封装用户的收益信息
    public void getAwardByReq(HttpServletRequest request,UserFastService userFastService, UserAdsService userAdsService) {
        String id = request.getParameter("id");
        String mobile = request.getParameter("mobile");
        request.setAttribute("id", id);
        request.setAttribute("mobile", mobile);
        logger.info("mobile: " + mobile+", id: "+id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mobile", mobile);
        // 查询用户的快速累计收益、常规累计收益
        Integer fastaward = userFastService.getAwardByMobile(map);
        Integer adsaward = userAdsService.getAwardByMobile(map);
        request.setAttribute("fastaward", (null == fastaward) ? 0 : fastaward);
        request.setAttribute("adsaward", (null == adsaward) ? 0 : adsaward);
    }
    
    // 封装最终的JSONObject返回值
    public JSONObject formatResult(String draw, int total, Object object, int size) {
        JSONObject result = new JSONObject();
        result.put("draw", draw);   
        result.put("recordsTotal", size);
        result.put("recordsFiltered", total);
        result.put("data", object);
        return result;
    }
    
    
    // 封装用户的订单信息到JSONArray中
    public void formatUserBillData(JSONObject jsonObject, UserCash userCash, int istatus) {
        String day = DateUtil.date2Str("yyyy-MM-dd HH:mm:ss", userCash.getCreateTime());
        jsonObject.put("day", day);
        String description = userCash.getDescription();
        description = (description.contains(")")) ? description.replaceAll("\\(|\\)", "<br/>") : description;
        jsonObject.put("description", description);
        jsonObject.put("ordernum", userCash.getOrdernum());
        jsonObject.put("totalcredits", userCash.getTotalcredits());
        String status = (0 == istatus) ? "待审核" : (1 == istatus) ? "处理中" : (2 == istatus) ? "推迟审核" : (3 == istatus) ? "审核异常" : (4 == istatus) ? "充值失败" : (9 == istatus) ? "充值成功" : "其他";
        jsonObject.put("status", status);
        String operator = userCash.getOperator();
        operator = (null == operator) ? "" : operator;
        jsonObject.put("operator", operator);
        String operateResult = (4 == istatus) ? userCash.getOperateResult() : "";
        jsonObject.put("operateResult", operateResult);
        String operatetime = DateUtil.date2Str("yyyy-MM-dd HH:mm:ss", userCash.getOperateTime());
        jsonObject.put("operatetime", operatetime);
        jsonObject.put("id", userCash.getId());
    }
    
    public Map<String, Object> getWhereMap(HttpServletRequest request) {
        int start = Integer.parseInt(request.getParameter("start"));//开始记录数
        int pageSize = Integer.parseInt(request.getParameter("length"));//每页记录数
        String dir = request.getParameter("order[0][dir]");
        String from = request.getParameter("start_date");
        String to = request.getParameter("end_data");
        logger.info("[data_load_checking][from]" + from);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if (null != from)
            paramMap.put("from", from);
        if (null != to)
            paramMap.put("to", to);
        paramMap.put("dir", dir);
        paramMap.put("start", start);
        paramMap.put("size", pageSize);
        return paramMap;
    }
}
