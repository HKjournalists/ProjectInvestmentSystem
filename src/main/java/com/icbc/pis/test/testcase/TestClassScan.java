package com.icbc.pis.test.testcase;

import java.util.Set;

import com.icbc.pis.web.utils.ClassScan;

import junit.framework.TestCase;

public class TestClassScan extends TestCase {

	public void testScan(){
		
		String pack = "com.icbc.pis.web.model";
		
		Set<Class<?>> classes = ClassScan.getClasses(pack);
		
		for(Class<?> clas : classes)
		{
			System.out.println(clas.getName());
		}
		
		int result = classes.size();
		
		
	}
	
}
