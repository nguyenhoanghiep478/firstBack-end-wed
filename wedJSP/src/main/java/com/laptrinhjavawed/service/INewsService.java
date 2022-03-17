package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.model.NewsModel;

public interface INewsService {
	List<NewsModel> findAll();
	List<NewsModel> findById(Long id);
	List<NewsModel> findByCategoryID(Long categoryId);
}
