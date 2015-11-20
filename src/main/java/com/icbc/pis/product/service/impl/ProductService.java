package com.icbc.pis.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icbc.pis.common.service.ICommonOperService;
import com.icbc.pis.datastruct.ProductElementInfo;
import com.icbc.pis.product.dao.impl.ProductElementDao;
import com.icbc.pis.product.dao.impl.ProductIntPayDateDao;
import com.icbc.pis.product.dao.impl.ProductRaiseCreditTypeDao;
import com.icbc.pis.product.dao.impl.ProductRepayInfoDao;
import com.icbc.pis.product.service.IProductService;
import com.icbc.pis.web.model.ProductElement;
import com.icbc.pis.web.model.ProductElementSub;
import com.icbc.pis.web.model.ProductIntPayDate;
import com.icbc.pis.web.model.ProductRaiseCreditType;
import com.icbc.pis.web.model.ProductRepayInfo;

@Service("ProductService")
public class ProductService implements ICommonOperService,IProductService{

	@Autowired
	private ProductElementDao productElementDao;
	
	@Autowired
	private ProductRepayInfoDao productRepayInfoDao;
	
	@Autowired
	private ProductRaiseCreditTypeDao productRaiseCreditTypeDao;
	
	@Autowired
	private ProductIntPayDateDao productIntPayDateDao;
	
	
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
	@Transactional
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		
		boolean retFlag = false;
		
		ProductElementInfo productElementInfo = (ProductElementInfo)obj;
		
		retFlag = this.productElementDao.add(productElementInfo.getProductElem());
		
		for(ProductRepayInfo subEle : productElementInfo.getRepayPlanList())
		{
			retFlag = this.productRepayInfoDao.add(subEle);
		}
		
		for(ProductRaiseCreditType subEle : productElementInfo.getRaiseCreditTypeList())
		{
			retFlag = this.productRaiseCreditTypeDao.add(subEle);
		}
		
		for(ProductIntPayDate subEle : productElementInfo.getIntPayDateList())
		{
			retFlag = this.productIntPayDateDao.add(subEle);
		}
		
		return true;
		
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		boolean retFlag = false;
		
		ProductElementInfo productElementInfo = (ProductElementInfo)obj;
		
		retFlag = this.productElementDao.update(productElementInfo.getProductElem());
		
		retFlag = this.productRepayInfoDao.delete(productElementInfo.getProductElem().getProductId());
		
		for(ProductRepayInfo subEle : productElementInfo.getRepayPlanList())
		{
			retFlag = this.productRepayInfoDao.add(subEle);
		}
		
		retFlag = this.productRaiseCreditTypeDao.delete(productElementInfo.getProductElem().getProductId());
		
		for(ProductRaiseCreditType subEle : productElementInfo.getRaiseCreditTypeList())
		{
			retFlag = this.productRaiseCreditTypeDao.add(subEle);
		}
		
		retFlag = this.productIntPayDateDao.delete(productElementInfo.getProductElem().getProductId());
		
		for(ProductIntPayDate subEle : productElementInfo.getIntPayDateList())
		{
			retFlag = this.productIntPayDateDao.add(subEle);
		}
		
		return true;
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		boolean retFlag = false;
		
		retFlag = this.productElementDao.delete(id);
		
		retFlag = this.productRepayInfoDao.delete(id);
		
		retFlag = this.productRaiseCreditTypeDao.delete(id);
		
		retFlag = this.productIntPayDateDao.delete(id);
		
		return retFlag; 
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		return this.productElementDao.isExists(id);
	}

}
