package com.tal.demo.daoservices;
import java.util.ArrayList;
import java.util.Comparator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.tal.demo.beans.UserData;
import com.tal.demo.util.EntityManagerFactoryProvider;
public class UserDAOImpl implements UserDAO{
	EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
	EntityManager entityManager = factory.createEntityManager();
	@Override
	public UserData save(UserData associate) {
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate;
	}

	@Override
	public boolean update(UserData user) {
		try{
		entityManager.getTransaction().begin(); 
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		entityManager.close(); 
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public UserData findOne(String emailId) {
		return entityManager.find(UserData.class,emailId);
	}
	@Override
	public ArrayList<UserData> findAll() {
		Query query=entityManager.createQuery("from Associate a"); 
		@SuppressWarnings("unchecked")
		ArrayList<UserData> list=(ArrayList<UserData>)query.getResultList();
		list.sort(Comparator.comparing( u -> u.getFirstName()));
		return list;
	}
}
