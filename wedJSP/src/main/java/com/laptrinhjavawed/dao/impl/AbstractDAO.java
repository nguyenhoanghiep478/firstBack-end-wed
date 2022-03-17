package com.laptrinhjavawed.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Timestamp;
import com.laptrinhjavawed.dao.GenericDAO;
import com.laptrinhjavawed.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tables";
			String username = "root";
			String password = "Hiep31082003";
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setParameter(PreparedStatement statement, Object... parameters) throws SQLException {
		for (int i = 1; i <= parameters.length; i++) {
			Object parameter = parameters[i - 1];
			if (parameter instanceof Long) {
				statement.setLong(i, (Long) parameter);
			} else if (parameter instanceof String) {
				statement.setString(i, (String) parameter);
			} else if (parameter instanceof Timestamp) {
				statement.setTimestamp(i, (java.sql.Timestamp) parameter);
			}else if(parameter instanceof Integer) {
				statement.setInt(i,(Integer)parameter);
			}
		}
	}

	public void closeObject(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			if (parameters.length != 0) {
				setParameter(statement, parameters);
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeObject(connection, statement, resultSet);
		}

		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate(sql);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			closeObject(connection, statement, resultSet);
		}

	}

	@Override
	public Long save(String sql, Object... parameters) {
		Long id=0L;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet=statement.getGeneratedKeys();
			if(resultSet.next()) {
				id=resultSet.getLong(1);
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			closeObject(connection, statement, resultSet);
		}
		return id;

	}

}
