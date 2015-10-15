package com.icbc.pis.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Component("RepositoryServiceProxy")
public class RepositoryServiceProxy implements ServiceProxyInterface{

	private static ApplicationContext context = null;

	 
	private RepositoryService repositoryService;
	
	private final String filePath = "com/icbc/pis/jpdl/";
	
	private final String surfix = ".jpdl.xml";
	
	private final String repoNameArray[] = {"before_invest"};
	
	private String GenFilePath(String repoName){
		
		return this.filePath + repoName + this.surfix;
	}
	
	@Autowired
	public RepositoryServiceProxy(RepositoryService repositoryService)
	{
		
		assert(repositoryService != null);
		
		this.repositoryService = repositoryService;
		
		this.init();
	}
	
	
	
	public void init()
	{
		for(String repoName : this.repoNameArray)
		{
			if(!this.IsExists(repoName))
			{
				this.deploy(repoName);
			}
		}
	}
	
	public String deploy(String repoName)
	{

		try{
			
			
			String deployId = this.repositoryService.createDeployment().addResourceFromClasspath(this.GenFilePath(repoName)).deploy();

			System.out.println("deployId is : " + deployId);
			
			return deployId;
		}
		catch(Exception e){
			
			return null;
		}
	}


	@Override
	public boolean IsExists(String repoName) {
		// TODO Auto-generated method stub

		try
		{
		
			List<ProcessDefinition> pdList = this.repositoryService.createProcessDefinitionQuery().list();
			
			for(ProcessDefinition pd : pdList)
			{
				 if (pd.getName() == repoName)
				 {
					 return true;
				 }
			}
			
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

}
