package com.laptrinhjavawed.dao.impl;

import java.util.List;

import com.laptrinhjavawed.dao.ICommentDAO;
import com.laptrinhjavawed.mapper.CommentMapper;
import com.laptrinhjavawed.model.CommentModel;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO{

	@Override
	public List<CommentModel> findAll() {
		String sql="SELECT * FROM comment";
		return query(sql,new CommentMapper());
	}

	@Override
	public List<CommentModel> findById(Long id) {
		String sql="SELECT * FROM comment WHERE id=?";
		return query(sql,new CommentMapper(),id);
	}

	@Override
	public List<CommentModel> findByNewsId(Long newsid) {
		String sql="SELECT * FROM comment WHERE newsid=?";
		return query(sql,new CommentMapper(),newsid);
	}

	@Override
	public List<CommentModel> findByUserId(Long userid) {
		String sql="SELECT * FROM comment WHERE userid=?";
		return query(sql,new CommentMapper(),userid);
	}

}
