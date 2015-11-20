package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.ProductRaiseCreditType;

public class ProductRaiseCreditTypeMapper implements RowMapper<ProductRaiseCreditType>{

	@Override
	public ProductRaiseCreditType mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		ProductRaiseCreditType obj = new ProductRaiseCreditType(rs.getString("PRODUCT_ID"),rs.getString("RAISE_CREDIT_TYPE"));
		
		return obj;
	}

}