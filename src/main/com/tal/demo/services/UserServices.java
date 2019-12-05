package main.com.tal.demo.services;
import java.util.List;

import main.com.tal.demo.beans.UserData;
import main.com.tal.demo.exceptions.UserDetailsListNotFoundException;
import main.com.tal.demo.exceptions.UserDetailsNotFoundException;
import main.com.tal.demo.exceptions.UserServicesDownException;

public interface UserServices {
	
	UserData getUserDetails(String emailId) throws UserDetailsNotFoundException;
	List<UserData> getAllUserDetails()throws UserDetailsListNotFoundException;
	UserData acceptUserDetails(UserData user) throws UserServicesDownException;
	boolean updateUserDetails(UserData user);
}