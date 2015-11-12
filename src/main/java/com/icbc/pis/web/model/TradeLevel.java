package com.icbc.pis.web.model;

import com.icbc.pis.datastruct.tree.ITreeNode;
import com.icbc.pis.datastruct.tree.TreeNode;

public class TradeLevel  implements java.io.Serializable,ITreeNode {

	private String tradeCode;
	
	private String tradeName;
	
	private String parentCode;
	
	private String tradeLevel;
	
	private TradeLevel()
	{}
	
	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getTradeLevel() {
		return tradeLevel;
	}

	public void setTradeLevel(String tradeLevel) {
		this.tradeLevel = tradeLevel;
	}

	public TradeLevel(String tradeCode,String tradeName,String parentCode,String tradeLevel)
	{
		this.tradeCode = tradeCode;
		
		this.tradeName = tradeName;
		
		this.parentCode = parentCode;
		
		this.tradeLevel = tradeLevel;
	}

	@Override
	public TreeNode toTreeNode() {
		// TODO Auto-generated method stub
		return new TreeNode(this.tradeCode,this.tradeName,this.parentCode,this.tradeLevel);
	}
	
}
