package com.innominds.exceptions;

public class ServiceException extends Exception {

	private String errorCode;
	private String errorMessage;
		
	public ServiceException() {
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceException ( String errorCode , String errorMessage )
	{
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
}
