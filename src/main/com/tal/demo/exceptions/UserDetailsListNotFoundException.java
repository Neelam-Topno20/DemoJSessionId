package main.com.tal.demo.exceptions;

public class UserDetailsListNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDetailsListNotFoundException() {
		super();
	}

	public UserDetailsListNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UserDetailsListNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserDetailsListNotFoundException(String arg0) {
		super(arg0);
	}

	public UserDetailsListNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
