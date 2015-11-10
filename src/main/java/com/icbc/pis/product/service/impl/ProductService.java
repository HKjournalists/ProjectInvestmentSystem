package com.icbc.pis.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icbc.pis.common.service.ICommonOperService;
import com.icbc.pis.product.dao.impl.ProductElementDao;
import com.icbc.pis.product.service.IProductService;
import com.icbc.pis.web.model.ProductElement;

@Service("ProductService")
public class ProductService implements ICommonOperService,IProductService{

	@Autowired
	private ProductElementDao productElementDao;
	
	@Override
	public List<ProductElement> getProductListByCond(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		return this.productElementDao.getProductListByCond(filterMap);
		
	}

	@Override
	public ProductElement getProductById(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		return this.productElementDao.count(filterMap);
	}

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
