package com.tal.demo.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tal.demo.beans.UserData;
import com.tal.demo.daoservices.UserDAO;
import com.tal.demo.exceptions.UserDetailsListNotFoundException;
import com.tal.demo.exceptions.UserDetailsNotFoundException;
import com.tal.demo.exceptions.UserServicesDownException;

public class UserServicesImplTest {

	@Mock
	UserDAO userDAO;

	@InjectMocks
	UserServicesImpl userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getUserDetails_test_success() throws UserDetailsNotFoundException {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(userDAO.findOne(ArgumentMatchers.anyString())).thenReturn(user);
		userService.getUserDetails("neelam@gmail.com");
		verify(userDAO, times(1)).findOne(ArgumentMatchers.anyString());
	}

	@Test(expected = UserDetailsNotFoundException.class)
	public void getUserDetails_test_failure() throws UserDetailsNotFoundException {
		when(userDAO.findOne(ArgumentMatchers.anyString())).thenReturn(null);
		userService.getUserDetails("neelam@gmail.com");
	}

	@Test
	public void getAllAssociatesDetails_test_success() throws UserDetailsListNotFoundException {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		UserData user2 = new UserData("ashav@gmail.com", "Ashav", "Kumar", "9123100545", "Pune", "Maharashtra");
		ArrayList<UserData> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);
		when(userDAO.findAll()).thenReturn(userList);
		userService.getAllUserDetails();
		verify(userDAO, times(1)).findAll();
	}

	@Test(expected = UserDetailsListNotFoundException.class)
	public void getAllAssociatesDetails_test_failure() throws UserDetailsListNotFoundException {
		when(userDAO.findAll()).thenReturn(null);
		userService.getAllUserDetails();
	}

	@Test
	public void acceptUserDetails_test_success() throws UserServicesDownException {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(userDAO.save(user)).thenReturn(user);
		userService.acceptUserDetails(user);
		verify(userDAO, times(2)).save(ArgumentMatchers.any(UserData.class));
	}

	@Test(expected = UserServicesDownException.class)
	public void acceptUserDetails_test_failure() throws UserServicesDownException {
		when(userDAO.save(ArgumentMatchers.any(UserData.class))).thenReturn(null);
		userService.acceptUserDetails(ArgumentMatchers.any(UserData.class));
	}

	@Test
	public void updateUserDetails_test_success() throws UserServicesDownException {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(userDAO.update(user)).thenReturn(true);
		userService.updateUserDetails(user);
		verify(userDAO, times(1)).update(user);
	}
}
