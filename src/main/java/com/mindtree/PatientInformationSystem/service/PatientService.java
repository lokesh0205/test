package com.mindtree.PatientInformationSystem.service;

import java.util.List;

import com.mindtree.PatientInformationSystem.entity.Patient;
import com.mindtree.PatientInformationSystem.entity.dto.PatientDTO;

public interface PatientService {

	List<Patient> getAllPatients();

	List<PatientDTO> getAllPatientDTOs();
}
