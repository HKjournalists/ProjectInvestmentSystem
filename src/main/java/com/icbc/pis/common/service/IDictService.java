package com.icbc.pis.common.service;

import java.util.List;

import com.icbc.pis.web.model.DictItem;

public interface IDictService {

	public List<DictItem> queryByType(String type);
}
