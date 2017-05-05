package org.moneyday.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.moneyday.AbstractSpringTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.ipeaksoft.moneyday.core.mapper.IdfaAppMapper;
import com.ipeaksoft.moneyday.core.mapper.UserTaskFastClickMapper;

public class IdfaAppMapperTest extends AbstractSpringTest{
	@Autowired
	IdfaAppMapper mapper;
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	UserTaskFastClickMapper clickMapper;
	
	@Test
	public void test() throws Exception{
		clickMapper.selectByIdfa("abcd", "12921");
	}

}
