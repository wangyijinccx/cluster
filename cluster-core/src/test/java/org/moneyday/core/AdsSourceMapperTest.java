package org.moneyday.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.moneyday.AbstractSpringTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.ipeaksoft.moneyday.core.entity.AdsSource;
import com.ipeaksoft.moneyday.core.mapper.AdsSourceMapper;

public class AdsSourceMapperTest extends AbstractSpringTest{
	@Autowired
	AdsSourceMapper mapper;
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Test
	public void test() throws Exception{
		mapper.selectByPrimaryKey(1);
		mapper.selectByKey("LANMAOG");
		List<AdsSource> list = mapper.selectByModifyTime(format.format(new Date()));
		logger.debug("size: "+list.size());
	}

}
