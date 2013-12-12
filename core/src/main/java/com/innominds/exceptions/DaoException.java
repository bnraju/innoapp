package com.innominds.exceptions;

public class DaoException extends Exception {

	private String errorCode;
	private String errorMessage;
	
	public DaoException() {
		// TODO Auto-generated constructor stub
	}

	public DaoException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DaoException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public DaoException ( String errorCode , String errorMessage)
	{
		this.errorCode = errorCode;
		this.errorMessage =  errorMessage;
	}

}
