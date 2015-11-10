package com.icbc.pis.web.controller;

import java.util.ArrayList;
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

import com.icbc.pis.datastruct.PaginationStruct;
import com.icbc.pis.product.service.impl.ProductService;
import com.icbc.pis.web.model.ProductElement;

@Controller
@RequestMapping("/productelem")
public class ProductElemController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);
	
	@Autowired
	private ProductService productService;
	
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
