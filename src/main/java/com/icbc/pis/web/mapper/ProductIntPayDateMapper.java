package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.ProductIntPayDate;

public class ProductIntPayDateMapper implements RowMapper<ProductIntPayDate>{

	@Override
	public ProductIntPayDate mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		ProductIntPayDate obj = new ProductIntPayDate(rs.getString("PRODUCT_ID"),rs.getString("INT_PAY_DATE"));
		
		return obj;
	}

}
