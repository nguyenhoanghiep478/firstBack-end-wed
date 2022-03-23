package com.laptrinhjavawed.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
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
	public CommentModel findOne(Long id) {
		String sql="SELECT * FROM comment WHERE id=?";
		List<CommentModel> result=new ArrayList<CommentModel>();
		result=query(sql,new CommentMapper(),id);
		return result.isEmpty()? null:result.get(0);
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
	public Long insert(CommentModel commentModel) {
			setDate(commentModel);
			commentModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			commentModel.setModifiedBy("modifier");
			StringBuilder sql=new StringBuilder("insert into ");
			sql.append("comment(newsid,userid,content,createddate,modifieddate)values(?,?,?,?,?)");
			return save(sql.toString(), commentModel.getNewsId(),commentModel.getUserId(),commentModel.getContent(),commentModel.getCreatedDate(),commentModel.getModifiedDate());
	}

	@Override
	public void update(CommentModel commentModel) {
		commentModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		commentModel.setModifiedBy("modifier");
		StringBuilder sql=new StringBuilder("update ");
		sql.append("tables.comment set(content=?,modifieddate=?,modifiedby=?) where id=?");
		update(sql.toString(), commentModel.getContent(),commentModel.getModifiedDate(),commentModel.getModifiedBy(),commentModel.getId());
	}

	@Override
	public void delete(Long id) {
		String sql="delete From tables.comment where id=?";
		update(sql, id);
	}

	@Override
	public void deleteByNewsId(Long newsId) {
		String sql="delete From tables.comment where newsid=?";
		update(sql,newsId);
	}

	@Override
	public void deleteByUserId(Long userId) {
		String sql="delete From tables.comment where userid=?";
		update(sql,userId);
	}	
}
