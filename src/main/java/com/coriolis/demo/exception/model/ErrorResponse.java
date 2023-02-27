package com.coriolis.demo.exception.model;

public class ErrorResponse {
 
    private int statusCode;
    private String message;
    
	public ErrorResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
 
    
   
}