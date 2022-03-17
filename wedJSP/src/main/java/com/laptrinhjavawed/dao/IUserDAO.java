package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.model.UserModel;

public interface IUserDAO{
	List<UserModel> findAll();
	List<UserModel> findById(Long id);
	List<UserModel> findByRoleId(Long roleId);
}
