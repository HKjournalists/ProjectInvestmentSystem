package com.icbc.pis.datastruct;

import java.util.List;
import java.util.Map;

import com.icbc.pis.web.model.ProductElement;
import com.icbc.pis.web.model.ProductElementSub;
import com.icbc.pis.web.model.ProductIntPayDate;
import com.icbc.pis.web.model.ProductRaiseCreditType;
import com.icbc.pis.web.model.ProductRepayInfo;

public class ProductElementInfo {

	private ProductElement productElem;
	
	private List<ProductRaiseCreditType> raiseCreditTypeList;
	
	private List<ProductIntPayDate> intPayDateList;
	
	private List<ProductRepayInfo> repayPlanList;
	
	public ProductElementInfo(ProductElement productElem,
							  List<ProductRaiseCreditType> raiseCreditTypeList,
							  List<ProductIntPayDate> intPayDateList,
							  List<ProductRepayInfo> repayPlanList)
	{
		this.productElem = productElem;
		
		this.raiseCreditTypeList = raiseCreditTypeList;
		
		this.intPayDateList = intPayDateList;
		
		this.repayPlanList = repayPlanList;
	}
	
	public ProductElement getProductElem() {
		return productElem;
	}

	public void setProductElem(ProductElement productElem) {
		this.productElem = productElem;
	}

 
	public List<ProductRaiseCreditType> getRaiseCreditTypeList() {
		return raiseCreditTypeList;
	}

	public void setRaiseCreditTypeList(List<ProductRaiseCreditType> raiseCreditTypeList) {
		this.raiseCreditTypeList = raiseCreditTypeList;
	}

	public List<ProductIntPayDate> getIntPayDateList() {
		return intPayDateList;
	}

	public void setIntPayDateList(List<ProductIntPayDate> intPayDateList) {
		this.intPayDateList = intPayDateList;
	}

	public List<ProductRepayInfo> getRepayPlanList() {
		return repayPlanList;
	}

	public void setRepayPlanList(List<ProductRepayInfo> repayPlanList) {
		this.repayPlanList = repayPlanList;
	}
}
