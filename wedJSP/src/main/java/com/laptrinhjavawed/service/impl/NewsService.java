package com.laptrinhjavawed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.dao.ICommentDAO;
import com.laptrinhjavawed.dao.INewsDAO;
import com.laptrinhjavawed.model.NewsModel;
import com.laptrinhjavawed.service.INewsService;

public class NewsService implements INewsService{
	@Inject
	private INewsDAO news;
	@Inject
	private ICommentDAO comment;
	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		return news.findAll(pageble);
	}

	@Override
	public NewsModel findOne(Long id) {
		return news.findOne(id);
	}

	@Override
	public List<NewsModel> findByCategoryID(Long categoryId) {
		return news.findByCategoryID(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		Long newsId= news.insert(newsModel);
		return news.findOne(newsId);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			comment.deleteByNewsId(id);
			news.delete(id);
		}
	}

	@Override
	public NewsModel update(NewsModel newsModel) {
		news.update(newsModel);
		return news.findOne(newsModel.getId());
	}

	@Override
	public Integer getTotalItem() {
		return news.getTotalItem();
	}
	
}
