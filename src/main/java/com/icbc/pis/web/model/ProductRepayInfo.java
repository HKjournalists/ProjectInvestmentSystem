package com.icbc.pis.web.model;

public class ProductRepayInfo {

	private String productId;
	
	private String repayTime;
	
	private double repayAmt;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRepayTime() {
		return repayTime;
	}

	public void setRepayTime(String repayTime) {
		this.repayTime = repayTime;
	}

	public double getRepayAmt() {
		return repayAmt;
	}

	public void setRepayAmt(double repayAmt) {
		this.repayAmt = repayAmt;
	}
	
	public ProductRepayInfo(String productId,String repayTime,double repayAmt)
	{
		this.productId = productId;
		
		this.repayTime = repayTime;
		
		this.repayAmt = repayAmt;
	}
}
