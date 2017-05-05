package com.ipeaksoft.moneyday.admin.schedule;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.service.BaseService;
import com.ipeaksoft.moneyday.core.service.ClusterGameAccountService;

@Service
//@Lazy(false)
public class ScheduleService extends BaseService {
	@Autowired
    ClusterGameAccountService clusterGameAccountService;
	
    @PostConstruct
    public void init() {
    	logger.info("init .........");
    }
    
    @Scheduled(cron = "*/30 * * * * ?")
    public void doTask(){
        logger.info("adcluster-doTask().........");
        clusterGameAccountService.daTask();
        logger.info("adcluster-doTask() end.........");
    }
    

}
