package com.ipeaksoft.moneyday.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.User;
import com.ipeaksoft.moneyday.core.entity.UserCash;
import com.ipeaksoft.moneyday.core.entity.UserRecord;
import com.ipeaksoft.moneyday.core.entity.UserTaskAds;
import com.ipeaksoft.moneyday.core.entity.UserTaskFast;
import com.ipeaksoft.moneyday.core.enums.UserRecordType;
import com.ipeaksoft.moneyday.core.mapper.UserMapper;
import com.ipeaksoft.moneyday.core.mapper.UserRecordMapper;

@Service
public class UserRecordService extends BaseService {
    @Autowired
    private UserRecordMapper userRecordMapper;
    @Autowired
    private UserMapper       userMapper;
    @Autowired
    UserRecordLockService    lock;

    //    public UserRecord create(UserRecord record){
    //    	userRecordMapper.insert(record);
    //    	return record;
    //    }

    public UserRecord create(UserCash cash, String mobile) {
        UserRecord record = new UserRecord();
        int status = Integer.valueOf(cash.getStatus());
        record.setMobile(mobile);
        record.setPid(cash.getId());
        record.setCreateTime(new Date());
        record.setAward(-cash.getCredits());
        if (4==status) {
            record.setAward(cash.getCredits());
        }
        UserRecordType type = null;
        String exchangeType = cash.getExchangeType();
        if ("alipay".equals(exchangeType)) {
            type = (4==status) ? UserRecordType.CASH_FAIL : UserRecordType.CASH;
        }
        if ("phonebill".equals(exchangeType)) {
            type = (4==status) ? UserRecordType.RECHARGE_FAIL : UserRecordType.RECHARGE;
        }
        record.setType(type);
        record.setDescription(cash.getDescription());
        int totalAward = cash.getCredits();
        if (lock.aquireLock(mobile)) {
            try {
                UserRecord last = userRecordMapper.selectLastByMobile(mobile);
                if (last != null) {
                    if (4==status) { // 订单失败，则返还用户积分
                        totalAward += last.getTotalAward();
                    }else { // 订单成功，则扣除用户积分
                        totalAward = last.getTotalAward()-totalAward;
                    }
                }
               
                record.setTotalAward(totalAward);
                userRecordMapper.insert(record);
                User user = new User();
                user.setMobile(mobile);
                user.setAward(totalAward);
                userMapper.updateByMobileKeySelective(user);
                return record;
            } finally {
                lock.realseLock(mobile);
            }
        } else {
            return null;
        }
    }

    public UserRecord create(UserTaskFast task) {
        UserRecord record = new UserRecord();
        record.setMobile(task.getMobile());
        record.setAward(task.getAward());
        record.setPid(task.getId());
        record.setCreateTime(new Date());
        record.setType(UserRecordType.FAST);
        record.setDescription(task.getDescription());
        int totalAward = task.getAward();
        String mobile = task.getMobile();
        if (lock.aquireLock(mobile)) {
            try {
                UserRecord last = userRecordMapper.selectLastByMobile(mobile);
                if (last != null) {
                    totalAward += last.getTotalAward();
                }
                record.setTotalAward(totalAward);
                userRecordMapper.insert(record);
                User user = new User();
                user.setMobile(mobile);
                user.setAward(totalAward);
                userMapper.updateByMobileKeySelective(user);
                return record;
            } finally {
                lock.realseLock(mobile);

            }
        } else {
            return null;
        }

    }

    public UserRecord create(UserTaskAds task) {
        //todo
        UserRecord record = new UserRecord();
        record.setMobile(task.getMobile());
        record.setAward(task.getAward());
        record.setPid(task.getId());
        record.setCreateTime(new Date());
        record.setType(UserRecordType.ADS);
        record.setDescription(task.getDescription());
        int totalAward = task.getAward();
        String mobile = task.getMobile();
        if (lock.aquireLock(mobile)) {
            try {
                UserRecord last = userRecordMapper.selectLastByMobile(mobile);
                if (last != null) {
                    totalAward += last.getTotalAward();
                }
                record.setTotalAward(totalAward);
                userRecordMapper.insert(record);

                User user = new User();
                user.setMobile(mobile);
                user.setAward(totalAward);
                userMapper.updateByMobileKeySelective(user);
                return record;
            } finally {
                lock.realseLock(mobile);
            }
        } else {
            return null;
        }
    }

    public List<UserRecord> getPageByMobile(Map<String, Object> map) {
        return userRecordMapper.selectPageByMobile(map);
    }

}
