package com.laptrinhjavawed.dao.impl;

import java.util.List;

import com.laptrinhjavawed.dao.IRoleDAO;
import com.laptrinhjavawed.mapper.RoleMapper;
import com.laptrinhjavawed.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {

	@Override
	public List<RoleModel> findAll() {
		String sql="SELECT * FORM";
		return query(sql,new RoleMapper());
	}

	@Override
	public List<RoleModel> findById(Long id) {
		String sql="SELECT * FORM WHERE id=?";
		return query(sql,new RoleMapper(),id);
	}

}
