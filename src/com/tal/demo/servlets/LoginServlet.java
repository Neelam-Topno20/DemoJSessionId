package com.tal.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tal.demo.beans.UserData;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.services.UserServices;
import com.tal.demo.services.UserServicesImpl;
import static com.tal.demo.constants.UserConstants.LOGIN_FAILED_MESSAGE;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	UserServices userServices= new UserServicesImpl();
	
	private static final long serialVersionUID = 1L;
	/*
	 * EndPoint authenticates the user and logs in to the application
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			UserData user=userServices.getUserDetails(emailId);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30);
			//Cookie userName = new Cookie("user", user);
			//response.addCookie(userName);
			
			String encodedURL = response.encodeURL("LoginSuccess.jsp");
			response.sendRedirect(encodedURL);
		} catch (UserDetailsNotFoundException e) {
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexPage.jsp");
			PrintWriter out= response.getWriter();
			out.println(LOGIN_FAILED_MESSAGE);
			rd.include(request, response);
			e.printStackTrace();
		}
		
		
	}
}