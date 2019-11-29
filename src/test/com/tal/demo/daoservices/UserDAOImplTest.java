package test.com.tal.demo.daoservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import main.com.tal.demo.beans.UserData;
import main.com.tal.demo.daoservices.UserDAOImpl;

public class UserDAOImplTest {
	@Mock
	EntityManagerFactory factory;

	@Mock
	EntityManager entityManager;

	@Mock
	EntityTransaction transaction;

	@Mock
	Query query;

	@InjectMocks
	UserDAOImpl userDAO;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findOne_test_success() {
		UserData expectedUser = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune",
				"Maharashtra");
		when(entityManager.find(UserData.class, "neelam@gmail.com")).thenReturn(expectedUser);
		UserData actualUser = userDAO.findOne("neelam@gmail.com");
		assertEquals(expectedUser, actualUser);
	}

	@Test
	public void findOne_test_failure() {
		when(entityManager.find(UserData.class, "neelam@gmail.com")).thenReturn(null);
		UserData actualUser = userDAO.findOne("neelam@gmail.com");
		assertNull(actualUser);
	}

	@Test
	public void update_test_success() {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(entityManager.getTransaction()).thenReturn(transaction);
		when(entityManager.merge(user)).thenReturn(user);
		doNothing().when(entityManager).close();
		boolean flag = userDAO.update(user);
		assertTrue(flag);
		verify(transaction).begin();
		verify(entityManager, times(1)).merge(user);
	}

	@Test
	public void update_test_failure() {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(entityManager.getTransaction()).thenReturn(transaction);
		when(entityManager.merge(user)).thenReturn(null);
		doNothing().when(entityManager).close();
		boolean flag = userDAO.update(user);
		assertFalse(flag);
		verify(transaction).begin();
		verify(entityManager, times(1)).merge(user);
	}

	@Test
	public void save_test_success() {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).persist(user);
		doNothing().when(entityManager).close();
		user = userDAO.save(user);
		assertNotNull(user);
		verify(transaction).begin();
		verify(entityManager, times(1)).persist(user);
	}

	@Test
	public void findAll_test_success() {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		UserData user2 = new UserData("ashav@gmail.com", "Ashav", "Kumar", "9123100545", "Pune", "Maharashtra");
		ArrayList<UserData> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);
		when(entityManager.createQuery(anyString())).thenReturn(query);
		when(query.getResultList()).thenReturn(userList);
		userDAO.findAll();
		verify(entityManager, times(1)).createQuery(anyString());
	}

	@Test
	public void findAll_test_failure() {
		UserData user = new UserData("neelam@gmail.com", "Neelam", "Topno", "9905303708", "Pune", "Maharashtra");
		UserData user2 = new UserData("ashav@gmail.com", "Ashav", "Kumar", "9123100545", "Pune", "Maharashtra");
		ArrayList<UserData> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);
		when(entityManager.createQuery(anyString())).thenReturn(query);
		when(query.getResultList()).thenReturn(null);
		userList = userDAO.findAll();
		assertNull(userList);
		verify(entityManager, times(1)).createQuery(anyString());
	}
}