package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.WeixinUser;

public interface WeixinUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(WeixinUser record);

    int insertSelective(WeixinUser record);

    WeixinUser selectByPrimaryKey(String id);

    WeixinUser selectByOpenid(String openid);

    WeixinUser selectByMobile(String mobile);

    int updateByPrimaryKeySelective(WeixinUser record);

    int updateByPrimaryKey(WeixinUser record);
    
    int updateByOpenid(WeixinUser record);
}