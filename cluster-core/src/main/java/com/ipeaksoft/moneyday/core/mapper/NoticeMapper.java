package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import com.ipeaksoft.moneyday.core.entity.Notice;

public interface NoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    
    List<Notice> selectAll(String mobile);
    
    Integer hasNewAnnounce(Map map);
    
    Integer getFastClickUsers();
    
    Integer getAdsClickUsers();
    
    Long getAllUserAward();
    /**
     * 分页查询公告内容
     * @param where
     * @return
     */
    List<Notice> findPageList(Map<String,Object> where);
    
    /**
     * 统计公告所有条数
     * @param where
     * @return
     */
    int findPageListCount(Map<String,Object> where);
    
}