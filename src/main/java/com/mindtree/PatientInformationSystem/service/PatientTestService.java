package com.mindtree.PatientInformationSystem.service;

import java.util.List;

import com.mindtree.PatientInformationSystem.entity.PatientTest;
import com.mindtree.PatientInformationSystem.entity.dto.PatientTestDTO;

public interface PatientTestService {

	List<PatientTest> getAllPatientTests();

	void addNewPatientTest(PatientTestDTO patientTestDTO);

	public static String getErrorField(String errorField) {
		switch (errorField) {
		case "patientId":
			return "Patient";
		case "testId":
			return "Test";
		case "value":
			return "Value";
		default:
			return "Comment";
		}
	}
}
