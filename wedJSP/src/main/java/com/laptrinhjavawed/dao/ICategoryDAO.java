package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	List<CategoryModel> findByName(String name);
	List<CategoryModel> findBycode(String code);
	Long insert(CategoryModel category);
	void update(CategoryModel category);
	void deleteOne(CategoryModel category);
}
