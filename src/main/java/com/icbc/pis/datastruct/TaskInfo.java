package com.icbc.pis.datastruct;

import org.jbpm.api.task.Task;

import com.icbc.pis.taskinwait.service.impl.OperationEnum;
import com.icbc.pis.workflow.activity.ActivityNameMapper;

public class TaskInfo {
	
	private final String prefix = "待";
	
	private Task task;
	
	private String productId;
	
	private String productName;
	
	private String activity;
	
	private OperationEnum oper;

	public TaskInfo(Task task,OperationEnum oper)
	{
		if(task != null)
		{
			this.task = task;
			
			this.oper = oper;
			
			switch(this.oper.getIndex())
			{
				case 1:
					this.activity = ActivityNameMapper.ActivityNameEng2Chi(this.task.getActivityName());
					break;
				case 2:
					this.activity = this.prefix + ActivityNameMapper.ActivityNameEng2Chi(this.task.getActivityName());
					break;
				default :
					this.activity = ActivityNameMapper.ActivityNameEng2Chi(this.task.getActivityName());
					break;
			}
			
			this.productId = this.task.getExecutionId();
			
			this.productName = "";
		}

		
	}
	
	public Task getTask() {

		return this.task;
	}

	public String getProductId() {
		return this.productId;
	}

//	public void setProductId(String productId) {
//		this.productId = productId;
//	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getActivity() {
		return this.activity;
	}

//	public void setActivity(String activity) {
//		this.activity = activity;
//	}

	public OperationEnum getOper() {
		
		return this.oper;
	}

}
