package com.laptrinhjavawed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavawed.model.CommentModel;

public class CommentMapper extends AbstractMapper implements RowMapper<CommentModel>{

	@Override
	public CommentModel mapRow(ResultSet resultSet) {
		CommentModel commentModel=new CommentModel();
		CommonMapper(commentModel, resultSet);
		try {
			CommonMapper(commentModel, resultSet);
			commentModel.setContent(resultSet.getString("content"));
			commentModel.setUserId(resultSet.getLong("userid"));
			commentModel.setNewsId(resultSet.getLong("newsid"));
			commentModel.setUserName(resultSet.getString("username"));
			return commentModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
