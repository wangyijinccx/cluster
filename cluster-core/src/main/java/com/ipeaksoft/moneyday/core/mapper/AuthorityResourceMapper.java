package com.ipeaksoft.moneyday.core.mapper;

import com.ipeaksoft.moneyday.core.entity.AuthorityResource;

public interface AuthorityResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthorityResource record);

    int insertSelective(AuthorityResource record);

    AuthorityResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthorityResource record);

    int updateByPrimaryKey(AuthorityResource record);
}