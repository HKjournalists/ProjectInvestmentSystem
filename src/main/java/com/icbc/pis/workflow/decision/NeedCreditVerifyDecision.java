package com.icbc.pis.workflow.decision;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class NeedCreditVerifyDecision implements DecisionHandler {

	@Override
	public String decide(OpenExecution arg0) {
		
		// TODO Auto-generated method stub
		System.out.println("NeedCreditVerifyDecision...");  
		
		TransitionTypeEnum transition;
		
		if(true)
		{
			transition = TransitionTypeEnum.NEXT;
		}
		else
		{
			transition = TransitionTypeEnum.SKIP;
		}
		
		return transition.toString();  
	}
}
