package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.model.CommentModel;

public interface ICommentDAO extends GenericDAO<CommentModel> {
	List<CommentModel> findAll();
	CommentModel findOne(Long id);
	List<CommentModel> findByNewsId(Long newsid);
	List<CommentModel> findByUserId(Long userid);
	Long insert(CommentModel commentModel);
	void update(CommentModel commentModel);
	void delete(Long id);
	void deleteByNewsId(Long newsId);
	void deleteByUserId(Long userId);
}
