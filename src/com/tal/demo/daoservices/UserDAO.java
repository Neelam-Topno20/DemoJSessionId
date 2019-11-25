package com.tal.demo.daoservices;
import java.util.ArrayList;

import com.tal.demo.beans.UserData;
public interface UserDAO {
	UserData save(UserData associate);
	public boolean update(UserData associate);
	UserData findOne(String emailId);
	ArrayList<UserData> findAll();
}