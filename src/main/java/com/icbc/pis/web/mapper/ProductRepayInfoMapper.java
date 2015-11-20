package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.util.DoubleUtil;
import com.icbc.pis.web.model.ProductRepayInfo;

public class ProductRepayInfoMapper implements RowMapper<ProductRepayInfo>{

	@Override
	public ProductRepayInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		ProductRepayInfo obj = new ProductRepayInfo(rs.getString("PRODUCT_ID"),rs.getString("REPAY_TIME"),DoubleUtil.parseDouble(rs.getString("REPAY_AMT")));
		
		return obj;
	}

}