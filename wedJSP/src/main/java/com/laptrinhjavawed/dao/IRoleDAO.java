package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.model.RoleModel;

public interface IRoleDAO{
	List<RoleModel> findAll();
	List<RoleModel> findById(Long id);
}
