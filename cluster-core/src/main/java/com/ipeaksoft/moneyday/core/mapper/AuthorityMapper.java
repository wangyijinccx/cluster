package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;

import com.ipeaksoft.moneyday.core.entity.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    
    List<Authority> loadByUserName(String userName);
}