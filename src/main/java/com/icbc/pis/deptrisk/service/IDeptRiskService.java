package com.icbc.pis.deptrisk.service;

import java.util.List;
import java.util.Map;

import com.icbc.pis.datastruct.TaskInfo;
import com.icbc.pis.web.model.DeptRisk;

public interface IDeptRiskService {
	
	public List<DeptRisk> getDeptRiskListByCondition(Map<String, String[]> filterCond);
	
	public int count();
	
	public boolean verifyDeptRisk(Map<String, String> paramMap);
	
	public List<TaskInfo> getPersonalTasks(String userId);
	
	public List<TaskInfo> getGroupTasks(String userId);
}
