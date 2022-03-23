package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.model.RoleModel;

public interface IRoleDAO extends GenericDAO<RoleModel>{
	List<RoleModel> findAll();
	RoleModel findOne(Long id);
	Long insert(RoleModel roleModel);
}
