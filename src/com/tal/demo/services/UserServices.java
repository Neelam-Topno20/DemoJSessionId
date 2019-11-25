package com.tal.demo.services;
import java.util.ArrayList;

import com.tal.demo.beans.UserData;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.exceptions.PayrollServicesDownException;

public interface UserServices {
	
	UserData getUserDetails(String emailId) throws UserDetailsNotFoundException;
	ArrayList<UserData> getAllAssociatesDetails()throws PayrollServicesDownException;
	UserData acceptUserDetails(UserData user);
	boolean updateUserDetails(UserData user);
}