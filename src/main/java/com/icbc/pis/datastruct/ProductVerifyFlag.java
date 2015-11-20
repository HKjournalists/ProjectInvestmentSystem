package com.icbc.pis.datastruct;

public class ProductVerifyFlag {
	
	private String productId;

	private String isNeedLawVerify;
	 
	private String isNeedCreditVerify;
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getIsNeedLawVerify() {
		return isNeedLawVerify;
	}

	public void setIsNeedLawVerify(String isNeedLawVerify) {
		this.isNeedLawVerify = isNeedLawVerify;
	}

	public String getIsNeedCreditVerify() {
		return isNeedCreditVerify;
	}

	public void setIsNeedCreditVerify(String isNeedCreditVerify) {
		this.isNeedCreditVerify = isNeedCreditVerify;
	}

	public ProductVerifyFlag(String productId,String isNeedLawVerify,String isNeedCreditVerify )
	{
		this.productId = productId;
		
		this.isNeedLawVerify = isNeedLawVerify;
		
		this.isNeedCreditVerify = isNeedCreditVerify;
	}

}
