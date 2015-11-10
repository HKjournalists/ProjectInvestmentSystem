package com.icbc.pis.product.dao;

import java.util.List;

import com.icbc.pis.web.model.ProductElementSub;

public interface IProductElementSubDao {

	public List<ProductElementSub> getProductEleSubById(String productId);
	
	public int count();
	
}
