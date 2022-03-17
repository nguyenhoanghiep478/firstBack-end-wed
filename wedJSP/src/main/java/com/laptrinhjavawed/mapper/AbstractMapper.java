package com.laptrinhjavawed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavawed.model.AbstractModel;

public class AbstractMapper{
	public void CommonMapper(AbstractModel abstractModel,ResultSet resultSet) {
		try {
			abstractModel.setId(resultSet.getLong("id"));
			abstractModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			abstractModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			abstractModel.setCreatedBy(resultSet.getString("createdby"));
			abstractModel.setModifiedBy(resultSet.getString("modifiedby"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
