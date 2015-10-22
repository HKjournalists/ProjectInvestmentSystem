package com.icbc.pis.workflow.service;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icbc.pis.util.StringUtil;

@Component("ExecutionServiceProxy")
public class ExecutionServiceProxy implements ServiceProxyInterface {

	@Autowired
	private ExecutionService executionService;
	
	@Autowired
	private TaskService taskService;
	
	public boolean Proceed(String repoName,String productId,String taskId)
	{
		try{
			
			if(StringUtil.isNullOrEmpty(repoName))
			{
				return false;
			}
			
			if(StringUtil.isNullOrEmpty(taskId))
			{
				this.executionService.startProcessInstanceByKey(repoName,productId);
				
				return true;
			}
			
			if(!this.IsExists(repoName + "." + productId))
			{
				this.executionService.startProcessInstanceByKey(repoName,productId);
				
				return true;
			}
			
			this.taskService.completeTask(taskId);
			
			return true;
			
		}
		catch(Exception e)
		{

			return false;
		}
		

	}
	
	public boolean IsExists(String id)
	{
		try
		{
			ProcessInstance pi = executionService.findProcessInstanceById(id);
			
			
			if(pi != null)
			{
				return true;
			}
			
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
		
	 
		
	}
//	
}
