package com.ipeaksoft.moneyday.core.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.TaskAuto;
import com.ipeaksoft.moneyday.core.enums.AutoTaskSource;

public interface TaskAutoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskAuto record);

    TaskAuto selectByPrimaryKey(Long id);
    
	TaskAuto selectByAdidAndSource(@Param("adid") String adid,
			@Param("source")AutoTaskSource source);

    List<TaskAuto> selectByAdidsAndSource(@Param("adids")Collection<String> adids,
			@Param("source")AutoTaskSource source);

    List<TaskAuto> selectALL();
    
    int updateByPrimaryKeySelective(TaskAuto record);
}