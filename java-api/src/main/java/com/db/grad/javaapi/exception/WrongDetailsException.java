package com.db.grad.javaapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongDetailsException extends Exception {
	 private static final long serialVersionUID = 1L;

	 public WrongDetailsException(String message){
	    super(message);
	 }
}
