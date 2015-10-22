package com.icbc.pis.Dashboard.dao;

import java.util.List;
import java.util.Map;

import com.icbc.pis.web.model.ItemInfo;


public interface IMenuDao {

	public List<ItemInfo> getItemsbyUser(String userId);

	public ItemInfo getIteminfo(String itemId);

}
