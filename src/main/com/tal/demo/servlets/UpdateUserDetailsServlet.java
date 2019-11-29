package main.com.tal.demo.servlets;

import static main.com.tal.demo.constants.UserConstants.USER_UPDATE_FAILED_MESSAGE;

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

@WebServlet("/UpdateUserDetails")
public class UpdateUserDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/*
	 * EndPoint to update user details
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserData user= (UserData) session.getAttribute("user");
		if(user==null) {
			response.sendRedirect("indexPage.jsp");
		}
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobile = request.getParameter("mobile");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		UserData tempUser = (UserData) session.getAttribute("user");
		 user=new UserData(tempUser.getEmailId(), firstName, lastName, tempUser.getPassword(), mobile, city, state);
		UserServices userServices = new UserServicesImpl();
		boolean flag = userServices.updateUserDetails(user);
		if (flag) {
			try {
				user=userServices.getUserDetails(tempUser.getEmailId());
			} catch (UserDetailsNotFoundException e) {
				e.printStackTrace();
			}
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(30);
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserDetailsPage.jsp");
			PrintWriter out = response.getWriter();
			out.println(USER_UPDATE_FAILED_MESSAGE);
			rd.include(request, response);
		}
	}
}
