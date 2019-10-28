package com.bdqn.util;

import java.io.Serializable;
import java.util.List;

public class PageUtil<T> implements Serializable {
	private int pageIndex;//当前页
	private int pageSize;//页大小
	private int totaCount;//总记录数
	private int totaPageNumber;//总页数
	private List<T> pagedata;//当前页数据
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotaCount() {
		return totaCount;
	}
	public void setTotaCount(int totaCount) {
		this.totaCount = totaCount;
	}
	public int getTotaPageNumber() {
		return totaPageNumber;
	}
	public void setTotaPageNumber(int totaPageNumber) {
		this.totaPageNumber = totaPageNumber;
	}
	public List<T> getPagedata() {
		return pagedata;
	}
	public void setPagedata(List<T> pagedata) {
		this.pagedata = pagedata;
	}
	
}
