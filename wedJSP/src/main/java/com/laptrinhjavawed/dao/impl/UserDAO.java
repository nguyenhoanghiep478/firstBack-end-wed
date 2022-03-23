package com.laptrinhjavawed.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavawed.dao.IUserDAO;
import com.laptrinhjavawed.mapper.UserMapper;
import com.laptrinhjavawed.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public List<UserModel> findAll() {
		String sql="SELECT * FROM user";
		return query(sql,new UserMapper());
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
		String sql="insert into user(roleid,fullname,username,password,createddate,modifieddate) values(?,?,?,?,?,?)";
		return save(sql, userModel.getRoleId(),userModel.getFullName(),userModel.getUserName(),userModel.getPassword(),userModel.getCreatedDate(),userModel.getModifiedDate());
	}
	@Override
	public UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord,Integer status){
		StringBuilder sql=new StringBuilder("Select * from tables.user as u");
		sql.append(" inner join tables.role as r on r.id=u.id");
		sql.append(" where username=? AND password=?AND status=?");
		List<UserModel> result=query(sql.toString(), new UserMapper(),userName,passWord,status);
		return result.isEmpty()? null:result.get(0);
	}

}
