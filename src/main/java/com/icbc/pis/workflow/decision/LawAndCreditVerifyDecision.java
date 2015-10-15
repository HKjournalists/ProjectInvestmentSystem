package com.icbc.pis.workflow.decision;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class LawAndCreditVerifyDecision extends DecisionAdpater implements DecisionHandler {

	@Override
	public String decide(OpenExecution exe) {
		// TODO Auto-generated method stub
		System.out.println("LawAndCreditVerifyDecision...");  

		TransitionTypeEnum transition = null;
		
		try 
		{
			if(this.validation())
			{
				transition = TransitionTypeEnum.NEXT;
			}
			else
			{
				transition = TransitionTypeEnum.CLOSE;
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transition.toString();  
	}

	@Override
	void SetNodeType() {
		// TODO Auto-generated method stub
		this.nodeType = DecisionNodeEnum.pass_law_credit_vrf;
	}
}
