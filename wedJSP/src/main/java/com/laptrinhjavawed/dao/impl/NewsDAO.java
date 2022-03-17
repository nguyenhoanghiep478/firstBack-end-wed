package com.laptrinhjavawed.dao.impl;

import java.util.List;

import com.laptrinhjavawed.dao.INewsDAO;
import com.laptrinhjavawed.mapper.NewsMapper;
import com.laptrinhjavawed.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {
	@Override
	public List<NewsModel> findByCategoryID(Long categoryId) {
		String sql="SELECT * FROM news WHERE categoryid=?";
		return query(sql,new NewsMapper(),categoryId);
	}
	@Override
	public List<NewsModel> findAll() {
		String sql="SELECT * FROM news";
		return query(sql,new NewsMapper());
	}
	@Override
	public List<NewsModel> findById(Long id) {
		String sql="SELECT * FROM news WHERE id=?";
		return query(sql, new NewsMapper(), id);
	}
}
