package com.icbc.pis.sequence;

import javax.sql.DataSource;

public class SequenceGenerator {

	private static SequenceGenerator instance;
	
	private static  Object syncRoot = new Object();
	
	private DataSource dataSource;
	
	private SequenceGenerator(DataSource datasrc){
		
		this.dataSource = datasrc;
	}
	
	public static SequenceGenerator GetInstance(DataSource datasrc)
	{
		if(instance == null)
		{
			synchronized(syncRoot)
			{
				if (instance == null)
				{
					instance = new SequenceGenerator(datasrc);
				}
			}
		}
		return instance;
	}
	
	public int GetNextIntValue(String seqName)
	{
		return SequenceContainer.GetSequence(seqName, this.dataSource).nextIntValue();
	}
	
}
