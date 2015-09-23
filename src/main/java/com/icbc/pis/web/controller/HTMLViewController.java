package com.icbc.pis.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.icbc.pis.web.utils.SessionConstant;


@Controller
public class HTMLViewController {

	//门户网站	
	@RequestMapping("/")
	public String getRootHtml() {
		System.out.println("222");
		return "redirect:/index.html";
	}
	
	@RequestMapping("/error")
	public String getErrorHtml() {
		return "redirect:/views/frontviews/error.html";
	}
	
	//后台网站	
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute(SessionConstant.SESSION_USER_ID);
		httpSession.removeAttribute(SessionConstant.SESSION_COMPANY_NOT_FINISH_REGISTER);
		httpSession.removeAttribute(SessionConstant.SESSION_USER_TYPE);
		return "redirect:./pages/login.html";
	}
}