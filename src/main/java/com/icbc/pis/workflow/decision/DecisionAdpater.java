package com.icbc.pis.workflow.decision;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

import com.icbc.pis.workflow.decision.step.DecisionStep;

public abstract class DecisionAdpater {

	protected DecisionNodeEnum nodeType;
	
	abstract void SetNodeType();
	
	protected boolean validation() throws InstantiationException, IllegalAccessException
	{
		this.SetNodeType();
		
		for(Class<?> c : DecisionScanner.GetInstance().getDecisionCondMapper().get(this.nodeType))
		{
			//System.out.println(c.getName());
			DecisionStep step = (DecisionStep)c.newInstance();
			
			boolean flag = false;
			
			if(step != null)
			{
				flag = step.doValidation();
			}
			
			if(!flag)
			{
				return false;
			}
		}
		
		return true;
	}
	
}
