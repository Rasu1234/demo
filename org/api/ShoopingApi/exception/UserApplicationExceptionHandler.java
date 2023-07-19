package org.api.ShoopingApi.exception;

import org.api.ShoopingApi.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UserApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(idNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFountException(idNotFoundException exception){
		ResponseStructure<String> s = new ResponseStructure<String>();
		s.setBody("User not Found");
		s.setMessage(exception.getMessage());
		s.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);

	}
}