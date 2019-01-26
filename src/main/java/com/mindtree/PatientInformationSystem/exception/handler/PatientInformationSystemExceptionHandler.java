package com.mindtree.PatientInformationSystem.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.PatientInformationSystem.exception.PatientNotFoundException;
import com.mindtree.PatientInformationSystem.exception.TestNotFoundException;
import com.mindtree.PatientInformationSystem.exception.response.ExceptionResponse;

@RestControllerAdvice
public class PatientInformationSystemExceptionHandler {
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handlePatientNotFoundException(PatientNotFoundException ex) {
		return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now(), "The requested Patient was not found."), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TestNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleTestNotFoundException(TestNotFoundException ex) {
		return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now(), "The requested Test was not found."), HttpStatus.NOT_FOUND);
	}
}
