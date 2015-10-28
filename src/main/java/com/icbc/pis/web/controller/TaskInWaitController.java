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

import com.icbc.pis.datastruct.PaginationStruct;
import com.icbc.pis.datastruct.TaskInfo;
import com.icbc.pis.taskinwait.service.impl.TaskInWaitService;
import com.icbc.pis.util.StringUtil;

@Controller
@RequestMapping("/taskInWait")
public class TaskInWaitController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);

	@Autowired
	private TaskInWaitService taskInWaitService;
	
	@RequestMapping("/takeTask")
	@ResponseBody
	public boolean takeTask(HttpSession httpSession,HttpServletRequest request)
	{
		try
		{
			String userId = (String) httpSession.getAttribute("userId");
			
			String taskId = request.getParameter("taskId");
			
			if(StringUtil.isNullOrEmpty(userId) && StringUtil.isNullOrEmpty(taskId))
			{
				return false;
			}
			else
			{
				return this.taskInWaitService.takeTask(taskId, userId);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
		
	}
	
	@RequestMapping("/getTasks")
	@ResponseBody
	public PaginationStruct getTasks(HttpSession httpSession,HttpServletRequest request)
	{
		String userId = (String) httpSession.getAttribute("userId");
		
		List<TaskInfo> persionalTasks = this.taskInWaitService.getPersonalTasks(userId);
		
		List<TaskInfo> groupTasks = this.taskInWaitService.getGroupTasks(userId);
		
		List<TaskInfo> allTasks = new ArrayList<TaskInfo>();
		
		if(null != persionalTasks)
		{
			allTasks.addAll(persionalTasks);
		}
		
		if(null != groupTasks)
		{
			allTasks.addAll(groupTasks);
		}
		
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();
		
		Integer iStart = Integer.parseInt(request.getParameter("start"));
		
		Integer iEnd = iStart + Integer.parseInt(request.getParameter("number"));
		
		iEnd = (iEnd < allTasks.size()) ? iEnd :  allTasks.size();
		
		for(int i = iStart ; i < iEnd ; ++i)
		{
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
