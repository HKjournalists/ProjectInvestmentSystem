package com.icbc.pis.common.dao;

public interface ICommonOperDao {

	public boolean add(Object obj);
	
	public boolean update(Object obj);
	
	public boolean delete(String id);
	
	public boolean isExists(String id);
}
