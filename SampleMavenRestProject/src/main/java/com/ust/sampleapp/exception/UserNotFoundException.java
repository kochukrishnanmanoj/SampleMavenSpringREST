package com.ust.sampleapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User Not Found") 
public class UserNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5572975554340692243L;

	public UserNotFoundException(int id){
		super("UserNotFoundException with id="+id);
		System.out.println("Inside user not found exception"+id);
	}	
	
}
