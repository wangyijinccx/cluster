package com.ipeaksoft.moneyday.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.UserCash;
import com.ipeaksoft.moneyday.core.entity.UserCashOrder;
import com.ipeaksoft.moneyday.core.mapper.UserCashMapper;

@Service
public class UserCashService extends BaseService {
    
    @Autowired
    private UserCashMapper userCashMapper;
    
    public int deleteByPrimaryKey(Long id){
    	return userCashMapper.deleteByPrimaryKey(id);
    }

    public int addUser(UserCash record){
    	return userCashMapper.insert(record);
    }

    public int insertSelective(UserCash record){
    	return userCashMapper.insertSelective(record);
    }

    public UserCash getUserById(Long id){
    	return userCashMapper.selectByPrimaryKey(id);
    }
    
    public int countUserByStatus(Date date){
        return userCashMapper.selectCountByStatus(date);
    }

    public int updateUser(UserCash record){
    	return userCashMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserCash record){
    	return userCashMapper.updateByPrimaryKey(record);
    }

    public UserCash getUserByOrder(String orderid) {
        return userCashMapper.selectByOrder(orderid);
    }

    public List<UserCashOrder> selectOrderByDay(Date date){
        return userCashMapper.selectOrderByDay(date);
    }

    public List<UserCash> getPageByday(Map<String, Object> map) {
        return userCashMapper.selectPageByDay(map);
        
    }

    public List<UserCash> getPageByUser(Map<String, Object> map) {
        return userCashMapper.selectPageByUser(map);
    }

    public int countPageByUser(Map<String, Object> map) {
        return userCashMapper.countPageByUser(map);
    }

    public int countPageByDay(Map<String, Object> map) {
        return userCashMapper.countPageByDay(map);
    }

    public List<UserCashOrder> selectRechargedByDay(Date date) {
        return userCashMapper.selectRechargedByDay(date);
    }

    public int countPageByOperate(Map<String, Object> map) {
        return userCashMapper.countPageByOperate(map);
    }

    public List<UserCash> getPageByOperate(Map<String, Object> map) {
        return userCashMapper.selectPageByOperate(map);
    }

    public List<UserCash> getAllByCredits(Map<String, Object> map) {
        return userCashMapper.selectAllByCredits(map);
    }

    public int countPageByStatus(Map<String, Object> map) {
        return userCashMapper.countPageByStatus(map);
    }

    public List<UserCash> getPageByStatus(Map<String, Object> map) {
        return userCashMapper.selectPageByStatus(map);
    }

    public int countPageByType(Map<String, Object> map) {
        return userCashMapper.countPageByType(map);
    }

    public List<UserCash> getPageByType(Map<String, Object> map) {
        return userCashMapper.selectPageByType(map);
    }
    
    public Integer getAllAlipayMoney() {
        return userCashMapper.getAllAlipayMoney();
    }

    public Integer getAllPhoneMoney() {
        return userCashMapper.getAllPhoneMoney();
    }

    public Integer getAllMoney() {
        return userCashMapper.getAllMoney();
    }
}