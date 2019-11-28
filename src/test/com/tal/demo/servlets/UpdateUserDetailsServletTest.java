package test.com.tal.demo.servlets;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mock;

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
	    
	 @SuppressWarnings("deprecation")
		@Test
	    public void updateUserDetailsServlet_testDoPost_success() throws ServletException, IOException, UserDetailsNotFoundException  {
	    	
	    	UserData user=new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
	        when(request.getParameter("firstName")).thenReturn("neelam");
	        when(request.getParameter("lastName")).thenReturn("topno");
	        when(request.getParameter("mobile")).thenReturn("9123100545");
	        when(request.getParameter("city")).thenReturn("pune");
	        when(request.getParameter("state")).thenReturn("maharashtra");
	        
	        when(userServices.updateUserDetails(user)).thenReturn(true);
	        
	        when(response.encodeURL("LoginSuccess.jsp")).thenReturn("encodedURL");
	        doNothing().when(response).sendRedirect("encodedURL");
	        
		/*
		 * StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw);
		 */
	         
		/* when(response.getWriter()).thenReturn(pw); */
	        
	        UpdateUserDetailsServlet updateUserDetailsServlet =new UpdateUserDetailsServlet();
	        updateUserDetailsServlet.doPost(request, response);
	        
	        verify(userServices,times(1)).updateUserDetails(user);
		/*
		 * String result = sw.getBuffer().toString().trim(); assertEquals(result, new
		 * String("Full Name: Vinod Kashyap"));
		 */
	 
	    }
}
