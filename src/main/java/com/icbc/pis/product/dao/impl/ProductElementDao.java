package com.icbc.pis.product.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.product.dao.IProductElementDao;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.util.StringUtil;
import com.icbc.pis.web.mapper.ProductElementMapper;
import com.icbc.pis.web.mapper.ProductElementPartMapper;
import com.icbc.pis.web.model.ProductElement;

@Repository("ProductElementDao")
public class ProductElementDao implements IProductElementDao,ICommonOperDao {

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
	public List<ProductElement> getProductListByCond(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		
		Integer iStart = 1;
		
		String number = "10";
		
		if(!StringUtil.isNullOrEmpty(StringUtil.getFirst(filterMap.get("start"))))
		{
			iStart = Integer.parseInt(StringUtil.getFirst(filterMap.get("start"))) + 1;
		}

		if(!StringUtil.isNullOrEmpty(StringUtil.getFirst(filterMap.get("number"))))
		{
			number = StringUtil.getFirst(filterMap.get("number"));
		}
		
		Integer iEnd = iStart + Integer.parseInt(number) - 1;
		
		String end = iEnd.toString();
		
		String start = iStart.toString();
		
		String productId = StringUtil.getFirst(filterMap.get("productId")) ;
		
		String productType = StringUtil.getFirst(filterMap.get("productType"));
		
		String productName = StringUtil.getFirst(filterMap.get("productName"));
		
		String productManagerId = StringUtil.getFirst(filterMap.get("productManagerId"));
		
		if(StringUtil.isNullOrEmpty(productId))
		{
			productId = null;
		}
		
		if(StringUtil.isNullOrEmpty(productType))
		{
			productType = null;
		}
		
		if(StringUtil.isNullOrEmpty(productName))
		{
			productName = null;
		}
		
		if(StringUtil.isNullOrEmpty(productManagerId))
		{
			productManagerId = null;
		}
		
		try
		{
			String sql = " select p.PRODUCT_ID,p.PRODUCT_NAME,p.PRODUCT_TYPE,p.ISSUER_NAME,p.MATURITY_YEAR,p.ISSUE_SCALE,p.IS_INCLUDE_RIGHT,p.RIGHT_TYPE" +
					 " from (select ROW_NUMBER() OVER(ORDER BY t.PRODUCT_ID) ROW_NUM,"
					 		+ "t.PRODUCT_ID,"
					 		+ "t.PRODUCT_NAME,"
					 		+ "t.PRODUCT_TYPE,"
					 		+ "t.ISSUER_NAME,"
					 		+ "t.MATURITY_YEAR,"
					 		+ "t.ISSUE_SCALE,"
					 		+ "t.IS_INCLUDE_RIGHT,"
					 		+ "t.RIGHT_TYPE " +
							" from PIS_PRODUCT_ELEMENT t " +
							" where t.STATUS = 1 " +
							" and ( ? is null or t.PRODUCT_NAME like ?) " +
							" and ( ? is null or t.PRODUCT_ID = ?) " +
							" and ( ? is null or t.PRODUCT_TYPE = ?) " +
							" and ( ? is null or t.PRODUCT_MANAGER_ID = ?) " +
					 ") p WHERE P.ROW_NUM between ? AND ? ";
			
			List<ProductElement> productList = this.jdbcTemplate.query(sql ,new Object[] {productName,StringUtil.likeWrap(productName),productId,productId,productType,productType,productManagerId,productManagerId,start,end}, new ProductElementPartMapper() );
			
			return productList;
		}
		catch(Exception e)
		{
			logger.error(e.toString());
			
			return null;
		}
	}

	@Override
	public ProductElement getProductById(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		
		String productId = StringUtil.getFirst(filterMap.get("productId")) ;
		
		String productType = StringUtil.getFirst(filterMap.get("productType"));
		
		String productName = StringUtil.getFirst(filterMap.get("productName"));
		
		String productManagerId = StringUtil.getFirst(filterMap.get("productManagerId"));
		
		String sql = "select count(1) " +
					" from PIS_PRODUCT_ELEMENT t " +
					" where STATUS = 1 " +
					" and ( ? is null or t.PRODUCT_NAME like ?) " +
					" and ( ? is null or t.PRODUCT_ID = ?) " +
					" and ( ? is null or t.PRODUCT_TYPE = ?) " +
					" and ( ? is null or t.PRODUCT_MANAGER_ID = ?) ";
		
		int cnt = this.jdbcTemplate.queryForObject(sql,
				 								   new Object[] {productName,StringUtil.likeWrap(productName),productId,productId,productType,productType,productManagerId,productManagerId},
				 								   Integer.class);
		
		return cnt;
	}

}
