package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.model.NewsModel;

public interface INewsService {
	List<NewsModel> findAll(Pageble pageble);
	NewsModel	findOne (Long id);
	List<NewsModel> findByCategoryID(Long categoryId);
	NewsModel save(NewsModel newsModel);
	void delete(Long[] ids);
	NewsModel update(NewsModel newsModel);
	Integer getTotalItem();

}
