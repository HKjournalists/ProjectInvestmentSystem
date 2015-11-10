package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.DictItem;


public class DictItemMapper implements RowMapper<DictItem>{

	@Override
	public DictItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		DictItem u = new DictItem(rs.getString("KIND_ID"),rs.getString("KIND_NAME"));
		
		return u;
	}

}

