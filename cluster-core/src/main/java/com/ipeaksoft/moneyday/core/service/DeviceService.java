package com.ipeaksoft.moneyday.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.Device;
import com.ipeaksoft.moneyday.core.entity.Version;
import com.ipeaksoft.moneyday.core.mapper.DeviceMapper;
import com.ipeaksoft.moneyday.core.mapper.VersionMapper;

@Service
public class DeviceService extends BaseService {
    @Autowired
    private DeviceMapper deviceMapper;
    
    @Autowired
    private VersionMapper versionMapper;

    public int deleteByPrimaryKey(Integer id){
    	return deviceMapper.deleteByPrimaryKey(id);
    }
    

    public int addDevice(Device record){
    	Device d=deviceMapper.selectByIdfa(record.getIdfa());
    	if(d==null){
    		return deviceMapper.insert(record);
    	}else{
    		d.setAppVersion(record.getAppVersion());
    		d.setClientType(record.getClientType());
    		d.setModel(record.getModel());
    		d.setOperator(record.getOperator());
    		d.setOs(record.getOs());
    		d.setOsVersion(record.getOsVersion());
    		d.setUrl(record.getUrl());
    		d.setVersionDesc(record.getVersionDesc());
    		d.setUserid(record.getUserid());
    		deviceMapper.updateByPrimaryKey(d);
    		return 0;
    	}
    }

    public int insertSelective(Device record){
    	return deviceMapper.insertSelective(record);
    }

    public Device getDeviceById(Integer id){
    	return deviceMapper.selectByPrimaryKey(id);
    }
    
    public Version getDeviceByOs(String os){
    	return versionMapper.selectByOs(os);
    }
    
    public Version getDeviceByVersion(Version version){
        return versionMapper.selectByVersion(version);
    }
    
    
    public int updateDevice(Device record){
    	return deviceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Device record){
    	return deviceMapper.updateByPrimaryKey(record);
    }
    
    public Device selectByIdfa(String idfa){
    	return deviceMapper.selectByIdfa(idfa);
    }
}