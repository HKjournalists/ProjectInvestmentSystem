package com.icbc.pis.datastruct;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaginationStruct {
	
	private int numberOfItems;
	
	private List<Map<String,String>> data;

	public PaginationStruct(int numberOfItems,List<Map<String,String>> data)
	{
		this.numberOfItems = numberOfItems;
		
		this.data = data;
	}
	
	private PaginationStruct(){}
	
	public int getnumberOfItems() {
		return numberOfItems;
	}

	public void setnumberOfItems(int numberOfPages) {
		this.numberOfItems = numberOfPages;
	}

	public List<Map<String, String>> getData() {
		return data;
	}

	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}
	
	
}
