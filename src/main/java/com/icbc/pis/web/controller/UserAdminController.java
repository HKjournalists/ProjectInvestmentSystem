package com.icbc.pis.web.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icbc.pis.datastruct.PaginationStruct;
import com.icbc.pis.datastruct.UserInfo;
import com.icbc.pis.role.service.impl.RoleService;
import com.icbc.pis.user.service.impl.UserRoleService;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;

@Controller
@RequestMapping("/user")
public class UserAdminController {

	private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	private UserInfo GenerateUserInfo(HttpSession httpSession,HttpServletRequest request){
		
		String userId = request.getParameter("id");
		
		String userName = request.getParameter("name");
		
		String userStatus = "1";
		
		String cardNo = request.getParameter("cardNo");
		
		String cardType = request.getParameter("cardType");
		
		String email = request.getParameter("email");
		
		String mobile = request.getParameter("mobile");
		
		String ext = request.getParameter("ext");
		
		String role = request.getParameter("role");
		
		String modUser = (String) httpSession.getAttribute("userId");
		
		Timestamp modTime = new Timestamp(System.currentTimeMillis());
		
		List<UserRole> userRoleList = new ArrayList();
		
		for(String roleid : role.split(","))
		{
			userRoleList.add(new UserRole(userId,roleid));
		}
		
		UserInfo userInfo = new UserInfo(new User(userId,userName,userStatus,ext,email,mobile, cardType, cardNo,modUser,modTime,null),userRoleList);
		
		return userInfo;
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String deleteUser(HttpSession httpSession,HttpServletRequest request)
	{
		String userId = request.getParameter("id");
		
		this.userService.deleteById(userId);
		
		return null;
	}
	
	
	@RequestMapping("/getUserRoleList")
	@ResponseBody
	public List<Map<String,String>> getUserRoleList(HttpServletRequest request)
	{
		logger.debug("begin getAllRoleList");
		
		String userId = request.getParameter("id");
		
		List<Map<String, String>> resList = new ArrayList<Map<String, String>>();

		List<UserRole> userRoleList =  this.userRoleService.getUserRole(userId);
		
		if(userRoleList != null)
		{
			for(UserRole userRole : userRoleList)
			{
				Map<String,String> map = new HashMap<String,String>();
				
				map.put("id", userRole.getRoleId());
				
				map.put("name",this.roleService.getRoleById(userRole.getRoleId()).getRoleName());
				
				resList.add(map);
			}
		}
		
		logger.debug("end getAllRoleList");
		
		return resList;
		
		
	}
	
	
	@RequestMapping("/saveUser")
	
	public String saveUser(HttpSession httpSession,HttpServletRequest request)
	{
		
		logger.debug("begin addNewUser");
		UserInfo user = this.GenerateUserInfo(httpSession,request);
		
		if(this.userService.isExists(user.getUserBasicInfo().getId()))
		{
			this.userService.update(user);
		}
		else
		{
			this.userService.add(user);
		}
		
		logger.debug("end saveUser");
		
		return null;
		//return "redirect:/views/index.html";
		
	}
	
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
				List<UserRole> userRoleList = this.userRoleService.getUserRole(user.getId());
				
				StringBuilder roleNameList = new StringBuilder();
				
				for(UserRole ur : userRoleList)
				{
					//String roleName = "";
					String roleName = this.roleService.getRoleById(ur.getRoleId()).getRoleName();
					
					roleNameList.append(roleName + ",");
				}
				
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("id", user.getId());
				
				map.put("name",user.getName());
				
				map.put("ext", user.getExt());
				
				map.put("email",user.getEmail());
				
				map.put("mobile", user.getMobile());
				
				map.put("role",roleNameList.toString());
				
				if(null != user.getLastLogin())
				{
					map.put("lastlogintime", user.getLastLogin().toString());
				}
				else
				{
					map.put("lastlogintime", "");
				}
				
				resList.add(map);
			}
		}
		
		PaginationStruct paginationStruct = new PaginationStruct(this.userService.count(),resList);
		
		logger.debug("finish getUsersByCondition");
		
		return paginationStruct;
	}
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request)
	{
		return "redirect:/views/index.html";
	}
}
