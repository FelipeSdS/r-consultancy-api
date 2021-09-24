package br.com.rconsultancy.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.rconsultancy.dto.exception.ExceptionResponseDTO;
import br.com.rconsultancy.exception.NotRecordFoundException;


@RestControllerAdvice
public class RestExceptionHandler {

	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotRecordFoundException.class)
	public ResponseEntity<ExceptionResponseDTO> notRecordFoundException(NotRecordFoundException exception, WebRequest request){
		ExceptionResponseDTO exdto = new ExceptionResponseDTO(LocalDateTime.now(), 404, HttpStatus.NOT_FOUND.toString(), 
																exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponseDTO>(exdto, HttpStatus.NOT_FOUND);
	}


}
