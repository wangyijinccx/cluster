package com.ipeaksoft.moneyday.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.Competitor;
import com.ipeaksoft.moneyday.core.entity.CompetitorUser;
import com.ipeaksoft.moneyday.core.mapper.CompetitorMapper;
import com.ipeaksoft.moneyday.core.mapper.CompetitorUserMapper;

/**
 * @description 竞品信息相关的Service
 * @author sxy
 * 2015年3月23日 下午2:14:41
 * 
 */
@Service
public class CompetitorService extends BaseService {
    @Autowired
    private CompetitorMapper competitorMapper;
    @Autowired
    private CompetitorUserMapper competitorUserMapper;

    public int addCompetitor(Competitor record) {
        return competitorMapper.insert(record);
    }

    public int insertSelective(Competitor record) {
        return competitorMapper.insertSelective(record);
    }

    public Competitor getCompetitorById(Integer id) {
        return competitorMapper.selectByPrimaryKey(id);
    }
    
    public List<Competitor> getAll(){
        return competitorMapper.selectAll();
    }
    
    public int addCompetitorUser(CompetitorUser record){
        return competitorUserMapper.insert(record);
    }

    public List<Competitor> findByMobile(String mobile) {
        return competitorMapper.selectByMobile(mobile);
    }

    public Integer countByMobileAndId(String mobile, String competitorid) {
        return competitorMapper.countByMobileAndId(mobile, competitorid);
    }
}