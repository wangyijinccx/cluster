/**Title: Total Json
 *Description: Total Json
 *Copyright: Copyright (c) 2009-2011 by 滕济可
 *Company:tengjk
 *
 * @author tengjike
 * @version 1.0
 * @date Nov 28, 2009
 */
package com.ipeaksoft.moneyday.admin.util;

import java.util.List;

public class TotalJson {
	//private long results;
	private String draw;//查询条件
	private long recordsTotal;
	private long recordsFiltered;

	private List data;
	//private String dataResults;
//	public String getDataResults() {
//		return dataResults;
//	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}


	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

//	public void setDataResults(String dataResults) {
//		this.dataResults = dataResults;
//	}


	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

//	public long getResults() {
//		return results;
//	}
//
//	public void setResults(long results) {
//		this.results = results;
//	}
}
