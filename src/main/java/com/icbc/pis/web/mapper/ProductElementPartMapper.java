package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.ProductElement;

public class ProductElementPartMapper implements RowMapper<ProductElement>{

	@Override
	public ProductElement mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		ProductElement obj = new ProductElement(rs.getString("PRODUCT_ID"),
												rs.getString("PRODUCT_NAME"),
												rs.getString("PRODUCT_TYPE"),
												rs.getString("ISSUER_NAME"),
												Integer.parseInt(rs.getString("MATURITY_YEAR")),
												Double.parseDouble(rs.getString("ISSUE_SCALE")),
												rs.getString("IS_INCLUDE_RIGHT"),
												rs.getString("RIGHT_TYPE")
												);
		
		return obj;
	}

}
