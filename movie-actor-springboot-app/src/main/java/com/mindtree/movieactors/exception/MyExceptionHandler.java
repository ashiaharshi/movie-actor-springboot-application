package com.mindtree.movieactors.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(ControllerException.class)
	public ResponseEntity<?> sourceNotFound(ControllerException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST);
	}
	
}
