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
	//private static final Logger logger = Logger.getLogger(PayrollServicesImpl.class);
	/*
	 * @Override public int acceptAssociateDetails(String firstName, String
	 * lastName, String emailId, String department, String designation, String
	 * pancard, int yearlyInvestmentUnder80C, int basicSalary, int epf, int
	 * companyPf, int accountNumber, String bankName, String ifscCode) throws
	 * PayrollServicesDownException { Associate associate = new
	 * Associate(yearlyInvestmentUnder80C, firstName, lastName, department,
	 * designation, pancard, emailId, new BankDetails(accountNumber, bankName,
	 * ifscCode), new Salary(basicSalary, epf, companyPf));
	 * associate=associateDAO.save(associate); return associate.getAssociateID(); }
	 */
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
	
	
}
