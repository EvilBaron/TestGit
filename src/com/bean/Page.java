package com.bean;

import java.util.List;

public class Page<T> {
	private Integer pageIndex;	//第几页
	private Integer pageSize;	//每页几条
	private Integer totalCount;	//总行数
	private Integer totalPage;	//总页数
	private List<T> list;	//查询的结果

	public Page() {
		super();
	}

	public Page(Integer pageIndex, Integer pageSize, Integer totalCount,
			List<T> list) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		
		//计算总页数
		//this.totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
		this.totalPage = (totalCount+pageSize-1)/pageSize;
		
		this.list = list;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
