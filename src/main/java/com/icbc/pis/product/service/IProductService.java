package com.icbc.pis.product.service;

import java.util.List;
import java.util.Map;

import com.icbc.pis.web.model.ProductElement;

public interface IProductService {

	public List<ProductElement> getProductListByCond(Map<String, String[]> filterMap);
	
	public ProductElement getProductById(String productId);
	
	public int count(Map<String, String[]> filterMap);
	
}
