package com.laptrinhjavawed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavawed.model.CategoryModel;

public class CategoryMapper extends AbstractMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel category = new CategoryModel();
		try {
			CommonMapper(category, resultSet);
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
