package com.mindtree.PatientInformationSystem.controller;

import static com.mindtree.PatientInformationSystem.constants.PatientInformationSystemConstants.URI_ADD_TEST_DETAILS;
import static com.mindtree.PatientInformationSystem.constants.PatientInformationSystemConstants.URI_HOME;
import static com.mindtree.PatientInformationSystem.constants.PatientInformationSystemConstants.URI_HOSPITAL;
import static com.mindtree.PatientInformationSystem.constants.PatientInformationSystemConstants.URI_VIEW_REPORT;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.PatientInformationSystem.entity.dto.PatientTestDTO;
import com.mindtree.PatientInformationSystem.service.PatientService;
import com.mindtree.PatientInformationSystem.service.PatientTestService;
import com.mindtree.PatientInformationSystem.service.TestService;

@Controller
@RequestMapping(URI_HOSPITAL)
public class TemplateController {

	private static final Logger LOG = LogManager.getLogger(TemplateController.class);

	@Autowired	private PatientTestService patientTestService;

	@Autowired	private PatientService patientService;

	@Autowired	private TestService testService;

	@GetMapping(URI_HOME)
	public String goToHospitalHomePage() {
		LOG.debug("");
		return "index";
	}

	@GetMapping(URI_ADD_TEST_DETAILS)
	public String addTestDetails(Model model) {
		model.addAttribute("patientTestDTO", new PatientTestDTO());
		model.addAttribute("patients", patientService.getAllPatients());
		model.addAttribute("tests", testService.getAllTests());
		return "testForm";
	}

	@GetMapping(URI_VIEW_REPORT)
	public String viewPatientDiagnosticTestReport(Model model) {
		model.addAttribute("patientDTOs", patientService.getAllPatientDTOs());
		return "viewDiagnosticReport";
	}

	@PostMapping(URI_HOME)
	public String addNewPatientTestAndRedirect(@Valid @ModelAttribute PatientTestDTO patientTestDTO,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("incorrectField", PatientTestService.getErrorField(result.getFieldError().getField()));
		} else {
			model.addAttribute("success", "success");
			patientTestService.addNewPatientTest(patientTestDTO);
		}
		return "index";
	}
}
