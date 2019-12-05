package main.com.tal.demo.servlets;

import static main.com.tal.demo.constants.UserConstants.LOGIN_FAILED_MESSAGE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.tal.demo.beans.UserData;
import main.com.tal.demo.exceptions.UserDetailsNotFoundException;
import main.com.tal.demo.services.UserServices;
import main.com.tal.demo.services.UserServicesImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	UserServices userServices = new UserServicesImpl();

	private static final long serialVersionUID = 1L;

	/*
	 * EndPoint authenticates the user and logs in to the application
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserData user= (UserData) session.getAttribute("user");
		String emailId = "";
		String password="";
		try {
		if(user==null) {
		 emailId = request.getParameter("email");
		 password = request.getParameter("password");
		 user = userServices.getUserDetails(emailId);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(30);
			String encodedURL = response.encodeURL("LoginSuccess.jsp");
			response.sendRedirect(encodedURL);
		}
		else
		{
			session.setMaxInactiveInterval(30);
			response.encodeURL("LoginSuccess.jsp");

			RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoginSuccess.jsp");
			requestDispatcher.forward(request, response);
		}
	
			// setting session to expiry in 30 mins
			/*
			 * session.setMaxInactiveInterval(30); String encodedURL =
			 * response.encodeURL("LoginSuccess.jsp"); response.sendRedirect(encodedURL);
			 */
		} catch (UserDetailsNotFoundException e) {

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexPage.jsp");
			PrintWriter out = response.getWriter();
			out.println(LOGIN_FAILED_MESSAGE);
			rd.include(request, response);
			e.printStackTrace();
		}

	}
}