package com.icbc.pis.deptrisk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.deptrisk.dao.IDeptRiskDao;
import com.icbc.pis.util.StringUtil;
import com.icbc.pis.web.mapper.DeptRiskMapper;
import com.icbc.pis.web.model.DeptRisk;
import com.icbc.pis.web.model.User;
@Repository("DeptRiskDao")
public class DeptRiskDao implements IDeptRiskDao{

	private static final Logger logger = LoggerFactory.getLogger(DeptRiskDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DeptRisk> getDeptRiskListByCondition(Map<String, String[]> filterMap) {
		Integer iStart = Integer.parseInt(StringUtil.getFirst(filterMap.get("start"))) + 1;
		String number = StringUtil.getFirst(filterMap.get("number"));
		Integer iEnd = iStart + Integer.parseInt(number) - 1;
		String end = iEnd.toString();
		String start = iStart.toString();
		String userId = StringUtil.getFirst(filterMap.get("user_id")) != null ? StringUtil.getFirst(filterMap.get("user_id")) : "";
		String taskDefName = StringUtil.getFirst(filterMap.get("task_def_name")) != null ? StringUtil.getFirst(filterMap.get("task_def_name")) : "";
		String productIdStr = StringUtil.getFirst(filterMap.get("productId")) != null ? StringUtil.getFirst(filterMap.get("productId")) : "";
		String productNameStr = StringUtil.getFirst(filterMap.get("productName")) != null ? StringUtil.getFirst(filterMap.get("productName")) : "" ;
		//暂未使用
		//String productType = StringUtil.getFirst(filterMap.get("productType")) != null ? StringUtil.getFirst(filterMap.get("productType")) : "" ;
		
		String sql =" SELECT TASK_ID, PRODUCT_ID, PRODUCT_NAME, STATUS, OPER， OPER_FLAG "
                     +" FROM (SELECT ROW_NUMBER() OVER(ORDER BY TA.CREATE_ DESC) ROW_NUM, "
                     +"              TA.DBID_ TASK_ID, "
                     +"              TA.EXECUTION_ID_ PRODUCT_ID, "
                     +"              TA.NAME_ PRODUCT_NAME, "
                     +"              TA.ACTIVITY_NAME_ STATUS, "
                     +"              TA.DBVERSION_ OPER, "
                     +"              TA.DBVERSION_ OPER_FLAG "
                     +"         FROM JBPM4_TASK TA "
                     +"        WHERE 1 = 1 "
                     +"          AND TA.TASKDEFNAME_ = ? "
                     +"          AND ( TA.ASSIGNEE_ IS NULL OR TA.ASSIGNEE_ = ? ) "
                     +"          AND TA.DBID_ LIKE ? "
                     +"          AND TA.NAME_ LIKE ? "
                     +" ) TT WHERE 1 = 1 "
                     +" AND TT.ROW_NUM BETWEEN ? AND ? ";
		
		List<DeptRisk> deptRiskList = new ArrayList<DeptRisk>(); 
		//对Like使用的参数进行 ‘％％’化处理
		String productId = StringUtil.likeWrap(productIdStr);
		String productName = StringUtil.likeWrap(productNameStr);
		
		deptRiskList = this.jdbcTemplate.query(sql ,new Object[] {taskDefName,userId,productId,productName,start,end}, new DeptRiskMapper() );
		
		return deptRiskList;
	}
	
	@Override
	public int count(){
		try{
			int cnt = this.jdbcTemplate.queryForObject("select count(*) from PIS_USER where STATUS = 1", Integer.class);
		
			return cnt;
		}catch(Exception e){
			logger.error(e.toString());
			
			return 0;
		}
	}
	
	@Override
	public boolean verifyDeptRisk(Map<String, String> paramMap) {
		String userId = paramMap.get("userId");
		String taskId = paramMap.get("taskId");
		String compliance = paramMap.get("compliance");
		String lawyer = paramMap.get("lawyer");
		String credit = paramMap.get("credit");
		String remark = paramMap.get("remark");
		
		String sql = " UPDATE PIS_USER "
				   + "    set NAME = ?,"
				   + "        STATUS = ?,"
				   + "		  EXT = ?,"
				   + "		  EMAIL = ?,"
				   + "		  MOBILE = ?,"
				   + "		  CARD_TYPE = ?,"
				   + "		  CARD_NO = ?,"
				   + "		  MODI_USER = ?,"
				   + "		  MODI_TIME = ? " 
				   + "  WHERE ID = ? ";
			
		//int affectedRows = this.jdbcTemplate.update(sql,compliance,lawyer,credit,remark,userId,taskId);
			
		//return affectedRows != 0;
		return true;
	}
	
}
