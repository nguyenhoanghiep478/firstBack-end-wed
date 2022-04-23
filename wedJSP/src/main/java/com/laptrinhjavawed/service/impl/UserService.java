package com.laptrinhjavawed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.dao.IUserDAO;
import com.laptrinhjavawed.model.UserModel;
import com.laptrinhjavawed.service.IUserService;

public class UserService implements IUserService {
	@Inject
	private IUserDAO user;
	@Override
	public List<UserModel> findAll(Pageble pageble) {
		return user.findAll(pageble);
	}

	@Override
	public UserModel findOne(Long id) {
		return user.findOne(id);
	}

	@Override
	public List<UserModel> findByRoleId(Long roleId) {
		return user.findByRoleId(roleId);
	}

	@Override
	public UserModel save(UserModel userModel) {
		Long userId= user.insert(userModel);
		return user.findOne(userId);
	}


	@Override
	public 	UserModel findByUserNameAndPassWordAndStatus(String userName,String passWord,Integer status){
		return user.findByUserNameAndPassWordAndStatus(userName, passWord, status);
	}

	@Override
	public UserModel update(UserModel userModel) {
		user.update(userModel);
		return user.findOne(userModel.getId());
	}

	@Override
	public UserModel findOneByUserName(String userName) {
		return user.findOneByUserName(userName);
	}
	@Override
	public Integer getTotalItem() {
		return user.getTotalItem();
	}
}
