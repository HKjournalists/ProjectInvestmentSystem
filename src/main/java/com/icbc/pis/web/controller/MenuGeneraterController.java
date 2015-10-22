package com.icbc.pis.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icbc.pis.Dashboard.dao.impl.MenuDao;
import com.icbc.pis.Dashboard.service.impl.MenuService;
import com.icbc.pis.datastruct.MenuItem;
import com.icbc.pis.web.model.ItemInfo;

@Controller
public class MenuGeneraterController {

	private static final Logger logger = LoggerFactory.getLogger(MenuGeneraterController.class);

	@Autowired
	private MenuService menuService;

	@RequestMapping("/MenuGenerater")
	@ResponseBody
	public List<MenuItem> checkUserLogin(HttpSession httpSession, HttpServletRequest request) {
		String UserId = (String) httpSession.getAttribute("UserId");
		List<MenuItem> resList = new ArrayList<MenuItem>();
		logger.debug("checkUserLogin");
		return menuService.assembleList(UserId);
	}

}
