package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.model.CommentModel;

public interface ICommentDAO {
	List<CommentModel> findAll();
	List<CommentModel> findById(Long id);
	List<CommentModel> findByNewsId(Long newsid);
	List<CommentModel> findByUserId(Long userid);
}
