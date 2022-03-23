package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	List<UserModel> findAll();
	UserModel findOne(Long id);
	List<UserModel> findByRoleId(Long roleId);
	Long insert(UserModel userModel);
	UserModel findByUserNameAndPassWordAndStatus(String userName,String passWord,Integer status);
}
