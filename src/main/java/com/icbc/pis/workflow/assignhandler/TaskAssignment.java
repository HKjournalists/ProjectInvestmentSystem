package com.icbc.pis.workflow.assignhandler;

import org.jbpm.api.Configuration;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;

import com.icbc.pis.role.service.impl.RoleService;
import com.icbc.pis.web.model.Role;


public class TaskAssignment implements AssignmentHandler  {

	private RoleService roleService;
	
	@Override
	public void assign(Assignable assignable, OpenExecution openExec) throws Exception {
		// TODO Auto-generated method stub


 		Role role = ServiceHelper.GetInstance().getRoleService().getGroupByActivityName(openExec.getActivity().getName());
		
		assignable.addCandidateGroup(role.getRoleId());
		
	}
	
	
}
