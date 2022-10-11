package com.example.demo.API_Exception;

public class Exception_catching extends  RuntimeException
{
	public Exception_catching(String mess) {
	super(mess);
	}
  public Exception_catching(String message, Throwable cause) {
        super(message, cause);
    }

}
