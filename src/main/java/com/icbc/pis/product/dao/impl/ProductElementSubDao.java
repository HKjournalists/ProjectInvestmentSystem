package com.icbc.pis.product.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.product.dao.IProductElementSubDao;
import com.icbc.pis.util.StringUtil;
import com.icbc.pis.web.mapper.ProductElementSubMapper;
import com.icbc.pis.web.mapper.UserMapper;
import com.icbc.pis.web.model.ProductElement;
import com.icbc.pis.web.model.ProductElementSub;
import com.icbc.pis.web.model.User;

@Repository("ProductElementSubDao")
public class ProductElementSubDao implements IProductElementSubDao,ICommonOperDao{

	private static final Logger logger = LoggerFactory.getLogger(ProductElementDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
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
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductElementSub> getProductEleSubById(String productId) {
		// TODO Auto-generated method stub
		String sql = "select PRODUCT_ID,ELE_GROUP_ID,ELE_KEY,ELE_VALUE "
					+ "from PIS_PRODUCT_ELE_SUB where PRODUCT_ID = ?";

		List<ProductElementSub> subEleList = this.jdbcTemplate.query(sql ,new Object[] {productId}, new ProductElementSubMapper() );
		
		return subEleList;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
