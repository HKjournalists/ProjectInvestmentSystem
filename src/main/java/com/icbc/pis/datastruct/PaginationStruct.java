package com.icbc.pis.datastruct;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaginationStruct {
	
	private int numberOfPages;
	
	private List<Map<String,String>> data;

	public PaginationStruct(int numberOfPages,List<Map<String,String>> data)
	{
		this.numberOfPages = numberOfPages;
		
		this.data = data;
	}
	
	private PaginationStruct(){}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public List<Map<String, String>> getData() {
		return data;
	}

	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}
	
	
}
