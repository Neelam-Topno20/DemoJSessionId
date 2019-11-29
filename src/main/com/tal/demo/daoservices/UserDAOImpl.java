package main.com.tal.demo.daoservices;

import static main.com.tal.demo.constants.UserConstants.FIND_ALL_QUERY;

import java.util.ArrayList;
import java.util.Comparator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import main.com.tal.demo.beans.UserData;
import main.com.tal.demo.util.EntityManagerFactoryProvider;;

public class UserDAOImpl implements UserDAO {
	

	/*
	 * Method to persist user details
	 */
	@Override
	public UserData save(UserData user) {
		EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		return user;
	}

	/*
	 * Method to update user details
	 */
	@Override
	public boolean update(UserData user) {
		EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
		EntityManager entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			user = entityManager.merge(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			if (user == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * Method to retrieve user details based on emailId from the database
	 */
	@Override
	public UserData findOne(String emailId) {
		EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
		EntityManager entityManager = factory.createEntityManager();
		return entityManager.find(UserData.class, emailId);
	}

	/*
	 * Method to retrieve a list of user details and arrange them in ascending order
	 * order according to the first name.
	 */
	@Override
	public ArrayList<UserData> findAll() {
		EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createQuery(FIND_ALL_QUERY);
		@SuppressWarnings("unchecked")
		ArrayList<UserData> list = (ArrayList<UserData>) query.getResultList();
		if (list != null)
			list.sort(Comparator.comparing(u -> u.getFirstName()));
		return list;
	}
}
