package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.Role;

public class RoleMapper implements RowMapper<Role>{

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		Role obj = new Role(rs.getString("ID"),rs.getString("NAME"),rs.getString("LST_MOD_USER_ID"),rs.getString("ROLE_CATEGORY"),rs.getTimestamp("LST_MOD_TIME"));
		
		return obj;
	}

}
