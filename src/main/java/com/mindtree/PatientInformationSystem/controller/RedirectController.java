package com.mindtree.PatientInformationSystem.controller;

import static com.mindtree.PatientInformationSystem.constants.PatientInformationSystemConstants.REDIRECT_URI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * This controller is used for redirecting empty or wildcard URLs to home page.
 */
@Controller
public class RedirectController {

	@GetMapping("")
	public String redirectToHospitalHomePageIfEmpty() {
		return REDIRECT_URI;
	}

	@GetMapping("**")
	public String redirectToHospitalHomePage() {
		return REDIRECT_URI;
	}
}
