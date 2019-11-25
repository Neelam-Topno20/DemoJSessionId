package com.tal.demo.exceptions;

public class UserDetailsNotFoundException extends Exception {

	public UserDetailsNotFoundException() {
		super();
	}
	public UserDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public UserDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public UserDetailsNotFoundException(String message) {
		super(message);
	}
	public UserDetailsNotFoundException(Throwable cause) {
		super(cause);
	}
}
