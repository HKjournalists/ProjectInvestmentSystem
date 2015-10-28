package com.icbc.pis.web.controller;

import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.icbc.pis.annotation.AutoWorkFlow;

@Controller
@RequestMapping("/jbpmtest")
public class JBPMTestController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/getTaskInWaiting")
	@ResponseBody
	public List<Map<String,String>> getTaskInWaiting(HttpServletRequest request)
	{
		String userId = request.getParameter("user_id");
		
		List<Task> taskList = this.taskService.findGroupTasks(userId); 
		
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();
		
		for(Task task : taskList)
		{
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("id", task.getId());
			
			map.put("name",task.getName());
			
			resList.add(map);
		}
		
		return resList;
	}
	
	
	@RequestMapping("/getAllTask")
	@ResponseBody
	public List<Map<String, String>> GetAllTaskList(HttpServletRequest request)
	{
		
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();
		List<Task> taskList =  this.taskService.createTaskQuery().list();
		
		for(Task task : taskList)
		{
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("id", task.getId());
			
			map.put("name",task.getName());
			
			resList.add(map);
		}
		
		return resList;
		
	}
	
	@RequestMapping("/start")
	@ResponseBody
	@AutoWorkFlow
	public String start(HttpServletRequest request)
	{
    	String taskId = request.getParameter("WKF_TASK_ID");
    	String productId = request.getParameter("WKF_RPODUCT_ID");
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(taskId);
		System.out.println(productId);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		return "a";
		
	}
	
	@RequestMapping("/start2")
	@ResponseBody
	@AutoWorkFlow
	public void start2(HttpServletRequest request)
	{
    	String taskId = request.getParameter("WKF_TASK_ID");
    	String productId = request.getParameter("WKF_RPODUCT_ID");
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(taskId);
		System.out.println(productId);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		//return "";
		
	}
	
}
