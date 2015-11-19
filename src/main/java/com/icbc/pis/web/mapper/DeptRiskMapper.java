package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.util.StringUtil;
import com.icbc.pis.web.model.DeptRisk;


public class DeptRiskMapper implements RowMapper<DeptRisk>{

	@Override
	public DeptRisk mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DeptRisk deptRisk = new DeptRisk(
				rs.getString("TASK_ID"), 
				StringUtil.getSplitStrByIndex(rs.getString("PRODUCT_ID"), 1),
				rs.getString("PRODUCT_NAME"),
				rs.getString("STATUS"),
				rs.getString("OPER"),
				rs.getString("OPER_FLAG")
			);
		return deptRisk;
	}
	
	
}
