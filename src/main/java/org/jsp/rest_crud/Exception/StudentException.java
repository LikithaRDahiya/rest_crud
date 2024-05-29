package org.jsp.rest_crud.Exception;

import org.jsp.rest_crud.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentException  {
	
	@Autowired
	ResponseStructure structure;
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseStructure> notFound(DataNotFoundException e) {
		structure.setData(e.getMessage());
		structure.setMessage("data not present");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure>(structure, HttpStatus.FOUND);
	}
}
