package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.User;


public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		User u = new User(rs.getString("ID"), rs.getString("BRANCH_ID"), rs.getString("NAME"),
				rs.getString("STATUS"), rs.getString("PHONE_NO"),
				rs.getString("EMAIL"), rs.getString("MOBILE"), 
				rs.getString("INTERIOR_FLAG"), rs.getString("CARD_TYPE"), 
				rs.getString("CARD_NO"), rs.getString("MODI_USER"),rs.getTimestamp("MODI_TIME"),
				rs.getTimestamp("LAST_LOGIN"),rs.getString("WHITE_LIST"));
		return u;
	}

}
