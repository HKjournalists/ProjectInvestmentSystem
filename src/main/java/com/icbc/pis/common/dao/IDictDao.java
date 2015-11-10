package com.icbc.pis.common.dao;

import java.util.List;

import com.icbc.pis.web.model.DictItem;

public interface IDictDao {

	public List<DictItem> queryByType(String type);
	
}
