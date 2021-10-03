package com.cucumberFramework.helper;

public class MyException extends Exception {

	/* <---------- Throw My Own Exceptions ---------> */
	public MyException(String errorMessage) {
		super(errorMessage);
	}

}