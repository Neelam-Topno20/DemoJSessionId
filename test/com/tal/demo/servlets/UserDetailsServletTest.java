package com.tal.demo.servlets;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tal.demo.beans.UserData;
import com.tal.demo.daoservices.UserDAO;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.exceptions.UserServicesDownException;
import com.tal.demo.services.UserServicesImpl;
import com.tal.demo.util.EntityManagerFactoryProvider;

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
	 
	    @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	    }
	 
	    @SuppressWarnings("deprecation")
		@Test
	    public void userDetailsServlet_testDoPost_success() throws ServletException, IOException, UserDetailsNotFoundException, UserServicesDownException  {
	    	
	    	UserData user=new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
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
	        
	        doNothing().when(requestDispatcher).forward(request,response);
	     
	        
		/*
		 * StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw);
		 */
	         
		/* when(response.getWriter()).thenReturn(pw); */
	        
	        UserDetailsServlet userDetailsServlet =new UserDetailsServlet();
	        userDetailsServlet.doPost(request, response);
	        
	        //verify(userServices,times(1)).acceptUserDetails(user);
		/*
		 * String result = sw.getBuffer().toString().trim(); assertEquals(result, new
		 * String("Full Name: Vinod Kashyap"));
		 */
	 
	    }
}
