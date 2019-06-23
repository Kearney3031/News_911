package com.model;

import java.util.List;

public class PageBean {
	private int pageSize;
	private int pageNumber;
	private long totalPage;
	private List<?> list;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", totalPage=" + totalPage + ", list="
				+ list + "]";
	}
	

}
