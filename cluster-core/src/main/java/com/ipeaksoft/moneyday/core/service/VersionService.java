package com.ipeaksoft.moneyday.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeaksoft.moneyday.core.entity.Version;
import com.ipeaksoft.moneyday.core.mapper.VersionMapper;

@Service
public class VersionService {
    
    @Autowired
    private VersionMapper versionMapper;
    
    public Version getByOs(String os){
        return versionMapper.selectByOs(os);
    }

    public Version getByVersion(Version version) {
        return versionMapper.selectByVersion(version);
    }
}
