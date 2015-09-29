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
public class SysConfigController {

	private static final Logger logger = LoggerFactory
			.getLogger(SysConfigController.class);

	@RequestMapping("/getSysConfig")
	@ResponseBody
	public Map<String, String> getSysConfig(HttpSession httpSession,
			HttpServletRequest request) {
		Map<String, String> retMap = new HashMap<String, String>();
		retMap.put("projectPayAlertDays", "12");
		retMap.put("reportAlertDays", "120");
		logger.debug("finish checkUserLogin");
		return retMap;
	}
	@RequestMapping("/setSysConfig")
	@ResponseBody
	public Map<String, String> setSysConfig(HttpSession httpSession,
			HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
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
}
