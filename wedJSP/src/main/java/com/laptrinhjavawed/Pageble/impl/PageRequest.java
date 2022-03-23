package com.laptrinhjavawed.Pageble.impl;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.sort.Sorter;

public class PageRequest implements Pageble{
	private Integer page=null;
	private Integer maxPageItems=null;
	private Sorter sorter=null;
	public PageRequest(Integer Page,Integer maxPageItems,Sorter sorter){
		this.page=Page;
		this.maxPageItems=maxPageItems;
		this.sorter=sorter;
	}
	@Override
	public Integer getPage(){
		return page;
	}

	@Override
	public Integer getOffSet() {
		return (this.page-1)*this.maxPageItems;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return maxPageItems;
	}
	public Sorter getSorter() {
		return sorter;
	}
}
