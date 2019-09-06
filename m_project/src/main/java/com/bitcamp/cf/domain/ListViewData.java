package com.bitcamp.cf.domain;

import java.util.List;

public class ListViewData {

	private List<cfMain> cfMainList;
	private int totalCount;
	private int no;
	private int currentPageNumber;
	private int pageTotalCount;
	
	
	public List<cfMain> getCfMainList() {
		return cfMainList;
	}
	public void setCfMainList(List<cfMain> cfMainList) {
		this.cfMainList = cfMainList;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	
	
	
	
}
