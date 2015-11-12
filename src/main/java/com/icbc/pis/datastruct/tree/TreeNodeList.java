package com.icbc.pis.datastruct.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNodeList extends ArrayList<TreeNode>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TreeNodeList()
	{
		
	}
	
	public TreeNodeList(List<?> arrayList)
	{
		//Iterator<?> it = arrayList.iterator();
		
		for(Iterator<?> it = arrayList.iterator();it.hasNext();)
		{
			ITreeNode n = (ITreeNode)it.next();
			
			super.add((TreeNode) n.toTreeNode());
		}
	}
	
	public int getMaxLevel()
	{
		try
		{
			int maxLevel = 0;
			
			for(int i = 0 ; i < this.size(); ++i)
			{
				
				int lvl = ((TreeNode) super.get(i)).getNodeLvl();
				
				if(lvl > maxLevel)
				{
					maxLevel = lvl;
				}
			}
			
			return maxLevel;
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
	
	public List<TreeNodeList> split(String parentCode)
	{
		int maxLvl = this.getMaxLevel();
		
		
		return null;
	}
	
	public List<TreeNodeList> splitByLevel(int level)
	{
		List<TreeNodeList> resList = new ArrayList<TreeNodeList>();
		
		for(int i = 0; i <= level; ++i)
		{
			TreeNodeList treeNodeList = new TreeNodeList();
			
			for(int j = 0 ; j < this.size() ; ++j)
			{
				if((this.get(j)).getNodeLvl() == i)
				{
					treeNodeList.add(this.get(j));
				}
			}
			
			resList.add(treeNodeList);
		}
		
		return resList;
	}
	
	public TreeNodeList splitByParent(String parentCode)
	{
		TreeNodeList treeNodeList = new TreeNodeList();
		
		for(int i = 0 ; i < this.size() ; ++i)
		{
			if(parentCode.equals(this.get(i).getParentNodeCode()))
			{
				treeNodeList.add(this.get(i));
			}
		}
		
		return treeNodeList;
	}
}
