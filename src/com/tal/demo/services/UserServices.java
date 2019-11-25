package com.tal.demo.services;
import java.util.ArrayList;

import com.tal.demo.beans.UserData;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.exceptions.PayrollServicesDownException;

public interface UserServices {
	/*
	 * int acceptAssociateDetails(String firstName, String lastName, String emailId,
	 * String department, String designation, String pancard, int
	 * yearlyInvestmentUnder80C, int basicSalary, int epf, int companyPf, int
	 * accountNumber, String bankName, String ifscCode) throws
	 * PayrollServicesDownException;
	 */
	UserData getUserDetails(String emailId) throws UserDetailsNotFoundException;
	ArrayList<UserData> getAllAssociatesDetails()throws PayrollServicesDownException;
	UserData acceptUserDetails(UserData user);
}