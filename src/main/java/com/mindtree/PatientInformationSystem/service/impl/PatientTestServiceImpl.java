package com.mindtree.PatientInformationSystem.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.PatientInformationSystem.entity.PatientTest;
import com.mindtree.PatientInformationSystem.entity.dto.PatientTestDTO;
import com.mindtree.PatientInformationSystem.exception.PatientNotFoundException;
import com.mindtree.PatientInformationSystem.exception.TestNotFoundException;
import com.mindtree.PatientInformationSystem.repository.PatientRepository;
import com.mindtree.PatientInformationSystem.repository.PatientTestRepository;
import com.mindtree.PatientInformationSystem.repository.TestRepository;
import com.mindtree.PatientInformationSystem.service.PatientTestService;

@Service
public class PatientTestServiceImpl implements PatientTestService {

	@Autowired	private PatientTestRepository patientTestRepository;

	@Autowired	private PatientRepository patientRepository;

	@Autowired	private TestRepository testRepository;

	@Override
	public List<PatientTest> getAllPatientTests() {
		return patientTestRepository.findAll();
	}

	@Override
	public void addNewPatientTest(PatientTestDTO patientTestDTO) {
		PatientTest patientTest = new PatientTest();
		patientTest.setPatient(patientRepository.findById(patientTestDTO.getPatientId()).orElseThrow(PatientNotFoundException::new));
		patientTest.setTest(testRepository.findById(patientTestDTO.getTestId()).orElseThrow(TestNotFoundException::new));
		patientTest.setTestDate(LocalDate.now());
		patientTestRepository.save(patientTest);
	}
}
