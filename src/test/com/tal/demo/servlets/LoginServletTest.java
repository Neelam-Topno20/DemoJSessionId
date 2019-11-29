package test.com.tal.demo.servlets;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

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
import main.com.tal.demo.servlets.LoginServlet;

public class LoginServletTest {
	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Mock
	UserServicesImpl userServices;

	@Mock
	HttpSession session;

	@InjectMocks
	LoginServlet loginServlet;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loginServlet_testDoPost_success() throws ServletException, IOException, UserDetailsNotFoundException {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(request.getParameter("email")).thenReturn("neelam@gmail.com");
		when(request.getParameter("password")).thenReturn("neelam");
		when(request.getSession()).thenReturn(session);
		when(userServices.getUserDetails("neelam@gmail.com")).thenReturn(user);
		when(response.encodeURL("LoginSuccess.jsp")).thenReturn("");
		doNothing().when(session).setAttribute("user", user);
		doNothing().when(session).setMaxInactiveInterval(30);
		doNothing().when(response).sendRedirect("");
		loginServlet.doPost(request, response);
		verify(userServices, times(1)).getUserDetails("neelam@gmail.com");
	}

	@Test()
	public void loginServlet_testDoPost_failure() throws ServletException, IOException, UserDetailsNotFoundException {
		when(request.getParameter("email")).thenReturn("neelam@gmail.com");
		when(request.getParameter("password")).thenReturn("neelam");
		when(request.getSession()).thenReturn(session);
		when(userServices.getUserDetails("neelam@gmail.com")).thenReturn(null);
		when(response.encodeURL("LoginSuccess.jsp")).thenReturn("");
		loginServlet.doPost(request, response);
	}

}
