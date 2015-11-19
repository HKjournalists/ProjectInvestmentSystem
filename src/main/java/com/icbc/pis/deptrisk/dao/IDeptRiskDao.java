package com.icbc.pis.deptrisk.dao;


import java.util.List;
import java.util.Map;

import com.icbc.pis.web.model.DeptRisk;
 
public interface IDeptRiskDao {
	
	public List<DeptRisk> getDeptRiskListByCondition(Map<String, String[]> filterMap);
	
	public int count();
	
	public boolean verifyDeptRisk(Map<String, String> paramMap);

}
