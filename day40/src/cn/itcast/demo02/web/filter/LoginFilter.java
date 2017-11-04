package cn.itcast.demo02.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.itcast.demo02.domain.User;
import cn.itcast.demo02.service.UserService;

public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		Cookie[] cookies = req.getCookies();

		UserService us = new UserService();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("up".equals(cookie.getName())) {

					String s = cookie.getValue();

					String[] step = s.split(",");

					User user = us.login(step[0], step[1]);

					if (user != null) {
						req.getSession().setAttribute("login", user);;
					}
				}
			}
		}

		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
