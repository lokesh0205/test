package com.mindtree.PatientInformationSystem.service.impl;

import static com.mindtree.PatientInformationSystem.constants.PatientInformationSystemConstants.DATE_FORMAT;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.PatientInformationSystem.entity.Patient;
import com.mindtree.PatientInformationSystem.entity.PatientTest;
import com.mindtree.PatientInformationSystem.entity.Test;
import com.mindtree.PatientInformationSystem.entity.dto.PatientDTO;
import com.mindtree.PatientInformationSystem.repository.PatientRepository;
import com.mindtree.PatientInformationSystem.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired	private PatientRepository patientRepository;

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public List<PatientDTO> getAllPatientDTOs() {
		List<PatientDTO> patientDTOs = new ArrayList<>();
		List<Patient> patients = patientRepository.findAll();
		patients.forEach(patient -> {
			PatientDTO patientDTO = new PatientDTO();
			List<PatientTest> patientTests = patient.getPatientTests();
			if (!patientTests.isEmpty()) {
				patientDTO.setTests(patientTests.stream()
												.map(PatientTest::getTest)
												.collect(Collectors.toList())
												);
				patientDTO.setTotalCost(patientDTO.getTests().stream()
 					 				 						 .mapToInt(Test::getCost)
 					 				 						 .sum()
 					 				 						 );
				patientDTO.setTestDate(patientTests.get(patientTests.size() - 1).getTestDate().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
				patientDTO.setAge(Period.between(patient.getDob(), LocalDate.now()).getYears());
				patientDTO.setPatientName(patient.getPatientName());
				patientDTOs.add(patientDTO);
			}
		});
		return patientDTOs;
	}
}
