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

import com.icbc.pis.role.service.impl.RoleService;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.web.api.controller.SysConfigController;
import com.icbc.pis.web.model.Role;
import com.icbc.pis.web.model.User;

@Controller
@RequestMapping("/role")
public class RoleAdminController {

	private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/getAllRoleList")
	@ResponseBody
	public List<Map<String,String>> getAllRoleList(HttpServletRequest request) {
		
		logger.debug("begin getAllRoleList");
		
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();

		List<Role> roleList =  this.roleService.getAllRoleList();
		
		if(roleList != null)
		{
			for(Role role : roleList)
			{
				Map<String,String> map = new HashMap<String,String>();
				
				map.put("id", role.getRoleId());
				
				map.put("name", role.getRoleName());
				
				map.put("desc", role.getDesc());
				
				resList.add(map);
			}
		}
		
		logger.debug("end getAllRoleList");
		
		return resList;
		
	}


}
