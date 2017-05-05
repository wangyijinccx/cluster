package com.ipeaksoft.moneyday.core.dto;

import java.util.List;
import java.util.Map;


public class PageResult
{
    public String draw;
    
    public int recordsTotal;
    
    public long recordsFiltered;
    
    public List<Map<String, Object>> data;
    
    
    public String getDraw()
    {
        return draw;
    }
    
    
    public void setDraw(String draw)
    {
        this.draw = draw;
    }
    
    
    public int getRecordsTotal()
    {
        return recordsTotal;
    }
    
    
    public void setRecordsTotal(int recordsTotal)
    {
        this.recordsTotal = recordsTotal;
    }
    
    
    public long getRecordsFiltered()
    {
        return recordsFiltered;
    }
    
    
    public void setRecordsFiltered(long recordsFiltered)
    {
        this.recordsFiltered = recordsFiltered;
    }
    
    
    public List<Map<String, Object>> getData()
    {
        return data;
    }
    
    
    public void setData(List<Map<String, Object>> data)
    {
        this.data = data;
    }
    
}
