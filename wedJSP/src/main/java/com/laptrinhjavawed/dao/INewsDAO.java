package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.model.NewsModel;

public interface INewsDAO{
	List<NewsModel> findAll();
	List<NewsModel> findById(Long id);
	List<NewsModel> findByCategoryID(Long categoryId);
}
