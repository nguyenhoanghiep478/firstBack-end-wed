package com.laptrinhjavawed.dao;

import java.util.List;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	List<UserModel> findAll(Pageble pageble);
	UserModel findOne(Long id);
	List<UserModel> findByRoleId(Long roleId);
	UserModel findOneByUserName(String userName);
	Long insert(UserModel userModel);
	UserModel findByUserNameAndPassWordAndStatus(String userName,String passWord,Integer status);
	void update(UserModel userModel);
	Integer getTotalItem();
}
