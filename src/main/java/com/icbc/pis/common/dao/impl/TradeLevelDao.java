package com.icbc.pis.common.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ITradeLevelDao;
import com.icbc.pis.web.mapper.DictItemMapper;
import com.icbc.pis.web.mapper.TradeLevelMapper;
import com.icbc.pis.web.model.DictItem;
import com.icbc.pis.web.model.TradeLevel;

@Repository("TradeLevelDao")
public class TradeLevelDao implements ITradeLevelDao {

private static final Logger logger = LoggerFactory.getLogger(TradeLevelDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TradeLevel> queryAll() {
		// TODO Auto-generated method stub
		String sql = " select t.TRADE_CODE,t.TRADE_NAME,t.PARENT_CODE,t.TRADE_LEVEL from PIS_TRADE_LEVEL t order by t.TRADE_LEVEL ";
		
		List<TradeLevel> itemList = this.jdbcTemplate.query(sql, new TradeLevelMapper() );
		
		return itemList;
	}

	
	
}
