package com.icbc.pis.product.dao;

import java.util.List;

import com.icbc.pis.web.model.ProductRepayInfo;

public interface IProductRepayInfoDao {

	public List<ProductRepayInfo> getProductRepayInfoById(String productId);
	
	public int count();
	
	
}
