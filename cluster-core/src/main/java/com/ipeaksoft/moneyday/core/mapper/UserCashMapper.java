package com.ipeaksoft.moneyday.core.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserCash;
import com.ipeaksoft.moneyday.core.entity.UserCashOrder;

public interface UserCashMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCash record);

    int insertSelective(UserCash record);

    UserCash selectByPrimaryKey(Long id);
    
    int selectCountByStatus(Date date);

    int updateByPrimaryKeySelective(UserCash record);

    int updateByPrimaryKey(UserCash record);

    UserCash selectByOrder(String orderid);
    
    List<UserCashOrder> selectRechargedByDay(Date date); // 查询某个日期之后的充值订单的信息

    List<UserCashOrder> selectOrderByDay(Date date); // 查询某个日期之后的审核订单的信息

    List<UserCash> selectPageByDay(Map<String, Object> map);// 查询当天的交易记录并分页

    List<UserCash> selectPageByUser(Map<String, Object> map);
    
    List<UserCash> selectPageByOperate(Map<String, Object> map);
    
    List<UserCash> selectPageByStatus(Map<String, Object> map);
    
    List<UserCash> selectPageByType(Map<String, Object> map);

    int countPageByDay(Map<String, Object> map);

    int countPageByUser(Map<String, Object> map);
    
    int countPageByOperate(Map<String, Object> map);

    int countPageByStatus(Map<String, Object> map);
    
    int countPageByType(Map<String, Object> map);

    List<UserCash> selectAllByCredits(Map<String, Object> map);
    
    Integer getAllAlipayMoney();

    Integer getAllPhoneMoney();

    Integer getAllMoney();
}