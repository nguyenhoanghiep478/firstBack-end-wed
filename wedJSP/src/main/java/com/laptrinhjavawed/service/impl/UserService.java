package com.laptrinhjavawed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.dao.IUserDAO;
import com.laptrinhjavawed.model.UserModel;
import com.laptrinhjavawed.service.IUserService;

public class UserService implements IUserService {
	@Inject
	private IUserDAO user;
	@Override
	public List<UserModel> findAll() {
		return user.findAll();
	}

	@Override
	public List<UserModel> findById(Long id) {
		return user.findById(id);
	}

	@Override
	public List<UserModel> findByRoleId(Long roleId) {
		return user.findByRoleId(roleId);
	}
}
