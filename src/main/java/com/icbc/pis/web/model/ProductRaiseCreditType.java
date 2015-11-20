package com.icbc.pis.web.model;

public class ProductRaiseCreditType {
	
	private String productId;
	
	private String raiseCreditType;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRaiseCreditType() {
		return raiseCreditType;
	}

	public void setRaiseCreditType(String raiseCreditType) {
		this.raiseCreditType = raiseCreditType;
	}
	
	public ProductRaiseCreditType(String productId,String raiseCreditType)
	{
		this.productId = productId;
		
		this.raiseCreditType = raiseCreditType;
	}
}
