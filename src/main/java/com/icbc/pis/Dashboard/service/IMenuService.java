package com.icbc.pis.Dashboard.service;
import java.util.List;

import com.icbc.pis.datastruct.MenuItem;
public interface IMenuService {
	
	public List<MenuItem> assembleList(String UserId);

}
