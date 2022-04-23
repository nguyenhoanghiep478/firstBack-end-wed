package com.laptrinhjavawed.service;

import java.util.List;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.model.UserModel;

public interface IUserService {
	List<UserModel> findAll(Pageble pageble);
	UserModel findOne(Long id);
	List<UserModel> findByRoleId(Long roleId);
	UserModel save(UserModel userModel);
	UserModel findByUserNameAndPassWordAndStatus(String userName,String passWord,Integer status);
	UserModel update(UserModel userModel);
	UserModel findOneByUserName(String userName);
	Integer getTotalItem();
}
