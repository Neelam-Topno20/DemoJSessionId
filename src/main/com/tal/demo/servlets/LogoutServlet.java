package main.com.tal.demo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.tal.demo.beans.UserData;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * EndPoint to log out a user
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserData user= (UserData) session.getAttribute("user");
		if(user==null) {
			response.sendRedirect("indexPage.jsp");
		}
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					System.out.println("JSESSIONID=" + cookie.getValue());
				}
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		// invalidate the session if exists
		 session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		// no encoding because we have invalidated the session
		response.sendRedirect("indexPage.jsp");
	}

}
