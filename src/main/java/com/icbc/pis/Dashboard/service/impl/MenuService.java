package com.icbc.pis.Dashboard.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icbc.pis.Dashboard.dao.impl.MenuDao;
import com.icbc.pis.Dashboard.service.IMenuService;
import com.icbc.pis.datastruct.MenuItem;
import com.icbc.pis.web.model.ItemInfo;
@Repository("MenuService")
public class MenuService implements IMenuService{
	@Autowired
	private MenuDao menuDao;
	@Override
	public List<MenuItem> assembleList(String UserId) {
		// TODO Auto-generated method stub
		List<ItemInfo> Items=menuDao.getItemsbyUser(UserId);
		Map<String,MenuItem> ItemsMap=new LinkedHashMap();
		List<MenuItem> ret=new ArrayList();
		for(ItemInfo item:Items)
		{
		  ItemsMap.put(item.getId(), new MenuItem(item.getIcon(),item.getText(),item.getUrl(),false,null,item.getOrder()));
		}
		for(ItemInfo item:Items)
		{
		 if(item.getParent()!=null&&!item.getParent().equals(""))
		 {
			 MenuItem Menu=ItemsMap.get(item.getParent());
			 Menu.setHasChild(true);
			 Menu.addChildren(ItemsMap.get(item.getId()));
			 ItemsMap.remove(item.getId());
		 }
		}
		Iterator<String> it = ItemsMap.keySet().iterator();
		while(it.hasNext())
		{
			MenuItem one=ItemsMap.get(it.next());
			one.SortChildren();
			ret.add(one);
		}
		return ret;
	}

}
