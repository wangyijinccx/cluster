package com.ipeaksoft.moneyday.core.entity;

import java.io.Serializable;


/**
 *基础映射
 */
public class BaseEntity implements Serializable
{

    private static final long serialVersionUID = -2948898645917185758L;
    
    private Integer pageSize;    
    private Integer currentPage;
    
    private String startDate;
    private String endDate;
    
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String getStartDate() 
	{
		return startDate;
	}
	public void setStartDate(String startDate) 
	{
		this.startDate = startDate;
	}
	public String getEndDate() 
	{
		return endDate;
	}
	public void setEndDate(String endDate) 
	{
		this.endDate = endDate;
	}
}
