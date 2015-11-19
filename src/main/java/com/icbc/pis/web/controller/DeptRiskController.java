package com.icbc.pis.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icbc.pis.annotation.AutoWorkFlow;
import com.icbc.pis.datastruct.PaginationStruct;
import com.icbc.pis.datastruct.TaskInfo;
import com.icbc.pis.deptrisk.service.impl.DeptRiskService;
import com.icbc.pis.web.model.DeptRisk;
import com.icbc.pis.workflow.activity.ActivityNameEnum;

@Controller
@RequestMapping("/deptrisk")
public class DeptRiskController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);

	@Autowired
	private DeptRiskService deptRiskService;
	
	@RequestMapping("/getDeptRiskListByCondition")
	@ResponseBody
	public PaginationStruct getDeptRiskListByCondition(HttpSession httpSession,HttpServletRequest request){
		Map<String,String[]> filterCond =  new HashMap<String, String[]>(request.getParameterMap());
		//组装userId数组
		String userId = httpSession.getAttribute("userId") != null ? (String)httpSession.getAttribute("userId") : "";
		String userIds[] = new String[1];
		userIds[0] = userId;
		//组装taskDefNames数组
		String taskDefName = ActivityNameEnum.dept_risk_verify.getEngName();
		String taskDefNames[] = new String[1];
		taskDefNames[0] = taskDefName;
		//放入参数Map中
		filterCond.put("user_id", userIds);
		filterCond.put("task_def_name", taskDefNames);
		//执行查询
		List<DeptRisk> deptRiskList = this.deptRiskService.getDeptRiskListByCondition(filterCond);
		
		List<Map<String, String>> returnList = new ArrayList<Map<String, String>>();
		if (deptRiskList != null){	
			for(DeptRisk deptRisk : deptRiskList){
				Map<String, String> map = new HashMap<String, String>();
				map.put("taskId", deptRisk.getTaskId());
				map.put("productId", deptRisk.getProductId());
				map.put("productName", deptRisk.getProductName());
				map.put("status", deptRisk.getStatus());
				map.put("oper", deptRisk.getOper());
				map.put("operFlag", deptRisk.getOperFlag());
								
				returnList.add(map);
			}
		}
		
		PaginationStruct paginationStruct = new PaginationStruct(returnList.size(),returnList);
		
		return paginationStruct;
	}
	
	//暂存
	@RequestMapping("/onPreSave")
	public String onPreSave(HttpSession httpSession,HttpServletRequest request){
		Map<String,String> paramMap =  new HashMap<String,String>();
		//获取参数
		String userId = httpSession.getAttribute("userId") != null ? (String)httpSession.getAttribute("userId") : "";
		String taskId = request.getParameter("taskId") != null ? request.getParameter("taskId").toString() : "";
		String compliance = request.getParameter("compliance") != null ? request.getParameter("compliance").toString() : "";
		String lawyer = request.getParameter("lawyer") != null ? request.getParameter("lawyer").toString() : "";
		String credit = request.getParameter("credit") != null ? request.getParameter("credit").toString() : "";
		String remark = request.getParameter("remark") != null ? request.getParameter("remark").toString() : "";
		//将参数放入Map中
		paramMap.put("userId", userId);
		paramMap.put("taskId", taskId);
		paramMap.put("compliance", compliance);
		paramMap.put("lawyer", lawyer);
		paramMap.put("credit", credit);
		paramMap.put("remark", remark);
		
		this.deptRiskService.verifyDeptRisk(paramMap);
		
		return "redirect:/views/index.html";
	}
	
	@RequestMapping("/verifyDeptRisk")
	@AutoWorkFlow//驱动工作流
	public String verifyDeptRisk(HttpSession httpSession,HttpServletRequest request){
		Map<String,String> paramMap =  new HashMap<String,String>();
		//获取参数
		String userId = httpSession.getAttribute("userId") != null ? (String)httpSession.getAttribute("userId") : "";
		String taskId = request.getParameter("taskId") != null ? request.getParameter("taskId").toString() : "";
		String compliance = request.getParameter("compliance") != null ? request.getParameter("compliance").toString() : "";
		String lawyer = request.getParameter("lawyer") != null ? request.getParameter("lawyer").toString() : "";
		String credit = request.getParameter("credit") != null ? request.getParameter("credit").toString() : "";
		String remark = request.getParameter("remark") != null ? request.getParameter("remark").toString() : "";
		//将参数放入Map中
		paramMap.put("userId", userId);
		paramMap.put("taskId", taskId);
		paramMap.put("compliance", compliance);
		paramMap.put("lawyer", lawyer);
		paramMap.put("credit", credit);
		paramMap.put("remark", remark);
		
		this.deptRiskService.verifyDeptRisk(paramMap);

		return "redirect:/views/index.html";
	}
	
	//使用引擎查询－测试用
	@RequestMapping("/getDeptRiskTasks")
	@ResponseBody
	public PaginationStruct getDeptRiskTasks(HttpSession httpSession,HttpServletRequest request) {
		String userId = httpSession.getAttribute("userId")!=null?(String)httpSession.getAttribute("userId").toString():"555010457";
		List<TaskInfo> persionalTasks = this.deptRiskService.getPersonalTasks(userId);
		List<TaskInfo> groupTasks = this.deptRiskService.getGroupTasks(userId);
		List<TaskInfo> allTasks = new ArrayList<TaskInfo>();
		if(null != persionalTasks){
			allTasks.addAll(persionalTasks);
		}
		if(null != groupTasks){
			allTasks.addAll(groupTasks);
		}
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();
		Integer iStart = Integer.parseInt(request.getParameter("start"));
		Integer iEnd = iStart + Integer.parseInt(request.getParameter("number"));
		iEnd = (iEnd < allTasks.size()) ? iEnd :  allTasks.size();
		for(int i = iStart ; i < iEnd ; ++i){
			Map<String, String> map = new HashMap<String, String>();
			map.put("taskId", allTasks.get(i).getTask().getId());
			map.put("productId", allTasks.get(i).getProductId());
			map.put("productName", allTasks.get(i).getProductName());
			map.put("status", allTasks.get(i).getActivity());
			map.put("oper", allTasks.get(i).getOper().getOperation());
			
			resList.add(map);
		}
		PaginationStruct paginationStruct = new PaginationStruct(allTasks.size(),resList);
		
		return paginationStruct;	
	}
}
