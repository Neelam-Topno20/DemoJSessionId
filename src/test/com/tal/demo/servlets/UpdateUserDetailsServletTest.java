package test.com.tal.demo.servlets;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import main.com.tal.demo.beans.UserData;
import main.com.tal.demo.exceptions.UserDetailsNotFoundException;
import main.com.tal.demo.services.UserServicesImpl;
import main.com.tal.demo.servlets.UpdateUserDetailsServlet;

public class UpdateUserDetailsServletTest {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Mock
	UserServicesImpl userServices;

	@Mock
	HttpSession session;

	@Mock
	RequestDispatcher requestDispatcher;

	@InjectMocks
	UpdateUserDetailsServlet updateUserDetailsServlet;

	@Mock
	ServletContext ServletContext;
	
	@Mock
	PrintWriter printWriter;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void updateUserDetailsServlet_testDoPost_success()
			throws ServletException, IOException, UserDetailsNotFoundException {

		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(request.getParameter("firstName")).thenReturn("neelam");
		when(request.getParameter("lastName")).thenReturn("topno");
		when(request.getParameter("mobile")).thenReturn("9123100545");
		when(request.getParameter("city")).thenReturn("pune");
		when(request.getParameter("state")).thenReturn("maharashtra");
		when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("user")).thenReturn(user).thenReturn(user);
		doNothing().when(session).setAttribute("user", user);
		doNothing().when(session).setMaxInactiveInterval(30);;
		doNothing().when(response).sendRedirect("indexPage.jsp");
		when(userServices.updateUserDetails(user)).thenReturn(true);
		when(userServices.getUserDetails("neelam@gmail.com")).thenReturn(user);
		doNothing().when(requestDispatcher).forward(request, response);
		when(request.getRequestDispatcher("LoginSuccess.jsp")).thenReturn(requestDispatcher);
		updateUserDetailsServlet.doPost(request, response);
	}
	@Test
	public void updateUserDetailsServlet_testDoPost_failure()
			throws ServletException, IOException, UserDetailsNotFoundException {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(request.getParameter("firstName")).thenReturn("neelam");
		when(request.getParameter("lastName")).thenReturn("topno");
		when(request.getParameter("mobile")).thenReturn("9123100545");
		when(request.getParameter("city")).thenReturn("pune");
		when(request.getParameter("state")).thenReturn("maharashtra");
		when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("user")).thenReturn(user).thenReturn(user);
		doNothing().when(session).setAttribute("user", user);
		doNothing().when(session).setMaxInactiveInterval(30);;
		doNothing().when(response).sendRedirect("indexPage.jsp");
		when(userServices.updateUserDetails(user)).thenReturn(false);
		doNothing().when(requestDispatcher).include(request, response);
		when(response.getWriter()).thenReturn(printWriter);
		doNothing().when(requestDispatcher).forward(request, response);
		when(request.getRequestDispatcher("LoginSuccess.jsp")).thenReturn(requestDispatcher);
		updateUserDetailsServlet.doPost(request, response);
	}
}
