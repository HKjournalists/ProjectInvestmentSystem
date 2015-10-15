package com.icbc.pis.workflow.decision;

public enum DecisionNodeEnum {

	pass_dept_risk_vrf("pass_dept_risk_vrf",1),
	need_law_verify("need_law_verify",2),
	need_credit_verify("need_credit_verify",3),
	pass_law_credit_vrf("pass_law_credit_vrf",4),
	pass_corp_risk_vrf("pass_corp_risk_vrf",5),
	pass_team_review("pass_team_review",6),
	pass_committee_review("pass_committee_review",7),
	pass_director_approve("pass_director_approve",8);
	
	private String decisionName;
	
	private int index;
	
	private DecisionNodeEnum(String decisionName,int index)
	{
		this.index = index;
		this.decisionName = decisionName;
	}
	
	public String toString()
	{
		return this.decisionName;
	}
	
	public static DecisionNodeEnum getDecisionNodeEnumByName(String name) 
	{
        for (DecisionNodeEnum c : DecisionNodeEnum.values()) 
        {
            if (c.toString().equals(name)) 
            {
                return c;
            }
        }
        
        return null;
    }
	
}
