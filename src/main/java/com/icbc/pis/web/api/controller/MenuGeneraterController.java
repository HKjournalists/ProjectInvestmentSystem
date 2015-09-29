package com.icbc.pis.web.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icbc.pis.web.utils.SessionConstant;

@Controller
public class MenuGeneraterController {

	private static final Logger logger = LoggerFactory
			.getLogger(MenuGeneraterController.class);

	@RequestMapping("/MenuGenerater")
	@ResponseBody
	public Map<String, String> checkUserLogin(HttpSession httpSession,
			HttpServletRequest request) {
		String UserId=(String) httpSession.getAttribute("UserId");
		Map<String, String> retMap = new HashMap<String, String>();
		logger.debug("checkUserLogin");
		if (userId != null && !userId.isEmpty() && userPwd != null
				&& !userPwd.isEmpty()) {
			String userTypeId="1";
					httpSession.setAttribute(SessionConstant.SESSION_USER_ID,
							userId);
					httpSession.setAttribute(SessionConstant.SESSION_USER_TYPE,
							userTypeId);
					retMap.put("error_code", "0");
					retMap.put("user_type", String.valueOf(userTypeId));
				}
			
		else {
			retMap.put("error_code", "-1");
		}
		logger.debug("finish checkUserLogin");
		return retMap;
	}

	
	@RequestMapping("/accounter/admin")
	public String getAccounterAdminHtml(HttpSession httpSession) {
		return "redirect:/views/webviews/accounter/admin.html";
	}
	
	@RequestMapping("/company/expenseAccountUpload")
	public String getCompanyAdminHtml(HttpSession httpSession) {
		return "redirect:/views/webviews/company/expense_account_upload.html";
	}
	
	@RequestMapping("/companyUser/expenseAccountUpload")
	public String getCompanyUserAdminHtml(HttpSession httpSession) {
		return "redirect:/views/webviews/companyUser/expense_account_upload.html";
	}
	
	@RequestMapping("/admin/admin")
	public String getAdminAdminHtml(HttpSession httpSession) {
		return "redirect:/views/webviews/admin/admin.html";
	}
}
