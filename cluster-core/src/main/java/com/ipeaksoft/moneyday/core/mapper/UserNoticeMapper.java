package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.UserNotice;

public interface UserNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserNotice record);

    int insertSelective(UserNotice record);

    UserNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserNotice record);

    int updateByPrimaryKey(UserNotice record);
    
    UserNotice selectByMobileAndNoticeId(Map map);
    
    List<UserNotice> selectByMobile(String mobile);
}