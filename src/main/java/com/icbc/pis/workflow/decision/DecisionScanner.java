package com.icbc.pis.workflow.decision;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.icbc.pis.annotation.Decision;
import com.icbc.pis.web.utils.ClassScan;

public class DecisionScanner {

	private String packArray[] = {"com.icbc.pis.workflow.decision.step"};
	
	private static  Object syncRoot = new Object();
	
	private Map<DecisionNodeEnum,List<Class<?>>> decisionCondMapper;

	public Map<DecisionNodeEnum, List<Class<?>>> getDecisionCondMapper() {
		return decisionCondMapper;
	}
	
	private static DecisionScanner instance;
	
	private DecisionScanner()
	{
		
		this.InitMapper();
		
		for(String pack : this.packArray)
		{
			Set<Class<?>> classes = ClassScan.getClasses(pack);
			
			for(Class<?> c : classes)
			{
				//System.out.println(c.getName());
				
				if(this.CheckAnnotation(c))
				{
					DecisionNodeEnum nodeType = this.GetAnnotationType(c);
					
					if(null != nodeType)
					{
						System.out.println("aa");
						
						System.out.println(nodeType.toString());
						
						this.decisionCondMapper.get(nodeType).add(c);
					}
					
				}
				
			}
		}
	}
	
	private void InitMapper()
	{
		this.decisionCondMapper = new EnumMap<DecisionNodeEnum,List<Class<?>>>(DecisionNodeEnum.class);
		
		for(DecisionNodeEnum node : DecisionNodeEnum.values())
		{
			this.decisionCondMapper.put(node, new ArrayList<Class<?>>());
		}
		
	}
	
	private DecisionNodeEnum GetAnnotationType(Class<?> AkClassTest)
	{
		
		String name = AkClassTest.getAnnotation(Decision.class).node();  
		
		System.out.println(name);
		
		return DecisionNodeEnum.getDecisionNodeEnumByName(name);
		
	}
	
	private boolean CheckAnnotation(Class<?> AkClassTest)
	{
		Annotation[] annotations = AkClassTest.getAnnotations();
		
        for(Annotation annotation : annotations)
        {
            //判斷當前注解對象是否為自定義注解
            if(annotation.annotationType() == com.icbc.pis.annotation.Decision.class)
            {
            	System.out.println("CheckAnnotation");
            	
            	return true;
            }
        }
        
		return false;
	}
	
	public static DecisionScanner GetInstance()
	{
		if(instance == null)
		{
			synchronized(syncRoot)
			{
				if (instance == null)
				{
					instance = new DecisionScanner();
				}
			}
		}
		return instance;
		
	}
}
