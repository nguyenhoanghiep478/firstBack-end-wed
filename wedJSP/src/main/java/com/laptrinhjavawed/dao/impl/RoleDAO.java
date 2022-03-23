package com.laptrinhjavawed.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavawed.dao.IRoleDAO;
import com.laptrinhjavawed.mapper.RoleMapper;
import com.laptrinhjavawed.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {

	@Override
	public List<RoleModel> findAll() {
		String sql="SELECT * From role";
		return query(sql,new RoleMapper());
	}

	@Override
	public RoleModel findOne(Long id) {
		StringBuilder sql= new StringBuilder("SELECT * FROM");
		sql.append(" role WHERE id=?");
		List<RoleModel> result=new ArrayList<RoleModel>();
		result=query(sql.toString(),new RoleMapper(),id);
		return result.isEmpty()? null:result.get(0);
	}

	@Override
	public Long insert(RoleModel roleModel) {
		StringBuilder sql=new StringBuilder("insert into ");
		sql.append("role(name,code) values(?,?) ");
		return save(sql.toString(), roleModel.getName(),roleModel.getCode());
	}

}
