package com.laptrinhjavawed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavawed.model.NewsModel;

public class NewsMapper extends AbstractMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		NewsModel news= new NewsModel();
		try {
			CommonMapper(news, resultSet);
			news.setTitle(resultSet.getString("title"));
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
}
