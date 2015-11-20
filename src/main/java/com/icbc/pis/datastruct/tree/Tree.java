package com.icbc.pis.datastruct.tree;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Tree {
	
	//private List<List<TreeNodeGroup>> tree;

	TreeNode rootNode;
	
	//private int levelNum;
	
	public Tree(TreeNodeList tnl)
	{
		//this.levelNum = tnl.getMaxLevel();
		
		//Iterator it = tnl.iterator();
		
		List<TreeNodeList> nodeGrpList = tnl.splitByLevel(tnl.getMaxLevel());
		
		String rootCode = null;
		
		if(nodeGrpList.size() > 0)
		{
			//rootCode = nodeGrpList.get(0).get(0).getNodeCode();
			
			this.rootNode = nodeGrpList.get(0).get(0);
			
			rootNode.FindChildren(this.rootNode,nodeGrpList);
		}
		
//		List<TreeNodeList> levelList = tnl.splitByLevel(this.levelNum);
//		
//		this.tree = new ArrayList<List<TreeNodeGroup>>();
//		
//		for(int i = 0 ; i < levelList.size() - 1; ++i)
//		{
//			List<TreeNodeGroup> tngList = new ArrayList<TreeNodeGroup>();
//			
//			for(int j = 0 ; j < levelList.get(i).size(); ++j)
//			{
//				TreeNodeGroup tng = new TreeNodeGroup(levelList.get(i).get(j).getNodeCode(),
//													  levelList.get(i + 1),
//													  i);
//				
//				tngList.add(tng);
//			}
//			
//			this.tree.add(tngList);
//		}
	}

	public String toString()
	{
		Gson gson = new Gson();
		
		String result = gson.toJson(this);
		
		return result;
	}
	


}
