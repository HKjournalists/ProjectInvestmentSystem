package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.ProductElementSub;

public class ProductElementSubMapper implements RowMapper<ProductElementSub>{

	@Override
	public ProductElementSub mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		ProductElementSub obj = new ProductElementSub(rs.getString("PRODUCT_ID"),rs.getString("PRODUCT_NAME"),rs.getString("PRODUCT_TYPE"),rs.getString("ISSUER_NAME"));
		
		return obj;
	}

}
