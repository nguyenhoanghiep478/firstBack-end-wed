package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	List<CategoryModel> findById(Long id);
	List<CategoryModel> findByName(String name);
	List<CategoryModel> findBycode(String code);
	Long save(CategoryModel category);
	void update(CategoryModel category);
	void delete(CategoryModel category);
}
