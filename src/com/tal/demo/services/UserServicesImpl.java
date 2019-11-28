package com.tal.demo.services;
//import java.sql.SQLException;
import java.util.ArrayList;

import com.tal.demo.beans.UserData;
import com.tal.demo.daoservices.UserDAO;
import com.tal.demo.daoservices.UserDAOImpl;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.exceptions.UserServicesDownException;
import com.tal.demo.exceptions.UserDetailsListNotFoundException;

import static com.tal.demo.constants.UserConstants.USER_DETAILS_NOT_FOUND_MESSAGE;
import static com.tal.demo.constants.UserConstants.USER_DETAILS_LIST_NOT_FOUND_MESSAGE;
import static com.tal.demo.constants.UserConstants.USER_SERVICES_DOWN_MESSAGE;


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
	public ArrayList<UserData> getAllUserDetails() throws UserDetailsListNotFoundException {
		ArrayList<UserData> userList=userDAO.findAll();
		if(userList == null) 
			throw new UserDetailsListNotFoundException(USER_DETAILS_LIST_NOT_FOUND_MESSAGE);
		
		return userList;
	}
	/*
	 * Method to save details of a user
	 */
	@Override
	public UserData acceptUserDetails(UserData user) throws UserServicesDownException {
		user=userDAO.save(user);
		if(user==null)
			throw new UserServicesDownException(USER_SERVICES_DOWN_MESSAGE);
		return userDAO.save(user);
	}
	/*
	 * Method to update details of a user
	 */
	@Override
	public boolean updateUserDetails(UserData user) {
		boolean flag=userDAO.update(user);
		if(flag)
		return flag;
		
		return false;
		
	}
	
	
}
