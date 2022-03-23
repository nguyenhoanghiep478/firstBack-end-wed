package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.model.RoleModel;

public interface IRoleService {
	List<RoleModel> findAll();
	RoleModel findOne(Long id);
	RoleModel save(RoleModel roleModel);
}
