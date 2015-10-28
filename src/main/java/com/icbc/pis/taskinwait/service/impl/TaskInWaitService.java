package com.icbc.pis.taskinwait.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icbc.pis.datastruct.TaskInfo;
import com.icbc.pis.taskinwait.service.ITaskInWaitService;
import com.icbc.pis.util.StringUtil;

@Service("TaskInWaitService")
public class TaskInWaitService implements ITaskInWaitService {

	@Autowired
	private TaskService taskService;

	
	private TaskInfo generateTaskInfo(Task task,OperationEnum oper)
	{
		try
		{
			TaskInfo taskInfo = new TaskInfo(task,oper);
			
			//TO DO: assign the product name by product id...
			
			
			return taskInfo;
		}
		catch(Exception e)
		{
			return null;
		}

	}
	
	@Override
	public boolean takeTask(String taskId,String userId)
	{
		try
		{
			this.taskService.takeTask(taskId, userId);
			
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	@Override
	public List<TaskInfo> getPersonalTasks(String userId) {
		// TODO Auto-generated method stub
		
		try
		{
			if(StringUtil.isNullOrEmpty(userId))
			{
				return null;
			}
			
			List<TaskInfo> taskInfoList = new ArrayList<TaskInfo>();
			
			List<Task> tasks = this.taskService.createTaskQuery().assignee(userId).list();
			
			for(Task tsk : tasks)
			{
				taskInfoList.add(this.generateTaskInfo(tsk, OperationEnum.handle));
			}
			
			return taskInfoList;
		}
		catch(Exception e)
		{
			return null;
		}

	}

	@Override
	public List<TaskInfo> getGroupTasks(String userId) {
		// TODO Auto-generated method stub
		try
		{
			if(StringUtil.isNullOrEmpty(userId))
			{
				return null;
			}
			
			List<Task> tasks = this.taskService.findGroupTasks(userId);
			
			List<TaskInfo> taskInfoList = new ArrayList<TaskInfo>();
					
			for(Task tsk : tasks)
			{
				taskInfoList.add(this.generateTaskInfo(tsk, OperationEnum.checkout));
			}
			
			return taskInfoList;
		}
		catch(Exception e)
		{
			return null;
		}

	}

}
