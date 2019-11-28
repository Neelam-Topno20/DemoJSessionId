package com.tal.demo.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.el.parser.ParseException;

import com.tal.demo.beans.UserData;
import com.tal.demo.exceptions.UserServicesDownException;
import com.tal.demo.services.UserServices;
import com.tal.demo.services.UserServicesImpl;
@WebServlet("/UserDetails")
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * EndPoint to register a new user to the application
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String city= request.getParameter("city");
		String state = request.getParameter("state");
		UserData user = new UserData(emailId, firstName, lastName, password, mobile, city, state);
		UserServices userServices = new UserServicesImpl();
		try {
			user=userServices.acceptUserDetails(user);
		} catch (UserServicesDownException e) {
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationSuccess.jsp");
		dispatcher.forward(request, response);
	}
}