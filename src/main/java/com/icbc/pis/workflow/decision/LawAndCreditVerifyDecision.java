package com.icbc.pis.workflow.decision;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class LawAndCreditVerifyDecision implements DecisionHandler {

	@Override
	public String decide(OpenExecution exe) {
		// TODO Auto-generated method stub
		System.out.println("LawAndCreditVerifyDecision...");  

		TransitionTypeEnum transition;
		
		if(true)
		{
			transition = TransitionTypeEnum.NEXT;
		}
		else
		{
			transition = TransitionTypeEnum.CLOSE;
		}
		
		return transition.toString();  
	}
}