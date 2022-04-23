package com.laptrinhjavawed.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.dao.IUserDAO;
import com.laptrinhjavawed.mapper.NewsMapper;
import com.laptrinhjavawed.mapper.UserMapper;
import com.laptrinhjavawed.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		StringBuilder sql=new StringBuilder("Select * from tables.user ");
		if(pageble.getSorter().getSortName()!=null&&pageble.getSorter().getSortBy()!=null) {
			sql.append(" ORDER BY"+" "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy());
		}
		if(pageble.getOffSet()!=null&&pageble.getLimit()!=null) {
			sql.append(" Limit ?,?");
			return query(sql.toString(), new UserMapper(), pageble.getOffSet(),pageble.getLimit());
		}else {
			return query(sql.toString(),new UserMapper());
		}
	}

	@Override
	public List<UserModel> findByRoleId(Long roleid) {
		String sql="SELECT * FROM user WHERE roleid=?";
		return query(sql,new UserMapper(),roleid);
	}

	@Override
	public UserModel findOne(Long id) {
		String sql="SELECT * FROM user WHERE id=?";
		List<UserModel> result=new ArrayList<UserModel>();
		result=query(sql,new UserMapper(),id);
		return result.isEmpty()? null:result.get(0);
	}

	@Override
	public Long insert(UserModel userModel) {
		setDate(userModel);
		Long roleId;
		String sql="insert into tables.user(roleid,fullname,username,password,status,createddate,modifieddate) values(?,?,?,?,?,?,?)";
		if(userModel.getRoleId()!=null) {
			roleId=userModel.getRoleId();
		}else {
			roleId=2L;
		}
		return save(sql,roleId,userModel.getFullName(),userModel.getUserName(),userModel.getPassword(),1,userModel.getCreatedDate(),userModel.getModifiedDate());
	}
	@Override
	public UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord,Integer status){
		StringBuilder sql=new StringBuilder("Select * from tables.user as u");
		sql.append(" inner join tables.role as r on r.id=u.roleid");
		sql.append(" where username=? AND password=?AND status=?");
		List<UserModel> result=query(sql.toString(), new UserMapper(),userName,passWord,status);
		return result.isEmpty()? null:result.get(0);
	}

	@Override
	public void update(UserModel userModel) {
		StringBuilder sql=new StringBuilder("UPDATE tables.user ");
		sql.append("Set(roleid=?,username=?,password=?,fullname=?,status=?) Where id=?");
		update(sql.toString(),userModel.getRoleId(),userModel.getUserName(),userModel.getPassword(),userModel.getFullName(),1,userModel.getId());
	}
	@Override
	public UserModel findOneByUserName(String userName) {
		StringBuilder sql=new StringBuilder("Select * from tables.user where username=?");
		 List<UserModel> result=query(sql.toString(), new UserMapper(),userName);
		 return result.isEmpty()? null:result.get(0);
	}
	@Override
	public Integer getTotalItem() {
		StringBuilder sql=new StringBuilder("Select count(*) from tables.user");
		return count(sql.toString());
}
}
