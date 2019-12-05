package main.com.tal.demo.daoservices;

import static main.com.tal.demo.constants.UserConstants.FIND_ALL_QUERY;

import java.util.Comparator;
import java.util.List;

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
			UserData user2 = entityManager.merge(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			if (user2 == null)
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
		UserData user = entityManager.find(UserData.class, emailId);
		if (user != null)
			return user;
		else
			return null;
	}

	/*
	 * Method to retrieve a list of user details and arrange them in ascending order
	 * order according to the first name.
	 */
	@Override
	public List<UserData> findAll() {
		EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createQuery(FIND_ALL_QUERY);
		@SuppressWarnings("unchecked")
		List<UserData> list = query.getResultList();
		if (list != null)
			list.sort(Comparator.comparing(u -> u.getFirstName()));
		return list;
	}
}
