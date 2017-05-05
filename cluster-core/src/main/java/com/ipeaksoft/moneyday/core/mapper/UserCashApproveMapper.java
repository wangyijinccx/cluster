package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserCashApprove;

public interface UserCashApproveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCashApprove record);

    int insertSelective(UserCashApprove record);

    UserCashApprove selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCashApprove record);

    int updateByPrimaryKey(UserCashApprove record);

    List<UserCashApprove> selectPageByOrder(Map<String, Object> map);

    int countPageByOrder(Map<String, Object> map);
}