package test.com.tal.demo.servlets;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
import main.com.tal.demo.exceptions.UserServicesDownException;
import main.com.tal.demo.services.UserServicesImpl;
import main.com.tal.demo.servlets.UserDetailsServlet;

public class UserDetailsServletTest {
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
	UserDetailsServlet userDetailsServlet;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void userDetailsServlet_testDoPost_success()
			throws ServletException, IOException, UserDetailsNotFoundException, UserServicesDownException {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(request.getParameter("firstName")).thenReturn("neelam");
		when(request.getParameter("lastName")).thenReturn("topno");
		when(request.getParameter("emailId")).thenReturn("neelam@gmail.com");
		when(request.getParameter("password")).thenReturn("neelam");
		when(request.getParameter("mobile")).thenReturn("9123100545");
		when(request.getParameter("city")).thenReturn("pune");
		when(request.getParameter("state")).thenReturn("maharashtra");
		when(userServices.acceptUserDetails(user)).thenReturn(user);
		doNothing().when(request).setAttribute("user", user);
		when(request.getRequestDispatcher("RegistrationSuccess.jsp")).thenReturn(requestDispatcher);
		doNothing().when(requestDispatcher).forward(request, response);
		doNothing().when(response).sendRedirect("indexPage.jsp");
		when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("user")).thenReturn(user);

		userDetailsServlet.doPost(request, response);
	}
	@Test
	public void userDetailsServlet_testDoPost_failure()
			throws ServletException, IOException, UserDetailsNotFoundException, UserServicesDownException {
		doNothing().when(response).sendRedirect("indexPage.jsp");
		when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("user")).thenReturn(null);

		userDetailsServlet.doPost(request, response);
	}
}
