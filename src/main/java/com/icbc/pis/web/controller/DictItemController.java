package com.icbc.pis.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icbc.pis.common.service.impl.DictService;
import com.icbc.pis.common.service.impl.TradeLevelService;
import com.icbc.pis.datastruct.tree.Tree;
import com.icbc.pis.datastruct.tree.TreeNode;
import com.icbc.pis.datastruct.tree.TreeNodeList;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.web.model.DictItem;
import com.icbc.pis.web.model.TradeLevel;
import com.icbc.pis.web.model.UserRole;

@Controller
@RequestMapping("/dict")
public class DictItemController {

	private static final Logger logger = LoggerFactory.getLogger(DictItemController.class);

	@Autowired
	private DictService dictService;
	
	@Autowired
	private TradeLevelService tradeLevelService;
	
	
	@RequestMapping("/getDictItemList")
	@ResponseBody
	public List<Map<String,String>> getDictItemList(HttpServletRequest request)
	{
		logger.debug("begin getDictItemList");
		
		String type = request.getParameter("type");
		
		List<DictItem> dictItemList = this.dictService.queryByType(type);
		
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();
		
		if(dictItemList != null)
		{
			for(DictItem dictItem : dictItemList)
			{
				Map<String,String> map = new HashMap<String,String>();
				
				map.put("key", dictItem.getKey());
				
				map.put("value",dictItem.getValue());
				
				resList.add(map);
			}
		}
		
		logger.debug("end getDictItemList");
		
		return resList;
		
	}
	
	@RequestMapping(value = "/getTradeLevelList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getTradeLevelList(HttpServletRequest request)
	{
		List<TradeLevel> tradeLvlList = this.tradeLevelService.queryAll();
		
		TreeNodeList treeNodeList = new TreeNodeList(tradeLvlList);
		
		Tree tree = new Tree(treeNodeList);
		
		System.out.println(tree.toString());
		
		return tree.toString();
	}
}
