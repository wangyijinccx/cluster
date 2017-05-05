package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;

import com.ipeaksoft.moneyday.core.entity.IdfaComp;

public interface IdfaCompMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IdfaComp record);
    
    int insertBatch(List<IdfaComp> list);
    
    int truncate();

    IdfaComp selectByPrimaryKey(Integer id);
    
    List<IdfaComp> selectAll();
    
}