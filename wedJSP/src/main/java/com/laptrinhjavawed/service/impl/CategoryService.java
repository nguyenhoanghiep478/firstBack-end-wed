package com.laptrinhjavawed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.dao.ICategoryDAO;
import com.laptrinhjavawed.model.CategoryModel;
import com.laptrinhjavawed.service.ICategoryService;

public class CategoryService implements ICategoryService{
	@Inject
	private ICategoryDAO categoryDao;
	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
	@Override
	public CategoryModel findOne(Long id) {
		return categoryDao.findOne(id);
	}
	@Override
	public List<CategoryModel> findByName(String name) {
		return categoryDao.findByName(name);
	}
	@Override
	public List<CategoryModel> findBycode(String code) {
		return categoryDao.findBycode(code);
	}
	@Override
	public CategoryModel save(CategoryModel category) {
		Long categoryId= categoryDao.insert(category);
		return categoryDao.findOne(categoryId);
	}
	@Override
	public void update(CategoryModel category) {
		categoryDao.update(category);
	}
	@Override
	public void delete(CategoryModel category) {
		categoryDao.deleteOne(category);
	}

}
