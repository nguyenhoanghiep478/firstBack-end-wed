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
	public List<CategoryModel> findById(Long id) {
		return categoryDao.findById(id);
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
	public Long save(CategoryModel category) {
		return categoryDao.save(category);
	}
	@Override
	public void update(CategoryModel category) {
		categoryDao.update(category);
	}
	@Override
	public void delete(CategoryModel category) {
		categoryDao.delete(category);
	}

}
