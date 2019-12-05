package main.com.tal.demo.daoservices;
import java.util.List;

import main.com.tal.demo.beans.UserData;
public interface UserDAO {
	UserData save(UserData associate);
	public boolean update(UserData associate);
	UserData findOne(String emailId);
	List<UserData> findAll();
}