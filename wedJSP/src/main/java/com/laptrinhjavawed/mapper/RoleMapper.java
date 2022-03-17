package com.laptrinhjavawed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavawed.model.RoleModel;

public class RoleMapper extends AbstractMapper implements RowMapper<RoleModel>{

	@Override
	public RoleModel mapRow(ResultSet resultSet){
		RoleModel roleModel=new RoleModel();
		try {
			CommonMapper(roleModel, resultSet);
			roleModel.setCode(resultSet.getString("code"));
			return roleModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
