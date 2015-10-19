package com.icbc.pis.test.testcase;

import org.jbpm.api.Configuration;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ProcessEngine;

import com.icbc.pis.workflow.decision.DecisionNodeEnum;
import com.icbc.pis.workflow.decision.DecisionScanner;

import junit.framework.TestCase;

public class TestJbpm4Group extends TestCase {

	public void testJbpm4Group()
	{
		ProcessEngine processEngine = Configuration.getProcessEngine();
		
		
//		RepositoryService repositoryService = processEngine.getRepositoryService();
//		ExecutionService executionService = processEngine.getExecutionService();
//		TaskService taskService = processEngine.getTaskService();
		
	}
}
