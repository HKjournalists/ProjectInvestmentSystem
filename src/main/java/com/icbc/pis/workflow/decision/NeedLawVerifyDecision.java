package com.icbc.pis.workflow.decision;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class NeedLawVerifyDecision extends DecisionAdpater implements DecisionHandler  {

	@Override
	public String decide(OpenExecution arg0) {
		
		// TODO Auto-generated method stub
		System.out.println("NeedLawVerifyDecision...");  
		
		TransitionTypeEnum transition = null;
		
		try 
		{
			if(this.validation())
			{
				transition = TransitionTypeEnum.NEXT;
			}
			else
			{
				transition = TransitionTypeEnum.SKIP;
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
		this.nodeType = DecisionNodeEnum.need_law_verify;
	}

}
