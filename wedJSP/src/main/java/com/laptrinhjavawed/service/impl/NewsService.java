package com.laptrinhjavawed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.dao.INewsDAO;
import com.laptrinhjavawed.model.NewsModel;
import com.laptrinhjavawed.service.INewsService;

public class NewsService implements INewsService{
	@Inject
	private INewsDAO news;
	@Override
	public List<NewsModel> findAll() {
		return news.findAll();
	}

	@Override
	public List<NewsModel> findById(Long id) {
		return news.findById(id);
	}

	@Override
	public List<NewsModel> findByCategoryID(Long categoryId) {
		return news.findByCategoryID(categoryId);
	}
	
}
