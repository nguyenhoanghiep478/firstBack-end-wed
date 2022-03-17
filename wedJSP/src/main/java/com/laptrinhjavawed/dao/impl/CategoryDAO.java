package com.laptrinhjavawed.dao.impl;

import java.util.List;

import com.laptrinhjavawed.dao.ICategoryDAO;
import com.laptrinhjavawed.mapper.CategoryMapper;
import com.laptrinhjavawed.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	@Override
	public List<CategoryModel> findAll() {
		String sql="SELECT * FROM category";
		return query(sql,new CategoryMapper());
	}

	@Override
	public List<CategoryModel> findByName(String name) {
		String sql="SELECT * FROM category Where name=?";
		return query(sql,new CategoryMapper(),name);
	}

	@Override
	public List<CategoryModel> findBycode(String code) {
		String sql="SELECT * FROM category Where code=?";
		return query(sql,new CategoryMapper(),code);
	}

	@Override
	public List<CategoryModel> findById(Long id) {
		String sql="SELECT * FROM category Where id=?";
		return query(sql,new CategoryMapper(),id);
	}

	@Override
	public Long save(CategoryModel category) {
		String sql="INSERT INTO category(id,name,code) values(?,?,?)";
		return save(sql,category.getId(),category.getName(),category.getCode());
	}

	@Override
	public void update(CategoryModel category) {
		String sql="Update 'tables'. 'category' Set'name'=?,'code'=? Where('id'=?)";
		update(sql,category.getName(),category.getCode(),category.getId());
	}

	@Override
	public void delete(CategoryModel category) {
		String sql="DELETE FROM category Where id=?";
		update(sql,category.getId());
	}

	

}
