package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.model.NewsModel;
import com.laptrinhjavawed.model.UserModel;

public interface INewsDAO extends GenericDAO<NewsModel>{
	List<NewsModel> findAll(Pageble pageble);
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryID(Long categoryId);
	Long insert(NewsModel newsModel);
	List<NewsModel> findByUserName(String userName);
	void delete(Long id);
	void update(NewsModel newsUpdate);
	Integer getTotalItem();
}
