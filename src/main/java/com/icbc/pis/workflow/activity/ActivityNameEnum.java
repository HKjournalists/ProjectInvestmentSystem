package com.icbc.pis.workflow.activity;

import com.icbc.pis.workflow.decision.DecisionNodeEnum;

public enum ActivityNameEnum {

	attr_input("attr_input","项目要素录入"),
	resource_upload("resource_upload","项目资料上传"),
	dept_risk_verify("dept_risk_verify","部门层面风险审核"),
	law_verify("law_verify","外部律师意见"),
	credit_verify("credit_verify","信用评级"),
	corp_risk_verify("corp_risk_verify","公司风险审核"),
	report_upload("report_upload","投资请示报告"),
	team_review("team_review","项目投资评审会评审"),
	
	committee_review("committee_review","公司投资管理委员会评审"),
	director_approve("director_approve","董事长审批"),
	contract_upload("contract_upload","合同审核"),
	payment_input("payment_input","项目缴款");
	
	
	private String activityEngName;
	
	private String activityChiName;
	
	private ActivityNameEnum(String activityEngName,String activityChiName)
	{
		this.activityEngName = activityEngName;
		this.activityChiName = activityChiName;
	}
	
	public String getChiName()
	{
		return this.activityChiName;
	}
	
	public String getEngName()
	{
		return this.activityEngName;
	}
	
}
