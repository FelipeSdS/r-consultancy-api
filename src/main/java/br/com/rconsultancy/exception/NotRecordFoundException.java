package br.com.rconsultancy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotRecordFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotRecordFoundException(String message) {
		super(message);
	}	
}