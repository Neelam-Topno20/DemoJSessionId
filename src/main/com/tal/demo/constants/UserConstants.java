package main.com.tal.demo.constants;

public interface UserConstants {

	public static final String FIND_ALL_QUERY="from UserData u";
	public static final String USER_DETAILS_NOT_FOUND_MESSAGE="User Details Not Found";
	public static final String USER_DETAILS_LIST_NOT_FOUND_MESSAGE="List of User Details Not Found";
	public static final String USER_SERVICES_DOWN_MESSAGE="User Services are Down";
	public static final String LOGIN_FAILED_MESSAGE="<font color=red>Either user name or password is wrong.</font>";
	public static final String USER_UPDATE_FAILED_MESSAGE="<font color=red>Could not update the Details</font>";
	public static final String PROPERTIES_FILE_PATH=".//resources//demojsessionid.properties";
	public static final String PERSISTENCE_UNIT="h2-eclipselink";

}
