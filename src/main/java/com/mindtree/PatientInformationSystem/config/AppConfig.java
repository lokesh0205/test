package com.mindtree.PatientInformationSystem.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mindtree.PatientInformationSystem.entity.Name;
import com.mindtree.PatientInformationSystem.entity.Patient;
import com.mindtree.PatientInformationSystem.entity.PatientTest;
import com.mindtree.PatientInformationSystem.entity.Test;
import com.mindtree.PatientInformationSystem.repository.PatientRepository;
import com.mindtree.PatientInformationSystem.repository.PatientTestRepository;
import com.mindtree.PatientInformationSystem.repository.TestRepository;

@Configuration
public class AppConfig {

	@Autowired	private PatientTestRepository patientTestRepository;

	@Autowired	private PatientRepository patientRepository;

	@Autowired	private TestRepository testRepository;

	/*
	 * This bean is used to persist Patient and Test data in database on startup.
	 */
	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Patient> patients = Arrays.asList(
					new Patient(new Name("Mohan"  , "Nambiar"), LocalDate.parse("1985-12-31")),
					new Patient(new Name("Khalid" , ""		 ), LocalDate.parse("1989-11-21")),
					new Patient(new Name("Marshal", "Mathers"), LocalDate.parse("1980-10-11")),
					new Patient(new Name("Nopom"  , "Bert"	 ), LocalDate.parse("1975-01-12"))
					);

			List<Test> tests = Arrays.asList(
					new Test("Blood Group"  , 100 ),
					new Test("Lipid Profile", 500 ),
					new Test("ECG"          , 1000),
					new Test("Sugar test"   , 250 )
					);

			List<PatientTest> patientTests = Arrays.asList(
					new PatientTest(patients.get(0), tests.get(0), LocalDate.of(2018, Month.JUNE, 2)),
					new PatientTest(patients.get(0), tests.get(2), LocalDate.of(2018, Month.JUNE, 2)),
					new PatientTest(patients.get(1), tests.get(1), LocalDate.of(2018, Month.DECEMBER, 6))
					);

			patientTestRepository.saveAll(patientTests);
			/*
			 * Persists the remaining unsaved/unused patients in the database if any.
			 */
			patientRepository.saveAll(patients.stream()
											  .filter(patient -> patient.getPatientId() == null)
											  .collect(Collectors.toList())
											  );
			/*
			 * Persists the remaining unsaved/unused tests in the database if any.
			 */
			testRepository.saveAll(tests.stream()
						 				.filter(test -> test.getTestId() == null)
						 				.collect(Collectors.toList())
						 				);
		};
	}
}
