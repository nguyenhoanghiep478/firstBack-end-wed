package com.laptrinhjavawed.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.dao.INewsDAO;
import com.laptrinhjavawed.mapper.NewsMapper;
import com.laptrinhjavawed.model.NewsModel;
import com.laptrinhjavawed.model.UserModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {
	@Override
	public List<NewsModel> findByCategoryID(Long categoryId) {
		StringBuilder sql=new StringBuilder("SELECT * FROM");
		sql.append(" news WHERE categoryid=?");
		return query(sql.toString(),new NewsMapper(),categoryId);
	}
	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		StringBuilder sql=new StringBuilder("SELECT * FROM tables.news") ;
		if(pageble.getSorter().getSortName()!=null&&pageble.getSorter().getSortName()!=null) {
			sql.append(" ORDER BY"+" "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy());
		}
		if(pageble.getOffSet()!=null&&pageble.getLimit()!=null) {
			sql.append(" Limit ?,?");
			return query(sql.toString(),new NewsMapper(),pageble.getOffSet(),pageble.getLimit());
		}else {
			return query(sql.toString(),new NewsMapper());
		}
	}
	@Override
	public NewsModel findOne(Long id) {
		StringBuilder sql= new StringBuilder("SELECT * FROM");
		sql.append(" news WHERE id=?");
		List<NewsModel> result=new ArrayList<NewsModel>();
		result= query(sql.toString(), new NewsMapper(), id);
		return result.isEmpty()? null:result.get(0);
	}
	@Override
	public Long insert(NewsModel newsModel) {
			setDate(newsModel);
			newsModel.setCreatedBy("creater");
			newsModel.setModifiedBy("modifier");
			StringBuilder sql= new StringBuilder("INSERT INTO ");
			sql.append("news(categoryid,title,shortdesciption,content,thumbnail,createddate,createdby,modifieddate,modifiedby) values(?,?,?,?,?,?,?,?,?)");
			return save(sql.toString(),newsModel.getCategoryId(),newsModel.getTitle(),newsModel.getShortDescription(),newsModel.getContent(),newsModel.getThumbnail(),newsModel.getCreatedDate(),newsModel.getCreatedBy(),newsModel.getModifiedDate(),newsModel.getModifiedBy());
	}
	public void delete(Long id) {
		StringBuilder sql= new StringBuilder("DELETE FROM ");
		sql.append("news where id=?");
		update(sql.toString(),id);
	}
	public void update(NewsModel newsModel) {
		newsModel.setModifiedBy("modifier");
		newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		StringBuilder sql= new StringBuilder("UPDATE ");
		sql.append("tables. news Set content=?,");
		sql.append("shortdesciption=?,");
		sql.append("title=?,thumbnail=?,modifiedby=?,modifieddate=?");
		sql.append("Where id=?");
		update(sql.toString(), newsModel.getContent(),newsModel.getShortDescription(),newsModel.getTitle(),newsModel.getThumbnail(),newsModel.getModifiedBy(),newsModel.getModifiedDate(),newsModel.getId());
	}
	public Integer getTotalItem() {
			StringBuilder sql=new StringBuilder("Select count(*) from tables.news");
			return count(sql.toString());
	}
	
}
