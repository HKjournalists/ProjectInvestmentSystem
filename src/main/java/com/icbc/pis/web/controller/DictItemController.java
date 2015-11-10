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
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.web.model.DictItem;
import com.icbc.pis.web.model.UserRole;

@Controller
@RequestMapping("/dict")
public class DictItemController {

	private static final Logger logger = LoggerFactory.getLogger(DictItemController.class);

	@Autowired
	private DictService dictService;
	
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
}
