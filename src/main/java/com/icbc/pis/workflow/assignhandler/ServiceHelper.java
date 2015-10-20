package com.icbc.pis.workflow.assignhandler;

import org.jbpm.api.Configuration;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ProcessEngine;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.icbc.pis.role.service.impl.RoleService;

@Component
public class ServiceHelper implements ApplicationContextAware {

	private static ServiceHelper instance;
	
	private static Object syncRoot = new Object();
	
	private static ApplicationContext appContext = null;  
	
	private RoleService roleService;
	
	//private IdentityService identityService;
	
	private ServiceHelper(){}
	
	public static ServiceHelper GetInstance()
	{
		if(ServiceHelper.instance == null)
		{
			synchronized(syncRoot)
			{
				if(ServiceHelper.instance == null)
				{
					ServiceHelper.instance = new ServiceHelper();
				}
			}
		}
		
		return ServiceHelper.instance;
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		// TODO Auto-generated method stub
		ServiceHelper.appContext = appContext;
		
		
	}
	
	public RoleService getRoleService() {
	
		
//		this.identityService = (IdentityService) ServiceHelper.appContext.getBean("identityService");
//		this.identityService.createGroup("项目投资经理");
//		this.identityService.createUser("liu", "yuezhi", "aaa");
//		identityService.createMembership("liu", "项目投资经理");
//		
//		
		
		this.roleService = (RoleService) ServiceHelper.appContext.getBean("RoleService");
		
		return this.roleService;
	}

}
