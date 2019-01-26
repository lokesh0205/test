package com.mindtree.PatientInformationSystem.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.PatientInformationSystem.entity.Patient;
import com.mindtree.PatientInformationSystem.entity.dto.PatientDTO;
import com.mindtree.PatientInformationSystem.repository.PatientRepository;
import com.mindtree.PatientInformationSystem.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest extends TestUtil {

	@Autowired
	PatientService patientService;

	@MockBean
	PatientRepository patientRepository;

	@Test
	public void getAllPatientsTest() {
		when(patientRepository.findAll()).thenReturn(getPatientsList());
		List<Patient> patients = patientService.getAllPatients();
		assertNotNull(patients);
	}

	@Test
	public void getAllPatientDTOsTest() {
		when(patientRepository.findAll()).thenReturn(getPatientsList());
		List<PatientDTO> patientDTOs = patientService.getAllPatientDTOs();
		assertNotNull(patientDTOs);
	}
}
