package com.icbc.pis.product.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.product.dao.IProductIntPayDateDao;
import com.icbc.pis.web.mapper.ProductElementPartMapper;
import com.icbc.pis.web.mapper.ProductIntPayDateMapper;
import com.icbc.pis.web.model.ProductElement;
import com.icbc.pis.web.model.ProductElementSub;
import com.icbc.pis.web.model.ProductIntPayDate;

@Repository("ProductIntPayDateDao")
public class ProductIntPayDateDao implements IProductIntPayDateDao,ICommonOperDao {

	private static final Logger logger = LoggerFactory.getLogger(ProductElementDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ProductIntPayDate> getProductIntPayDateById(String productId) {
		// TODO Auto-generated method stub
		String sql = " select * from PIS_PROD_INT_PAY_DATE WHERE PRODUCT_ID = ? ";
		
		List<ProductIntPayDate> productIntPayDateList = this.jdbcTemplate.query(sql ,new Object[] { productId }, new ProductIntPayDateMapper() );
		
		return productIntPayDateList;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		
		ProductIntPayDate subEle = (ProductIntPayDate)obj;
		
		String sql = "insert into PIS_PROD_INT_PAY_DATE(PRODUCT_ID,INT_PAY_DATE) values (?,?)";
		
		int affectedRows = this.jdbcTemplate.update(sql,subEle.getProductId(),subEle.getIntPayDate());

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
		String sql = "delete from PIS_PROD_INT_PAY_DATE where PRODUCT_ID = ?";
		
		int affectedRows = this.jdbcTemplate.update(sql,id);
			
		return affectedRows != 0;
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		int cnt = this.jdbcTemplate.queryForObject("select count(*) from PIS_PROD_INT_PAY_DATE where PRODUCT_ID = ?",new Object[] {id}, Integer.class);
		
		return cnt > 0 ? true : false;
	}

}
