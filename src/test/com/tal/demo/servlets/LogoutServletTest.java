package test.com.tal.demo.servlets;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import main.com.tal.demo.exceptions.UserDetailsNotFoundException;
import main.com.tal.demo.services.UserServicesImpl;
import main.com.tal.demo.servlets.LogoutServlet;

public class LogoutServletTest {
	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Mock
	UserServicesImpl userServices;

	@Mock
	HttpSession session;

	@InjectMocks
	LogoutServlet logoutServlet;

	@Mock
	Cookie cookie;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void logoutServlet_testDoPost_success() throws ServletException, IOException, UserDetailsNotFoundException {
		when(cookie.getName()).thenReturn("JSESSIONID");
		when(cookie.getValue()).thenReturn("CookieValue");
		doNothing().when(cookie).setMaxAge(0);
		doNothing().when(response).addCookie(cookie);
		when(request.getCookies()).thenReturn(new Cookie[] { cookie });
		doNothing().when(response).setContentType("text/html");
		when(request.getSession(false)).thenReturn(session);
		doNothing().when(session).invalidate();
		logoutServlet.doPost(request, response);
	}
}
