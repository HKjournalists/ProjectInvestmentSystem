package com.icbc.pis.product.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.product.dao.IProductRepayInfoDao;
import com.icbc.pis.web.model.ProductRaiseCreditType;
import com.icbc.pis.web.model.ProductRepayInfo;

@Repository("ProductRepayInfoDao")
public class ProductRepayInfoDao implements IProductRepayInfoDao,ICommonOperDao {

	private static final Logger logger = LoggerFactory.getLogger(ProductElementDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<com.icbc.pis.web.model.ProductRepayInfo> getProductRepayInfoById(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		ProductRepayInfo subEle = (ProductRepayInfo)obj;
		
		String sql = "insert into PIS_PROD_REPAY_INFO(PRODUCT_ID,REPAY_TIME,REPAY_AMT) values (?,?,?)";
		
		int affectedRows = this.jdbcTemplate.update(sql,subEle.getProductId(),subEle.getRepayTime(),subEle.getRepayAmt());

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
		String sql = "delete from PIS_PROD_REPAY_INFO where PRODUCT_ID = ?";
		
		int affectedRows = this.jdbcTemplate.update(sql, id);
			
		return affectedRows != 0;
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		int cnt = this.jdbcTemplate.queryForObject("select count(*) from PIS_PROD_REPAY_INFO where PRODUCT_ID = ?",new Object[] {id}, Integer.class);
		
		return cnt > 0 ? true : false;
	}

}
