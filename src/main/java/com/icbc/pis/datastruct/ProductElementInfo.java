package com.icbc.pis.datastruct;

import java.util.List;
import java.util.Map;

import com.icbc.pis.web.model.ProductElement;
import com.icbc.pis.web.model.ProductElementSub;

public class ProductElementInfo {

	private ProductElement productElem;
	
	private List<ProductElementSub> raiseCreditTypeList;
	
	private List<ProductElementSub> intPayDateList;
	
	private List<Map<String,String>> repayPlanList;
}
