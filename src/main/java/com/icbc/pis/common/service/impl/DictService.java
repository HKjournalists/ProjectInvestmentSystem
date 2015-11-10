package com.icbc.pis.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icbc.pis.common.dao.impl.DictDao;
import com.icbc.pis.common.service.IDictService;
import com.icbc.pis.web.model.DictItem;

@Service("DictService")
public class DictService implements IDictService {

	@Autowired
	private DictDao dictDao;
	
	@Override
	public List<DictItem> queryByType(String type) {
		// TODO Auto-generated method stub
		return this.dictDao.queryByType(type);
	}

}
