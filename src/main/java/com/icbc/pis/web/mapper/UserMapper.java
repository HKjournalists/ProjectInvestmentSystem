package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.User;


public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		User obj = new User(rs.getString("user_id"),rs.getString("user_name"),rs.getString("email"),rs.getString("mobile"),rs.getString("ext"), rs.getTimestamp("create_time"));
		
		return obj;
	}

}
