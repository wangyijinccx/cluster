package com.ipeaksoft.moneyday.core.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.IdfaApp;

public interface IdfaAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IdfaApp record);

    IdfaApp selectByPrimaryKey(Integer id);

    int selectDuplicateCntByAppidAndIdfa(@Param("appid")String appid, @Param("idfa")String idfa);
    
    int selectCntByAppidAndIdfa(@Param("appid")String appid, @Param("idfa")String idfa);
    
    List<String> selectByAppidAndIdfas(@Param("appid")String appid, @Param("idfas")Collection<String> idfas);

	List<IdfaApp> selectByAppidAndTime(@Param("appid") String appid,
			@Param("startDate") String startDate,
			@Param("endDate") String endDate);

    int updateByPrimaryKeySelective(IdfaApp record);

    int updateByPrimaryKey(IdfaApp record);
    
    List<String> selectDuplicateIdfaByAppidAndIdfa(String appid);
    
    List<IdfaApp> selectByAppidAndIdfa(@Param("appid")String appid, @Param("idfa")String idfa);
    
	List<IdfaApp> selectJoinComp(@Param("appid") String appid,
			@Param("startDate") String startDate,
			@Param("endDate") String endDate);

	List<IdfaApp> selectDiffComp(@Param("appid") String appid,
			@Param("startDate") String startDate,
			@Param("endDate") String endDate);
}