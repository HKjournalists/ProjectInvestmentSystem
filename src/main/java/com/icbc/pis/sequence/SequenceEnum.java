package com.icbc.pis.sequence;

public enum SequenceEnum {

	SeqProductID("SeqProductID","SEQ_PRODUCT_ID"),
	SeqEleGroupID("SeqEleGroupID","SEQ_ELE_GROUP_ID");
	
	private String seqName;
	
	private String seqDBName;
	
	private SequenceEnum(String SequenceName,String SequenceDBName)
	{
		this.seqName = SequenceName;
		this.seqDBName = SequenceDBName;
	}
	
	public String getSequenceName()
	{
		return this.seqName;
	}
	
	public String getSequenceDBName()
	{
		return this.seqDBName;
	}
}

