package main.com.tal.demo.util;
import static main.com.tal.demo.constants.UserConstants.PERSISTENCE_UNIT;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class EntityManagerFactoryProvider {
	public static EntityManagerFactory factory=null;
	public static EntityManagerFactory getEntityManagerFactory(){
		if(factory==null)
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		return factory;
	}
}
