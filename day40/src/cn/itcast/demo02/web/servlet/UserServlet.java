package cn.itcast.demo02.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.demo02.domain.User;
import cn.itcast.demo02.service.UserService;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService us = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean check = "t".equals(request.getParameter("check"));
		boolean remember = "r".equals(request.getParameter("remember"));

		User user = us.login(username, password);
		HttpSession session = request.getSession();
		System.out.println(user);

		if (user != null) {

			if (check) {
				session.setAttribute("login", user);
			}

			if (remember) {
				Cookie cookie = new Cookie("up", username + "," + password);
				cookie.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(cookie);
			}

			request.getRequestDispatcher("/demo02/index.jsp").forward(request, response);

		} else {

			request.setAttribute("msg", "µÇÂ¼Ê§°Ü");
			request.getRequestDispatcher("/demo02/login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
