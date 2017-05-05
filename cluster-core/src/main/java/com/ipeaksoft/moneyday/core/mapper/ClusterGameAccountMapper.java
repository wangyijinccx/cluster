package com.ipeaksoft.moneyday.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipeaksoft.moneyday.core.entity.ClusterGameAccount;
import com.ipeaksoft.moneyday.core.entity.TaskFast;

public interface ClusterGameAccountMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ClusterGameAccount record);

	int insertSelective(ClusterGameAccount record);

	ClusterGameAccount selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ClusterGameAccount record);

	int updateByPrimaryKey(ClusterGameAccount record);

	List<Map<String, Object>> selectListGameAccont(
			@Param(value = "currentPage") Integer start,
			@Param(value = "pageSize") Integer length);

	int selectNum();

	List<ClusterGameAccount> selectByGameId(@Param(value = "id") Integer id,
			@Param(value = "currentPage") Integer start,
			@Param(value = "pageSize") Integer length);

	int selectByGameIdNum(@Param(value = "id") Integer id);

	List<Map<String, Object>> selectAccount(@Param(value = "id") Integer id);

	int insertGameAccount(@Param("list") List<ClusterGameAccount> list);

	int updateStatus();

	List<ClusterGameAccount> selectByIds(@Param("ids") List<Integer> ids);

	Map<String, Object> selectGames(@Param("gameid") String gameid,
			@Param("account") String account, @Param("server") String server);

	List<ClusterGameAccount> checkGames(@Param("gameid") Integer gameid,
			@Param("account") String account, @Param("server") String server);
}