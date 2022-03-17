package com.laptrinhjavawed.dao.impl;

import java.util.List;

import com.laptrinhjavawed.dao.IUserDAO;
import com.laptrinhjavawed.mapper.RowMapper;
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
	public List<UserModel> findById(Long id) {
		String sql="SELECT * FROM user WHERE id=?";
		return query(sql,new UserMapper(),id);
	}

}
