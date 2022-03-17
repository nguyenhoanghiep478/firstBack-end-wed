package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.model.UserModel;

public interface IUserService {
	List<UserModel> findAll();
	List<UserModel> findById(Long id);
	List<UserModel> findByRoleId(Long roleId);
}
