package com.tal.demo.services;
//import java.sql.SQLException;
import java.util.ArrayList;

import com.tal.demo.beans.UserData;
import com.tal.demo.daoservices.UserDAO;
import com.tal.demo.daoservices.UserDAOImpl;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.exceptions.PayrollServicesDownException;
import static com.tal.demo.constants.UserConstants.USER_DETAILS_NOT_FOUND_MESSAGE;

public class UserServicesImpl implements UserServices {
	private UserDAO userDAO = new UserDAOImpl() ;
	/*
	 * Method to retrieve user details using emailId 
	 */
	@Override
	public UserData getUserDetails(String emailId) throws UserDetailsNotFoundException{
		UserData user;
		user = userDAO.findOne(emailId);
		if(user==null) 
			throw new UserDetailsNotFoundException(USER_DETAILS_NOT_FOUND_MESSAGE);
		return user;
	}
	
	/*
	 * Method to retrieve the list of details of all the users
	 */
	@Override
	public ArrayList<UserData> getAllAssociatesDetails() throws PayrollServicesDownException {
		return userDAO.findAll();
	}
	/*
	 * Method to save details of a user
	 */
	@Override
	public UserData acceptUserDetails(UserData user) {
		return userDAO.save(user);
	}
	/*
	 * Method to update details of a user
	 */
	@Override
	public boolean updateUserDetails(UserData user) {
		return userDAO.update(user);
	}
	
	
}
