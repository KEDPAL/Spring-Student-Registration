package com.coriolis.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.coriolis.demo.exception.model.ErrorResponse;

@ControllerAdvice 
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE) 
public class GlobalControllerAdvice {

	@ExceptionHandler(value = CourseNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleException(CourseNotFoundException ex)
	{
		return new ErrorResponse(
				HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
}
