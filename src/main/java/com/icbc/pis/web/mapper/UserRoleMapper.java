package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.Role;
import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;

public class UserRoleMapper implements RowMapper<UserRole>{
	@Override
	public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		UserRole obj = new UserRole(rs.getString("USER_ID"),rs.getString("ROLE_ID"));
		
		return obj;
	}
}
