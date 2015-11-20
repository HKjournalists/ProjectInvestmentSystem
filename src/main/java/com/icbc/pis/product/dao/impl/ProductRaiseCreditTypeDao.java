package com.icbc.pis.product.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.product.dao.IProductRaiseCreditTypeDao;
import com.icbc.pis.web.mapper.ProductIntPayDateMapper;
import com.icbc.pis.web.mapper.ProductRaiseCreditTypeMapper;
import com.icbc.pis.web.model.ProductIntPayDate;
import com.icbc.pis.web.model.ProductRaiseCreditType;

@Repository("ProductRaiseCreditTypeDao")
public class ProductRaiseCreditTypeDao implements IProductRaiseCreditTypeDao,ICommonOperDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductElementDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<ProductRaiseCreditType> getProductRaiseCreditTypeById(String productId) {
		// TODO Auto-generated method stub
		String sql = " select * from PIS_PROD_RAISE_CREDIT_TYPE WHERE PRODUCT_ID = ? ";
		
		List<ProductRaiseCreditType> productRaiseCreditTypeList = this.jdbcTemplate.query(sql ,new Object[] { productId }, new ProductRaiseCreditTypeMapper() );
		
		return productRaiseCreditTypeList;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		ProductRaiseCreditType subEle = (ProductRaiseCreditType)obj;
		
		String sql = "insert into PIS_PROD_RAISE_CREDIT_TYPE(PRODUCT_ID,RAISE_CREDIT_TYPE) values (?,?)";
		
		int affectedRows = this.jdbcTemplate.update(sql,subEle.getProductId(),subEle.getRaiseCreditType());

		return affectedRows != 0;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from PIS_PROD_RAISE_CREDIT_TYPE where PRODUCT_ID = ?";
		
		int affectedRows = this.jdbcTemplate.update(sql, id);
			
		return affectedRows != 0;
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		int cnt = this.jdbcTemplate.queryForObject("select count(*) from PIS_PROD_RAISE_CREDIT_TYPE where PRODUCT_ID = ?",new Object[] {id}, Integer.class);
		
		return cnt > 0 ? true : false;
	}

}
