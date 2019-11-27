package com.tal.demo.servlets;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static com.tal.demo.constants.UserConstants.PERSISTENCE_UNIT;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tal.demo.beans.UserData;
import com.tal.demo.daoservices.UserDAO;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.services.UserServicesImpl;
import com.tal.demo.util.EntityManagerFactoryProvider;


public class LoginServletTest {
	    @Mock
	    HttpServletRequest request;
	 
	    @Mock
	    HttpServletResponse response;
	    
	    @Mock
	    UserServicesImpl userServices;
	    
	    @Mock
	    HttpSession session;
	    
	    @Mock
	    UserDAO userDAO;
	    
	    @Mock
	    Persistence persistence;
	    
	    @Mock
	    EntityManagerFactoryProvider entityManagerFactoryProvider;
	    
	    @Mock
	    EntityManagerFactory factory;
	 
	    @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	    }
	 
	    @SuppressWarnings("deprecation")
		@Test
	    public void testDoPost_success() throws ServletException, IOException, UserDetailsNotFoundException  {
	    	
	    	UserData user=new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
	        when(request.getParameter("email")).thenReturn("neelam@gmail.com");
	        when(request.getParameter("password")).thenReturn("neelam");
	        when(request.getSession()).thenReturn(session);
	        when(userServices.getUserDetails("neelam@gmail.com")).thenReturn(user);
	        when(response.encodeURL("LoginSuccess.jsp")).thenReturn("");

	        doNothing().when(session).setAttribute("user", user);
	        doNothing().when(session).setMaxInactiveInterval(30);      
	        when(response.encodeUrl("LoginSuccess.jsp")).thenReturn("");
	        doNothing().when(response).sendRedirect("");
	        
		/*
		 * StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw);
		 */
	         
		/* when(response.getWriter()).thenReturn(pw); */
	        
	        LoginServlet loginServlet =new LoginServlet();
	       // loginServlet.doPost(request, response);
	        
	        //verify(loginServlet,times(1)).doPost(request, response);
		/*
		 * String result = sw.getBuffer().toString().trim(); assertEquals(result, new
		 * String("Full Name: Vinod Kashyap"));
		 */
	 
	    }
}
