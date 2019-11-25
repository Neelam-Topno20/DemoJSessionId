package com.tal.demo.daoservices;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.tal.demo.beans.UserData;
import com.tal.demo.util.EntityManagerFactoryProvider;
public class UserDAOImpl implements UserDAO{
	EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
	@Override
	public UserData save(UserData associate) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate;
	}
	/*
	 * @Override public boolean update(Associate associate) { EntityManager
	 * entityManager = factory.createEntityManager();
	 * entityManager.getTransaction().begin(); entityManager.merge(associate);
	 * entityManager.getTransaction().commit(); entityManager.close(); return true;
	 * }
	 * 
	 * @Override public Associate findOne(int associateId) { EntityManager
	 * entityManager = factory.createEntityManager(); return
	 * entityManager.find(Associate.class,associateId); }
	 * 
	 * @Override public ArrayList<Associate> findAll() { EntityManager
	 * entityManager=factory.createEntityManager(); Query
	 * query=entityManager.createQuery("from Associate a"); ArrayList<Associate>
	 * list=(ArrayList<Associate>)query.getResultList(); return list; }
	 */
	@Override
	public boolean update(UserData associate) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public UserData findOne(String emailId) {
		EntityManager entityManager = factory.createEntityManager();
		return entityManager.find(UserData.class,emailId);
	}
	@Override
	public ArrayList<UserData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
