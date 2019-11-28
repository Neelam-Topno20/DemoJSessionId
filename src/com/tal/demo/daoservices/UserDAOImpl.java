package com.tal.demo.daoservices;

import java.util.ArrayList;
import java.util.Comparator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.tal.demo.beans.UserData;
import com.tal.demo.util.EntityManagerFactoryProvider;

import static com.tal.demo.constants.UserConstants.FIND_ALL_QUERY;;

public class UserDAOImpl implements UserDAO {
	EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
	EntityManager entityManager = factory.createEntityManager();

	/*
	 * Method to persist user details
	 */
	@Override
	public UserData save(UserData user) {
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
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(user);
			entityManager.getTransaction().commit();
			entityManager.close();
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
		return entityManager.find(UserData.class, emailId);
	}

	/*
	 * Method to retrieve a list of user details and arrange them in ascending order
	 * order according to the first name.
	 */
	@Override
	public ArrayList<UserData> findAll() {
		Query query = entityManager.createQuery(FIND_ALL_QUERY);
		@SuppressWarnings("unchecked")
		ArrayList<UserData> list = (ArrayList<UserData>) query.getResultList();
		list.sort(Comparator.comparing(u -> u.getFirstName()));
		return list;
	}
}
