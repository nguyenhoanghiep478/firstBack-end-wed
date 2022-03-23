package com.laptrinhjavawed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavawed.model.RoleModel;
import com.laptrinhjavawed.model.UserModel;

public class UserMapper extends AbstractMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
				UserModel userModel=new UserModel();
				CommonMapper(userModel, resultSet);
				userModel.setRoleId(resultSet.getLong("roleid"));
				userModel.setFullName(resultSet.getString("fullname"));
				userModel.setUserName(resultSet.getString("name"));
				userModel.setPassword(resultSet.getString("password"));
				userModel.setStatus(resultSet.getBoolean("status"));
				try {
					RoleModel role= new RoleModel();
					role.setCode(resultSet.getString("code"));
					role.setName(resultSet.getString("name"));
					userModel.setRole(role);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				return userModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
