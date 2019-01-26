package com.mindtree.PatientInformationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TestNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4628690865453882172L;
}
