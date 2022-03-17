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
	public List<CommentModel> findById(Long id) {
		return comment.findById(id);
	}

	@Override
	public List<CommentModel> findByNewsId(Long newsid) {
		return comment.findByNewsId(newsid);
	}

	@Override
	public List<CommentModel> findByUserId(Long userid){
		return comment.findByUserId(userid);
	}

}
