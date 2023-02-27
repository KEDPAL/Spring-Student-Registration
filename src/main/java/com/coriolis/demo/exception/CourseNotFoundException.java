package com.coriolis.demo.exception;

public class CourseNotFoundException extends RuntimeException {

	private String message;

	public CourseNotFoundException() {}

	public CourseNotFoundException(String msg)
	{
		super(msg);
		this.message = msg;
	}

}
