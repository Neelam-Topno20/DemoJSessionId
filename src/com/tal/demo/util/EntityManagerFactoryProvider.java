package com.tal.demo.util;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static com.tal.demo.constants.UserConstants.PERSISTENCE_UNIT;
public class EntityManagerFactoryProvider {
	public static EntityManagerFactory factory=null;
	public static EntityManagerFactory getEntityManagerFactory(){
		if(factory==null)
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		return factory;
	}
}
