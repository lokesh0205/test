package com.mindtree.PatientInformationSystem.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mindtree.PatientInformationSystem.exception.PatientNotFoundException;
import com.mindtree.PatientInformationSystem.exception.TestNotFoundException;
import com.mindtree.PatientInformationSystem.repository.PatientRepository;
import com.mindtree.PatientInformationSystem.repository.PatientTestRepository;
import com.mindtree.PatientInformationSystem.repository.TestRepository;
import com.mindtree.PatientInformationSystem.service.PatientService;
import com.mindtree.PatientInformationSystem.service.PatientTestService;
import com.mindtree.PatientInformationSystem.service.TestService;
import com.mindtree.PatientInformationSystem.util.TestUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(useDefaultFilters = true)
public class TemplateControllerTest extends TestUtil {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PatientTestService patientTestService;

	@MockBean
	private PatientTestRepository patientTestRepository;

	@MockBean
	private PatientService patientService;

	@MockBean
	PatientRepository patientRepository;

	@MockBean
	private TestService testService;

	@MockBean
	private TestRepository testRepository;

	@Test
	public void hospitalHomePageTest() throws Exception {
		mockMvc.perform(get("/hospital/home")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	public void addTestDetailsTest() throws Exception {
		when(patientService.getAllPatients()).thenReturn(getPatientsList1());
		when(testService.getAllTests()).thenReturn(getTestsList());
		mockMvc.perform(get("/hospital/addTestDetails")).andExpect(status().isOk()).andExpect(view().name("testForm"))
				.andExpect(model().attribute("patients", is(getPatientsList1())))
				.andExpect(model().attribute("tests", is(getTestsList())));
	}

	@Test
	public void viewPatientDiagnosticTestReportTest() throws Exception {
		mockMvc.perform(get("/hospital/viewReport")).andExpect(status().isOk())
				.andExpect(view().name("viewDiagnosticReport"));
	}

	@Test
	public void addNewPatientTestAndRedirectIncorrectPatientFailureTest() throws Exception {
		mockMvc.perform(post("/hospital/home").contentType(MediaType.APPLICATION_JSON_UTF8).param("patientId", "")
				.param("testId", "1").param("value", "10").param("comment", "abc")).andExpect(status().isOk())
				.andExpect(view().name("index")).andExpect(model().attribute("incorrectField", is("Patient")));
	}

	@Test
	public void addNewPatientTestAndRedirectIncorrectTestFailureTest() throws Exception {
		mockMvc.perform(post("/hospital/home").contentType(MediaType.APPLICATION_JSON_UTF8).param("patientId", "1")
				.param("testId", "").param("value", "10").param("comment", "abc")).andExpect(status().isOk())
				.andExpect(view().name("index")).andExpect(model().attribute("incorrectField", is("Test")));
	}

	@Test
	public void addNewPatientTestAndRedirectIncorrectValueFailureTest() throws Exception {
		mockMvc.perform(post("/hospital/home").contentType(MediaType.APPLICATION_JSON_UTF8).param("patientId", "1")
				.param("testId", "1").param("value", "").param("comment", "abc")).andExpect(status().isOk())
				.andExpect(view().name("index")).andExpect(model().attribute("incorrectField", is("Value")));
	}

	@Test
	public void addNewPatientTestAndRedirectIncorrectCommentFailureTest() throws Exception {
		mockMvc.perform(post("/hospital/home").contentType(MediaType.APPLICATION_JSON_UTF8).param("patientId", "1")
				.param("testId", "1").param("value", "10").param("comment", "")).andExpect(status().isOk())
				.andExpect(view().name("index")).andExpect(model().attribute("incorrectField", is("Comment")));
	}

	@Test
	public void addNewPatientTestAndRedirectSuccessTest() throws Exception {
		mockMvc.perform(post("/hospital/home").contentType(MediaType.APPLICATION_JSON_UTF8).param("patientId", "1")
				.param("testId", "1").param("value", "10").param("comment", "abc")).andExpect(status().isOk())
				.andExpect(view().name("index")).andExpect(model().attribute("success", is("success")));
	}

	@Test
	public void redirectToHospitalHomePageIfEmptyTest() throws Exception {
		mockMvc.perform(get("")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/hospital/home"));
	}

	@Test
	public void redirectToHospitalHomePageTest() throws Exception {
		mockMvc.perform(get("/garbage")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/hospital/home"));
	}

	@Test
	public void patientNotFoundExceptionTest() throws Exception {
		doThrow(PatientNotFoundException.class).when(patientTestService).addNewPatientTest(any());
		mockMvc.perform(post("/hospital/home").contentType(MediaType.APPLICATION_JSON_UTF8).param("patientId", "1")
				.param("testId", "1").param("value", "10").param("comment", "abc")).andExpect(status().isNotFound());
	}
	
	@Test
	public void testNotFoundExceptionTest() throws Exception {
		doThrow(TestNotFoundException.class).when(patientTestService).addNewPatientTest(any());
		mockMvc.perform(post("/hospital/home").contentType(MediaType.APPLICATION_JSON_UTF8).param("patientId", "1")
				.param("testId", "1").param("value", "10").param("comment", "abc")).andExpect(status().isNotFound());
	}
}
