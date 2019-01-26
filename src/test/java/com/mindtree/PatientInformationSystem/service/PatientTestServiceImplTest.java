package com.mindtree.PatientInformationSystem.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.PatientInformationSystem.entity.PatientTest;
import com.mindtree.PatientInformationSystem.entity.dto.PatientTestDTO;
import com.mindtree.PatientInformationSystem.exception.PatientNotFoundException;
import com.mindtree.PatientInformationSystem.exception.TestNotFoundException;
import com.mindtree.PatientInformationSystem.repository.PatientRepository;
import com.mindtree.PatientInformationSystem.repository.PatientTestRepository;
import com.mindtree.PatientInformationSystem.repository.TestRepository;
import com.mindtree.PatientInformationSystem.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTestServiceImplTest extends TestUtil {

	@Autowired
	private PatientTestService patientService;

	@MockBean
	private PatientTestRepository patientTestRepository;

	@MockBean
	private PatientRepository patientRepository;

	@MockBean
	private TestRepository testRepository;

	@Test
	public void getAllPatientTestsTest() {
		when(patientTestRepository.findAll()).thenReturn(getPatientTestsList());
		List<PatientTest> patientTests = patientService.getAllPatientTests();
		assertNotNull(patientTests);
	}

	@Test(expected = PatientNotFoundException.class)
	public void addNewPatientTestFailureTest1() {
		patientService.addNewPatientTest(new PatientTestDTO(1L, 1L, 10, "comment"));
	}

	@Test(expected = TestNotFoundException.class)
	public void addNewPatientTestFailureTest2() {
		when(patientRepository.findById(anyLong())).thenReturn(Optional.of(getPatientsList().get(0)));
		patientService.addNewPatientTest(new PatientTestDTO(1L, 1L, 10, "comment"));
	}

	@Test
	public void addNewPatientTestSuccessTest() {
		when(patientRepository.findById(anyLong())).thenReturn(Optional.of(getPatientsList().get(0)));
		when(testRepository.findById(anyLong())).thenReturn(Optional.of(getTestsList().get(0)));
		when(patientTestRepository.save(any(PatientTest.class))).thenReturn(new PatientTest());
		patientService.addNewPatientTest(new PatientTestDTO(1L, 1L, 10, "comment"));
	}
}
