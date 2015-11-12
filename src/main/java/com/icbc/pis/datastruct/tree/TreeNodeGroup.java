package com.icbc.pis.datastruct.tree;

import java.util.List;

public class TreeNodeGroup {

	private String parentNodeCode;

	private TreeNodeList treeNodeList;
	
	private int level;

	public TreeNodeGroup( String parentNodeCode,TreeNodeList treeNodeList,int level)
	{
		//this.treeNodeList = treeNodeList;
		
		this.parentNodeCode = parentNodeCode;
		
		this.level = level;
		
		this.FindNode(treeNodeList);
	}
	
	public String getParentNodeCode() {
		return parentNodeCode;
	}

	public void setParentNodeCode(String parentNodeCode) {
		this.parentNodeCode = parentNodeCode;
	}

	public TreeNodeList getTreeNodeList() {
		return treeNodeList;
	}

	public void setTreeNodeList(TreeNodeList treeNodeList) {
		this.treeNodeList = treeNodeList;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	private void FindNode(TreeNodeList _treeNodeList)
	{
		this.treeNodeList = _treeNodeList.splitByParent(this.parentNodeCode);
	}
	
	
	
}
