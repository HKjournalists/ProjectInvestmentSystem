package com.icbc.pis.deptrisk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icbc.pis.datastruct.TaskInfo;
import com.icbc.pis.datastruct.UserInfo;
import com.icbc.pis.deptrisk.dao.impl.DeptRiskDao;
import com.icbc.pis.deptrisk.service.IDeptRiskService;
import com.icbc.pis.taskinwait.service.impl.OperationEnum;
import com.icbc.pis.util.StringUtil;
import com.icbc.pis.web.model.DeptRisk;
import com.icbc.pis.web.model.UserRole;


@Service("DeptRiskService")
public class DeptRiskService implements IDeptRiskService  {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DeptRiskService.class);
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private DeptRiskDao deptRiskDao;
	
	@Override
	public List<DeptRisk> getDeptRiskListByCondition(Map<String, String[]> filterCond) {
		
		return this.deptRiskDao.getDeptRiskListByCondition(filterCond);
	}
	
	@Override
	public int count(){
		
		return this.deptRiskDao.count();
	}
	
	@Override
	@Transactional
	public boolean verifyDeptRisk(Map<String, String> paramMap) {
		boolean retFlag = false;
		
		retFlag = this.deptRiskDao.verifyDeptRisk(paramMap);
		
		return retFlag;
	}
	
	//获取个人处理中的任务信息
	@Override
	public List<TaskInfo> getPersonalTasks(String userId){
		try{
			if(StringUtil.isNullOrEmpty(userId)){
				return null;
			}
			List<TaskInfo> taskInfoList = new ArrayList<TaskInfo>();
			List<Task> tasks = this.taskService.createTaskQuery().assignee(userId).activityName("dept_risk_verify").list();
			for(Task task : tasks){
				TaskInfo taskInfo = new TaskInfo(task,OperationEnum.handle);
				taskInfoList.add(taskInfo);
			}
			return taskInfoList;
		}catch(Exception e){
			return null;
		}
	}
	
	//获取未处理（检出）的的部门层次任务信息
	@Override
	public List<TaskInfo> getGroupTasks(String userId) {
		try{
			if(StringUtil.isNullOrEmpty(userId)){
				return null;
			}
			//获取个人处理中的任务信息
			List<Task> tasks = this.taskService.createTaskQuery().assignee(null).activityName("dept_risk_verify").list();
			List<TaskInfo> taskInfoList = new ArrayList<TaskInfo>();
			/*//获取所有处于部门层次风险审核状态的任务
			List<Task> task1 = this.taskService.createTaskQuery().assignee(null).activityName("dept_risk_verify").list();
			System.out.println("--------size1----------:"+task1.size());
			List<TaskInfo> taskInfoList = new ArrayList<TaskInfo>();
			List<TaskInfo> taskInfoList1 = new ArrayList<TaskInfo>();
			//要排除所有处于部门层次风险审核状态中的处理中的任务信息（包括此人处理和非此人处理中的任务）
			for(Task task : tasks){
				TaskInfo taskInfo = new TaskInfo(task,OperationEnum.checkout);
				int oper = taskInfo.getOper().getIndex();
				if(oper==2){//只有未处理中的才要
					taskInfoList.add(taskInfo);
				}
				taskInfoList1.add(taskInfo);
			}*/
			for(Task task : tasks){
				TaskInfo taskInfo = new TaskInfo(task,OperationEnum.checkout);
				taskInfoList.add(taskInfo);
			}
			return taskInfoList;
		}catch(Exception e){
			return null;
		}
	}
	
}
