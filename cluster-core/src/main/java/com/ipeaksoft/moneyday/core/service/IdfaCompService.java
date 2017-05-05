package com.ipeaksoft.moneyday.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.IdfaComp;
import com.ipeaksoft.moneyday.core.mapper.IdfaCompMapper;

@Service
public class IdfaCompService extends BaseService {
    @Autowired
    private IdfaCompMapper mapper;

    public int deleteByPrimaryKey(Integer id){
    	return mapper.deleteByPrimaryKey(id);
    }

    public int insert(IdfaComp record){
    	return mapper.insert(record);
    }
    
    public int insertBatch(List<IdfaComp> list){
    	return mapper.insertBatch(list);
    }

    public int truncate(){
    	return mapper.truncate();
    }

    public IdfaComp selectByPrimaryKey(Integer id){
    	return mapper.selectByPrimaryKey(id);
    }

    public List<IdfaComp> selectAll(){
    	return mapper.selectAll();
    }

}
