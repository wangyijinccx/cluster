package com.ipeaksoft.moneyday.core.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.dto.Dictionary;
import com.ipeaksoft.moneyday.core.entity.TaskFast;
import com.ipeaksoft.moneyday.core.entity.TaskFastCompleteInfo;

public interface TaskFastMapper {
    String selectByAdId(String appid);
    
    int deleteByPrimaryKey(Long id);

    int insert(TaskFast record);
    int insertGetId(TaskFast record);

    TaskFast selectByPrimaryKey(Long id);
    List<TaskFast> selectByIds(@Param("ids")Collection<Long> ids);

    int addFinished(Long id);

    int reduceFinished(Long id);
    
    int addFinishedByAppid(String appid);

    int reduceFinishedByAppid(String appid);
    
    int updateByPrimaryKeySelective(TaskFast record);

    int updateByPrimaryKey(TaskFast record);
    
    List<TaskFast>  findByWhere(TaskFast taskFast);
    
    int findCountByWhere(TaskFast taskFast);
    
    List<TaskFast>  findCompleteTask(TaskFast taskFast);
    
    List<TaskFast>  findAllTask(TaskFast taskFast);
    
    List<TaskFast>  findNotBeginningTask(TaskFast taskFast);
    
    List<TaskFast> selectAll();
    /**
     * 统计某天某个任务的完成情况
     * @param where
     * @return
     */
    List<TaskFastCompleteInfo> findPageListTaskCompleteInfo(Map<String,Object> where);
    
    /**
     * 统计某天某个任务的完成情况总数
     * @param where
     * @return
     */
    int findPageListTaskCompleteInfoCount(Map<String,Object> where);
    
    List<TaskFast> listALLBeginedTaskNew(Integer priority);
    List<TaskFast> listDoingBeginedTask(@Param("mobile")String mobile, @Param("priority")Integer priority);
    List<String> listCompleteBeginedTaskNew(@Param("mobile")String mobile, @Param("priority")Integer priority);
    List<TaskFast> listALLNoBegingingTaskNew(Integer priority);

    TaskFast selectByAppid(String appid);

    
    /**
     * 统计为单个渠道商创建的任务列表
     * 2015年5月28日 上午11:27:38
     * @param channelName
     */
    List<TaskFast> listChannelTask(String channelName);

    /**
     * 获取字典表中单个类型的字典列表
     * 2015年5月28日 下午4:28:22
     * @param type
     */
    List<Dictionary> listDictionary(int type);

}