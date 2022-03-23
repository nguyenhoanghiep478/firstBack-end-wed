package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.model.CommentModel;

public interface ICommentService {
	List<CommentModel> findAll();
	CommentModel save(CommentModel commentModel);
	CommentModel findOne(Long id);
	List<CommentModel> findByNewsId(Long newsid);
	List<CommentModel> findByUserId(Long userid);
	CommentModel update(CommentModel commentModel);
	void delete(Long[] deleteIds);
}
