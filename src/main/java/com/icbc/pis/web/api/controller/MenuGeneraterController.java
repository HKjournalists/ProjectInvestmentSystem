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
		
		return retMap;
	}

}
