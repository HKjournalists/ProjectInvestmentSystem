package com.icbc.pis.taskinwait.service;

import java.util.List;

import com.icbc.pis.datastruct.TaskInfo;

public interface ITaskInWaitService {

	public boolean takeTask(String taskId,String userId);
	
	public List<TaskInfo> getPersonalTasks(String userId);
	
	public List<TaskInfo> getGroupTasks(String userId);
}
