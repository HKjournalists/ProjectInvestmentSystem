package com.icbc.pis.product.dao;

import java.util.List;

import com.icbc.pis.web.model.ProductIntPayDate;
import com.icbc.pis.web.model.ProductRaiseCreditType;

public interface IProductIntPayDateDao {

	public List<ProductIntPayDate> getProductIntPayDateById(String productId);
	
	public int count();
	
}
