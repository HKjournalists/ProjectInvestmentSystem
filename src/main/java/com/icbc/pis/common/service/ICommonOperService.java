package com.icbc.pis.common.service;

public interface ICommonOperService {

	public boolean add(Object obj);
	
	public boolean update(Object obj);
	
	public boolean deleteById(String id);
	
	public boolean isExists(String id);
	
}
