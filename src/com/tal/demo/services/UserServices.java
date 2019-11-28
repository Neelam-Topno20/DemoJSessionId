package com.tal.demo.services;
import java.util.ArrayList;

import com.tal.demo.beans.UserData;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.exceptions.UserServicesDownException;
import com.tal.demo.exceptions.UserDetailsListNotFoundException;

public interface UserServices {
	
	UserData getUserDetails(String emailId) throws UserDetailsNotFoundException;
	ArrayList<UserData> getAllUserDetails()throws UserDetailsListNotFoundException;
	UserData acceptUserDetails(UserData user) throws UserServicesDownException;
	boolean updateUserDetails(UserData user);
}