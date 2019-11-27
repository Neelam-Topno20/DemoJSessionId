package com.tal.demo.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import static com.tal.demo.constants.UserConstants.PROPERTIES_FILE_PATH;
public class ConnectionProvider {
	private static Connection conn;
	public static Connection getDBConnection(){
		try{
			Properties dbProperties = new Properties();
			dbProperties.load(new FileInputStream(new File(PROPERTIES_FILE_PATH)));
			String driver = dbProperties.getProperty("driver");
			String url = dbProperties.getProperty("url");
			String user = dbProperties.getProperty("user");
			String password = dbProperties.getProperty("password");
			Class.forName(driver);
			conn= DriverManager.getConnection(url, user, password);
			return conn;
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
