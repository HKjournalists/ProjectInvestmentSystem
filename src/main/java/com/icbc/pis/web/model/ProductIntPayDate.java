package com.icbc.pis.web.model;

public class ProductIntPayDate {

	private String productId;
	
	private String intPayDate;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getIntPayDate() {
		return intPayDate;
	}

	public void setIntPayDate(String intPayDate) {
		this.intPayDate = intPayDate;
	}
	
	public ProductIntPayDate(String productId,String intPayDate)
	{
		this.productId = productId;
		
		this.intPayDate = intPayDate;
	}
}
