package com.icbc.pis.datastruct.tree;

import java.util.Iterator;
import java.util.List;

public class TreeNode {

	private String nodeCode;
	
	private String nodeName;
	
	private String parentNodeCode;
	
	private int nodeLvl;
	
	private int childrenNum;
	
	private TreeNodeList children;


	public TreeNode(String nodeCode,String nodeName,String parentNodeCode,String nodeLvl)
	{
		this.nodeCode = nodeCode;
		
		this.nodeName = nodeName;
		
		this.parentNodeCode = parentNodeCode;
		
		this.nodeLvl = Integer.parseInt(nodeLvl);
		
		this.childrenNum = 0;
		
		this.children = new TreeNodeList();
	}
	
	public TreeNode(String nodeCode,String nodeName,String parentNodeCode,String nodeLvl,int childrenNum)
	{
		this.nodeCode = nodeCode;
		
		this.nodeName = nodeName;
		
		this.parentNodeCode = parentNodeCode;
		
		this.nodeLvl = Integer.parseInt(nodeLvl);
		
		this.childrenNum = childrenNum;
		
		this.children = new TreeNodeList();
	}
	
	public boolean FindChildren(TreeNode treeNode,List<TreeNodeList> nodeGrpList)
	{
		int lvl = treeNode.nodeLvl;
		
		if(nodeGrpList.size() <= (lvl + 1))
		{
			return false;
		}
		else
		{
			for(int i = 0 ; i < nodeGrpList.get(1 + lvl).size(); ++i)
			{
				if(nodeGrpList.get(1 + lvl).get(i).parentNodeCode.equals(treeNode.nodeCode))
				{
					treeNode.FindChildren(nodeGrpList.get(1 + lvl).get(i), nodeGrpList);
					
					treeNode.children.add(nodeGrpList.get(1 + lvl).get(i));
				}
			}
		}
		
		return true;
		
//		while(it.hasNext())
//		{
//			if(((TreeNode)it.next()).parentNodeCode.equals(parentCode))
//			{
//				this.childList.add((TreeNode)it.next());
//			}
//			
//			if()
//			{
//				
//			}
//		}
//		
//		this.childrenNum = this.childList.size();
//		
//		return this.childList.size();
	}
	
	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getParentNodeCode() {
		return parentNodeCode;
	}

	public void setParentNodeCode(String parentNodeCode) {
		this.parentNodeCode = parentNodeCode;
	}

	public int getNodeLvl() {
		return nodeLvl;
	}

	public void setNodeLvl(int nodeLvl) {
		this.nodeLvl = nodeLvl;
	}

	public int getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}
	
	
	public TreeNodeList getChildList() {
		return children;
	}

	public void setChildList(TreeNodeList childList) {
		this.children = childList;
	}
}
