package com.icbc.pis.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icbc.pis.common.dao.impl.TradeLevelDao;
import com.icbc.pis.common.service.ITradeLevelService;
import com.icbc.pis.web.model.TradeLevel;

@Service("TradeLevelService")
public class TradeLevelService implements ITradeLevelService {

	@Autowired
	private TradeLevelDao tradeLevelDao;
	
	@Override
	public List<TradeLevel> queryAll() {
		// TODO Auto-generated method stub
		return this.tradeLevelDao.queryAll();
		
	}

}
