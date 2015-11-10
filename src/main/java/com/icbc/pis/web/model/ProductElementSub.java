package com.icbc.pis.web.model;

public class ProductElementSub {

	private String productId;
	
	private String eleGroupId;
	
	private String eleKey;
	
	private String eleValue;

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getEleGroupId() {
		return this.eleGroupId;
	}

	public void setEleGroupId(String eleGroupId) {
		this.eleGroupId = eleGroupId;
	}

	public String getEleKey() {
		return this.eleKey;
	}

	public void setEleKey(String eleKey) {
		this.eleKey = eleKey;
	}

	public String getEleValue() {
		return this.eleValue;
	}

	public void setEleValue(String eleValue) {
		this.eleValue = eleValue;
	}
	
	private ProductElementSub()
	{
		
	}
	
	public ProductElementSub(String productId,String eleGroupId,String eleKey,String eleValue)
	{
		this.productId = productId;
		
		this.eleGroupId = eleGroupId;
		
		this.eleKey = eleKey;
		
		this.eleValue = eleValue;
	}
}
