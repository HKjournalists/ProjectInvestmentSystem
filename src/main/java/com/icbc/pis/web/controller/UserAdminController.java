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

import com.icbc.pis.datastruct.PaginationStruct;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.web.api.controller.SysConfigController;
import com.icbc.pis.web.model.User;

@Controller
@RequestMapping("/user")
public class UserAdminController {

	private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUsersByCondition")
	@ResponseBody
	public PaginationStruct getUsersByCondition(HttpServletRequest request) {

		logger.debug("begin getUsersByCondition");
		//System.out.println("begin getAllUserList");
		Map<String,String[]> filterCond =  request.getParameterMap();
		
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();

		List<User> userList = this.userService.getUsersByCondition(filterCond);
		
		if (userList != null)
		{
			for(User user : userList)
			{
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("id", user.getUserId());
				
				map.put("name",user.getUserName());
				
				map.put("ext", user.getExt());
				
				map.put("email",user.getEmail());
				
				map.put("mobile", user.getMobile());
				
				map.put("createtime", user.getCreateTime().toString());
				
				resList.add(map);
			}
		}
		
		PaginationStruct paginationStruct = new PaginationStruct(5,resList);
		
		
		
		logger.debug("finish getUsersByCondition");
		
		return paginationStruct;
	}
}
