package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.TradeLevel;

public class TradeLevelMapper implements RowMapper<TradeLevel>{

	@Override
	public TradeLevel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		TradeLevel obj = new TradeLevel(rs.getString("TRADE_CODE"),rs.getString("TRADE_NAME"),rs.getString("PARENT_CODE"),rs.getString("TRADE_LEVEL"));
		
		return obj;
	}

}
