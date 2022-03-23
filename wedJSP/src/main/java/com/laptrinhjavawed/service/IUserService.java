package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.model.UserModel;

public interface IUserService {
	List<UserModel> findAll();
	UserModel findOne(Long id);
	List<UserModel> findByRoleId(Long roleId);
	UserModel save(UserModel userModel);
	UserModel findByUserNameAndPassWordAndStatus(String userName,String passWord,Integer status);;
}
