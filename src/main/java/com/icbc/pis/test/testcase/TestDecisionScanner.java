package com.icbc.pis.test.testcase;

import com.icbc.pis.workflow.decision.DecisionNodeEnum;
import com.icbc.pis.workflow.decision.DecisionScanner;

import junit.framework.TestCase;

public class TestDecisionScanner extends TestCase {

	public void testDecisionScanner()
	{
		for(Class<?> clas : DecisionScanner.GetInstance().getDecisionCondMapper().get(DecisionNodeEnum.pass_dept_risk_vrf))
		{
			System.out.println(clas.getName());
		}
	}
}
