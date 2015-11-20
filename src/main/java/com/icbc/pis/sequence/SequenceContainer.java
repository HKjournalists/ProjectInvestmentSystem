package com.icbc.pis.sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

public class SequenceContainer {
	
	public static Map<String,OracleSequenceMaxValueIncrementer> sequenceMap = new HashMap<String,OracleSequenceMaxValueIncrementer>() ;
	
	public static OracleSequenceMaxValueIncrementer GetSequence(String seqName,DataSource dataSource)
	{
		if(sequenceMap.keySet().isEmpty() || sequenceMap.keySet() == null)
		{
			OracleSequenceMaxValueIncrementer s = new OracleSequenceMaxValueIncrementer(dataSource, seqName);
			
			sequenceMap.put(seqName, s);
			
			return s;
		}
		else
		{
			if(sequenceMap.keySet().contains(seqName))
			{
				return sequenceMap.get(seqName);
			}
			else
			{
				OracleSequenceMaxValueIncrementer s = new OracleSequenceMaxValueIncrementer(dataSource, seqName);
				
				sequenceMap.put(seqName, s);
				
				return s;
			}
		}
	}
}
