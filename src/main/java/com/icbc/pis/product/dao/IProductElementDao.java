package com.icbc.pis.product.dao;

import java.util.List;
import java.util.Map;

import com.icbc.pis.web.model.ProductElement;

public interface IProductElementDao {

	public List<ProductElement> getProductListByCond(Map<String, String[]> filterMap);
	
	public ProductElement getProductById(String productId);
	
	public int count(Map<String, String[]> filterMap);
}
