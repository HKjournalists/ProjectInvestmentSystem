package com.icbc.pis.common.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.IDictDao;
import com.icbc.pis.web.mapper.DictItemMapper;
import com.icbc.pis.web.model.DictItem;

@Repository("DictDao")
public class DictDao implements IDictDao {

	private static final Logger logger = LoggerFactory.getLogger(DictDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DictItem> queryByType(String type) {
		// TODO Auto-generated method stub
		String sql = " select t.kind_id,t.kind_name from pis_dict t where t.oper_kind = ? ";
		
		List<DictItem> itemList = this.jdbcTemplate.query(sql ,new Object[] {type}, new DictItemMapper() );
		
		return itemList;
	}

	
}
