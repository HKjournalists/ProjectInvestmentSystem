package com.icbc.pis.product.dao;

import java.util.List;

import com.icbc.pis.web.model.ProductRaiseCreditType;

public interface IProductRaiseCreditTypeDao {

	public List<ProductRaiseCreditType> getProductRaiseCreditTypeById(String productId);
	
	public int count();
	
}
