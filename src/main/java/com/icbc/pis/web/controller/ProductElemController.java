package com.icbc.pis.web.controller;

 
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icbc.pis.common.service.impl.SequenceService;
import com.icbc.pis.datastruct.PaginationStruct;
import com.icbc.pis.datastruct.ProductElementInfo;
import com.icbc.pis.datastruct.UserInfo;
import com.icbc.pis.product.service.impl.ProductService;
import com.icbc.pis.sequence.SequenceEnum;
import com.icbc.pis.sequence.SequenceGenerator;
import com.icbc.pis.util.DoubleUtil;
import com.icbc.pis.web.model.ProductElement;
import com.icbc.pis.web.model.ProductElementSub;
import com.icbc.pis.web.model.ProductIntPayDate;
import com.icbc.pis.web.model.ProductRaiseCreditType;
import com.icbc.pis.web.model.ProductRepayInfo;
import com.icbc.pis.web.model.UserRole;

@Controller
@RequestMapping("/productelem")
public class ProductElemController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SequenceService sequenceService;
	
	
	private ProductElementInfo GenerateProductElementInfo(HttpSession httpSession,HttpServletRequest request){
		
		Map<String,String> eleMap = new HashMap<String,String>();

		try 
		{
			Class c = null;
			
			c = Class.forName("com.icbc.pis.web.model.ProductElement");
			
			Field[] fs = c.getDeclaredFields(); 
			
			for(Field f : fs)
			{
				eleMap.put(f.getName(), request.getParameter(f.getName()));
			}
			
			eleMap.put("productManagerId", (String) httpSession.getAttribute("userId"));
 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
 
		ProductElement productElem = new ProductElement(eleMap);
		
		String raiseCreditSelected = request.getParameter("raiseCreditSelectList");
		
		List<ProductRaiseCreditType> raiseCreditTypeList = new ArrayList<ProductRaiseCreditType>();
		
		for(String rc : raiseCreditSelected.split(","))
		{
			ProductRaiseCreditType pe = new ProductRaiseCreditType(productElem.getProductId(),rc);
			
			raiseCreditTypeList.add(pe);
		}
		
		List<ProductIntPayDate> intPayDateList = new ArrayList<ProductIntPayDate>();
		
		String intPayDates = request.getParameter("intPayDateList");
		
		for(String intPayDay : intPayDates.split(","))
		{
			ProductIntPayDate pe = new ProductIntPayDate(productElem.getProductId(),intPayDay);
			
			intPayDateList.add(pe);
		}
		
		
		
		List<ProductRepayInfo> repayPlanList = new ArrayList<ProductRepayInfo>();
		
		String repayPlanListStr = request.getParameter("repayPlanList"); 
		
		Gson gson = new Gson();
		
        List<Map<String,String>> repayPlans = gson.fromJson(repayPlanListStr, new TypeToken<List<Map<String,String>>>() {}.getType());
		
        for(Map<String,String> repayPlan : repayPlans)
        {
        	String groupNum = String.valueOf(this.sequenceService.GetNextIntValue(SequenceEnum.SeqEleGroupID.getSequenceDBName()));
        	
        	ProductRepayInfo repay = new ProductRepayInfo(productElem.getProductId(),repayPlan.get("eleRepayTime"),DoubleUtil.parseDouble(repayPlan.get("eleRepayAmt")));
        
        	repayPlanList.add(repay);
        }
        
		ProductElementInfo proEleInfo = new ProductElementInfo(productElem,raiseCreditTypeList,intPayDateList,repayPlanList);
		
		return proEleInfo;
	}
	
	@RequestMapping("/genProductId")
	@ResponseBody
	public int genProductId(HttpServletRequest request)
	{
		Date curDate = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		
		String y = format.format(curDate).substring(2, 4);
		
		int year = Integer.parseInt(y);
		
		year = year * 10000;
		
		return year + this.sequenceService.GetNextIntValue(SequenceEnum.SeqProductID.getSequenceDBName());
	}
	
	
	@RequestMapping(value = "/queryProductElementById",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryProductElementById(HttpServletRequest request)
	{
		
		String productId = request.getParameter("productId");
		
		ProductElementInfo prodEleInfo = this.productService.getProductById(productId);
		
		return new Gson().toJson(prodEleInfo);
	}
	
	@RequestMapping("/saveProductElement")
	@ResponseBody
	public boolean saveProductElement(HttpSession httpSession,HttpServletRequest request)
	{
		ProductElementInfo productElementInfo = this.GenerateProductElementInfo(httpSession, request);
		
		boolean retFlag = false;
		
		if(this.productService.isExists(productElementInfo.getProductElem().getProductId()))
		{
			retFlag = this.productService.update(productElementInfo);
		}
		else 
		{
			retFlag = this.productService.add(productElementInfo);
		}
		
		return retFlag;
	}
	
	@RequestMapping("/getProductListByCondition")
	@ResponseBody
	public PaginationStruct getProductListByCondition(HttpSession httpSession,HttpServletRequest request) {
		
		Map<String,String[]> filterCond =  request.getParameterMap();
		
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();

		List<ProductElement> productList = this.productService.getProductListByCond(filterCond);
		
		if (productList != null)
		{
			for(ProductElement product : productList)
			{
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("productId", product.getProductId());
				
				map.put("productName", product.getProductName());
				
				map.put("productType",product.getProductType());
				
				map.put("issuerName", product.getIssuerName());
				
				map.put("maturityYear", String.valueOf(product.getMaturityYear()));
				
				map.put("issueScale", String.valueOf(product.getIssueScale()));
				
				map.put("isIncludeRight", product.getIsIncludeRight());
				
				map.put("rightType", product.getRightType());
				
				resList.add(map);
			}
		}
		
		PaginationStruct paginationStruct = new PaginationStruct(this.productService.count(filterCond),resList);
		
		logger.debug("finish getUsersByCondition");
		
		return paginationStruct;
		
	}
}
