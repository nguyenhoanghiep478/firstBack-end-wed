package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	List<CategoryModel> findByName(String name);
	List<CategoryModel> findBycode(String code);
	CategoryModel save(CategoryModel category);
	void update(CategoryModel category);
	void delete(CategoryModel category);
}
