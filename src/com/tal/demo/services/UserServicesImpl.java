package com.tal.demo.services;
//import java.sql.SQLException;
import java.util.ArrayList;

import com.tal.demo.beans.UserData;
import com.tal.demo.daoservices.UserDAO;
import com.tal.demo.daoservices.UserDAOImpl;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.exceptions.PayrollServicesDownException;
//import org.jboss.logging.Logger;
public class UserServicesImpl implements UserServices {
	private UserDAO userDAO = new UserDAOImpl() ;
	@Override
	public UserData getUserDetails(String emailId) throws UserDetailsNotFoundException{
		UserData user;
		user = userDAO.findOne(emailId);
		if(user==null) 
			throw new UserDetailsNotFoundException("Associate Details Not Found");
		return user;
	}
	@Override
	public ArrayList<UserData> getAllAssociatesDetails() throws PayrollServicesDownException {
		return userDAO.findAll();
	}
	@Override
	public UserData acceptUserDetails(UserData associate) {
		return userDAO.save(associate);
	}
	@Override
	public boolean updateUserDetails(UserData user) {
		return userDAO.update(user);
	}
	
	
}
