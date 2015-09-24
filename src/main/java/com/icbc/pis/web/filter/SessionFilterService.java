package com.icbc.pis.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.icbc.pis.web.utils.SessionConstant;


public class SessionFilterService extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory
			.getLogger(SessionFilterService.class);
	
	private String[] filterUrls;

	public SessionFilterService() {
		filterUrls = new String[] {"login", "bower_components","dist","js","less","other","checkUserLogin"};
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		boolean doFilter = true;
        for (String url : filterUrls) {
				if (uri.indexOf(url) != -1) {
					doFilter = false;
					break;
				}
			}
		if (doFilter) {
			Object userId = request.getSession().getAttribute(
					SessionConstant.SESSION_USER_ID);
			Object userTypeId = request.getSession().getAttribute(
					SessionConstant.SESSION_USER_TYPE);
			if (null == userId) {
				logger.debug("user id is null.");
				boolean isAjaxRequest = isAjaxRequest(request);
				if (isAjaxRequest) {
					response.setCharacterEncoding("UTF-8");
					response.sendError(HttpStatus.UNAUTHORIZED.value(),
							"Unauthorized!");
					return;
				}
				response.sendRedirect("./views/index.html#/login");
				return;
			} else {
				boolean noAuth = false;
			}
		}
		filterChain.doFilter(request, response);
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}

}