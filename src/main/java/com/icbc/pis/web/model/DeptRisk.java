package com.icbc.pis.web.model;

import com.icbc.pis.taskinwait.service.impl.OperationEnum;
import com.icbc.pis.workflow.activity.ActivityNameMapper;

@SuppressWarnings("serial")
public class DeptRisk implements java.io.Serializable {
	
	private final String prefix = "待";
	
	private String taskId;
	
	private String productId;
	
	private String productName;
	
	private String status;
	
	private String oper;
	
	private String operFlag;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

	public DeptRisk(String taskId, String productId, String productName, String status,String oper,String operFlag){
		super();
		this.taskId = taskId;
		this.productId = productId;
		this.productName = productName;
		
		switch(Integer.parseInt(oper)){
			case 1:
				this.status = this.prefix + ActivityNameMapper.ActivityNameEng2Chi(status);
				this.oper = OperationEnum.checkout.getOperation();
				break;
			case 2:
				this.status = ActivityNameMapper.ActivityNameEng2Chi(status);
				this.oper = OperationEnum.handle.getOperation();
				break;
			default :
				this.status = ActivityNameMapper.ActivityNameEng2Chi(status);
				this.oper = OperationEnum.checkout.getOperation();
				break;
		}

		this.operFlag = operFlag;
	}
}
