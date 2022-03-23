package com.laptrinhjavawed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.dao.ICommentDAO;
import com.laptrinhjavawed.model.CommentModel;
import com.laptrinhjavawed.service.ICommentService;

public class CommentService implements ICommentService{
	@Inject
	private ICommentDAO comment;
	@Override
	public List<CommentModel> findAll() {
		return comment.findAll();
	}

	@Override
	public CommentModel findOne(Long id) {
		return comment.findOne(id);
	}

	@Override
	public List<CommentModel> findByNewsId(Long newsid) {
		return comment.findByNewsId(newsid);
	}

	@Override
	public List<CommentModel> findByUserId(Long userid){
		return comment.findByUserId(userid);
	}

	@Override
	public CommentModel save(CommentModel commentModel) {
		Long commentId= comment.insert(commentModel);
		return comment.findOne(commentId);
	}

	@Override
	public CommentModel update(CommentModel commentModel) {
		comment.update(commentModel);
		return comment.findOne(commentModel.getId());
	}

	@Override
	public void delete(Long[] deleteIds) {
		for (Long id : deleteIds) {
			comment.delete(id);
		}
	}

}
