package com.mindtree.PatientInformationSystem.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.BeforeClass;

import com.mindtree.PatientInformationSystem.entity.Name;
import com.mindtree.PatientInformationSystem.entity.Patient;
import com.mindtree.PatientInformationSystem.entity.PatientTest;
import com.mindtree.PatientInformationSystem.entity.Test;

public class TestUtil {

	private static List<Patient> patients;
	private static List<Test> tests;
	private static List<PatientTest> patientTests;

	@BeforeClass
	public static void setup() {
		tests = Arrays.asList(new Test(1L, "Blood Group", 100), new Test(2L, "Lipid Profile", 500));

		patients = Arrays.asList(new Patient(1L, new Name("abc", "def"), LocalDate.parse("1995-12-31")),
				new Patient(2L, new Name("xyz", ""), LocalDate.parse("1999-11-21")),
				new Patient(3L, new Name("xyz", "abc"), LocalDate.parse("1999-11-21")));
	}

	public static List<Patient> getPatientsList() {
		patients.get(0).setPatientTests(
				Arrays.asList(new PatientTest(1L, patients.get(0), tests.get(0), LocalDate.parse("2018-12-31")),
						new PatientTest(3L, patients.get(0), tests.get(1), LocalDate.parse("2018-10-31"))));

		patients.get(1).setPatientTests(
				Arrays.asList(new PatientTest(1L, patients.get(1), tests.get(0), LocalDate.parse("2018-11-30"))));

		patients.get(2).setPatientTests(new ArrayList<>());
		return patients;
	}

	public static List<Test> getTestsList() {
		return tests;
	}

	public static List<PatientTest> getPatientTestsList() {
		getPatientsList();
		patientTests = patients.stream().flatMap(patient -> patient.getPatientTests().stream())
				.collect(Collectors.toList());
		return patientTests;
	}

	public static List<Patient> getPatientsList1() {
		patients.forEach(patient -> patient.setPatientTests(null));
		return patients;
	}
}
