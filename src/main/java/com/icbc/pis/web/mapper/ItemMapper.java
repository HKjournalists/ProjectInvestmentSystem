package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.ItemInfo;
import com.icbc.pis.web.model.Role;

public class ItemMapper implements RowMapper<ItemInfo> {

	@Override
	public ItemInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

		// TODO Auto-generated method stub

		ItemInfo obj = new ItemInfo(rs.getString("ID"), rs.getString("TEXT"), rs.getString("URL"),
				rs.getString("ITEM_TYPE"),rs.getString("ICON"),rs.getString("PARENT"),rs.getInt("ITEM_ORDER"));

		return obj;
	}

}
