package com.tal.demo.exceptions;
public class UserServicesDownException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserServicesDownException() {
		super();
	}
	public UserServicesDownException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		}
	public UserServicesDownException(String message, Throwable cause) {
		super(message, cause);
		}
	public UserServicesDownException(String message) {
		super(message);
		}
	public UserServicesDownException(Throwable cause) {
		super(cause);
		}
	public String getErrorCode() {
		return null;
	}
}
