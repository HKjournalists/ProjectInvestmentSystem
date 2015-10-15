package com.icbc.pis.workflow.decision.step;

import com.icbc.pis.annotation.Decision;

@Decision(node="pass_dept_risk_vrf")
public class StepA extends DecisionStep{

	@Override
	public boolean doValidation() {
		// TODO Auto-generated method stub
		return true;
	}

}
