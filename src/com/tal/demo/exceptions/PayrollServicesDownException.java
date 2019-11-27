package com.tal.demo.exceptions;
public class PayrollServicesDownException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PayrollServicesDownException() {
		super();
	}
	public PayrollServicesDownException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		}
	public PayrollServicesDownException(String message, Throwable cause) {
		super(message, cause);
		}
	public PayrollServicesDownException(String message) {
		super(message);
		}
	public PayrollServicesDownException(Throwable cause) {
		super(cause);
		}
	public String getErrorCode() {
		return null;
	}
}
