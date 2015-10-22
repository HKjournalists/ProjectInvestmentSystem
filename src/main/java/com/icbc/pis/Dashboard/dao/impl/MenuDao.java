package com.icbc.pis.Dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.Dashboard.dao.IMenuDao;
import com.icbc.pis.role.service.impl.RoleService;
import com.icbc.pis.web.mapper.ItemMapper;
import com.icbc.pis.web.model.ItemInfo;

@Repository("MenuDao")
public class MenuDao implements IMenuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(MenuDao.class);

	@Override
	public List<ItemInfo> getItemsbyUser(String userId) {
		String Sql = "select t.id,tn.name text,t.url,t.item_type,t.icon,t.parent,t.ITEM_ORDER from pis_item t,pis_item_nls tn where tn.id = t.id";
		return jdbcTemplate.query(Sql, new ItemMapper());
	}

	@Override
	public ItemInfo getIteminfo(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
