package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.TaskFastStatistics;
import com.ipeaksoft.moneyday.core.entity.UserSurvey;
import com.ipeaksoft.moneyday.core.entity.UserSurveyDetail;


public interface SearchMapper
{
    // 用户概览详细
    List<UserSurveyDetail> findByWhere(Map<String, Object> map);
    
    
    /**
     * 用户概览总数统计
     * 
     * @param map
     * @return
     */
    int findByWhereCount(Map<String, Object> map);
    
    
    // 用户概览总体
    List<UserSurvey> getUserSurvey(String startDate, String endDate);
    
    
    // 快速认务按天
    List<Map> findFastTask(Map peroid);
    
    
    // 用户明细-加上用户维度
    List<Map> findFastTaskWithUid(Map map);
    
    
    // 快速认务按天
    List<Map> findFastTaskListByDay(String day);
    
    
    // 快速认务按天及任务--day,taskId
    List<Map> findFastTaskDetailListByDay(Map map);
    
    
    // 常规任务按天
    List<Map> findAdsTaskListByDay(String day);
    
    
    // 用户概览
    List<Map> findUsersSurveyListByWhere(Map map);
    
    
    // 用户概监－按天查询
    List<Map> findUsersSurveyListByDay(String day);
    
    
    // 用户概览－按天与类型
    List<Map> findUsersSurveyListByDayAndType(Map map);
    
    
    // 用户明细
    List<Map> findUserDetailList(Map map);
    
    
    /**
     * 快速任务统计查询
     * 
     * @param map
     * @return
     */
    List<TaskFastStatistics> findFastTaskStatistics(Map map);
    
    
    /**
     * 快速任务统计查询(总条数)
     * 
     * @param map
     * @return
     */
    int findFastTaskStatisticsCount(Map map);
    
    
    /**
     * 获取快速任务总收益
     * 
     * @return
     */
    int getTaskFastIncome();
    
    
    /**
     * 提现汇总查询数据集
     * 
     * @param map
     * @return
     */
    public List<List<?>> getPerformance(Map<String, Object> map);
    
    
    /**
     * 提现明细查询详细数据集
     * 
     * @param userId
     * @param startDate
     * @param endDate
     * @return 
     */
    public List<Map<String, Object>> getPerformanceBillItem(@Param(value="user_id")int userId, @Param(value="start_date")String startDate, @Param(value="end_date")String endDate);


    /**
     * 任务明细查询详细数据集
     * 
     * @param map
     * @return
     */
    public List<Map<String, Object>> getPerformanceItem(Map<String, Object> map);

    
    /**
     * 提现余额查询详细数据集
     * 
     * @param userId
     * @param startDate
     * @param endDate
     * @return 
     */
    public List<Map<String, Object>> getPerformanceMoneyItem(@Param(value="user_id")int userId, @Param(value="start_date")String startDate, @Param(value="end_date")String endDate);


    /**
     * 广告主明细查询详细数据集
     * 2015年5月8日 下午2:26:03
     * @param userId
     * @param startDate
     * @param endDate
     * @return 
     */
    public List<Map<String, Object>> getPerformanceChannelItem(@Param(value="user_id")int userId, @Param(value="start_date")String startDate, @Param(value="end_date")String endDate);


    /**
     * 渠道明细查询详细数据集
     * 
     * 2015年5月29日 下午3:15:18
     * @param userId
     * @param startDate
     * @param endDate
     * @return 
     */
    List<Map<String, Object>> getPerformanceChannel(@Param(value="start")String startDate, @Param(value="end")String endDate);

    /**
     * 渠道点击查询详细数据集
     *
     * 2015年6月3日 下午6:40:22
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> getPerformanceChannelClick(@Param(value="start")String startDate, @Param(value="end")String endDate);
}