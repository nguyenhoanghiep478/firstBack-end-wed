package com.laptrinhjavawed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.dao.IRoleDAO;
import com.laptrinhjavawed.model.RoleModel;
import com.laptrinhjavawed.service.IRoleService;

public class RoleService implements IRoleService{
	@Inject
	private IRoleDAO role;
	@Override
	public List<RoleModel> findAll() {
		return role.findAll();
	}

	@Override
	public List<RoleModel> findById(Long id) {
		return role.findById(id);
	}
}
